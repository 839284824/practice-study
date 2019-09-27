package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jolokia.util.Base64Util;
import util.user.GroupDTO;
import util.user.RolesDTO;
import util.user.UserDTO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by pigsoldier on 16/10/26.
 */
@Slf4j
public class OctoUtil {


    public static String url = "http://172.20.188.55";
    public static String testUrl = "http://10.165.126.103:8000";
    public static String octoKey = "080618ee542149dfb4e2e58a94c29567";
    public static String testOctoKey = "3fef8e6a8fce4ca793928e3d1ff2c031";
    public static String octoSecret = "2a11b11434a8480e874dd0a198e2e03d";
    public static String testOctoSecret = "5da3e5e6b37449d3a526c254c9727b79";


    public static void main(String[] b) {
//        log.info("销售信息:{}", getUserInfo(49839, false));
        log.info("销售信息:{}", queryGroupSales(49839L));
//        log.info("销售主管下的销售:{}", getSuperiorSaleLevel(null, null, 703));
//        log.info("searchUsers:{}", searchUsers(null, null, false));

    }


    /**
     * 查询销售主管下的销售
     *
     * @param conditions
     * @param filter
     * @param superiors
     * @return
     */
    public static List<UserDTO> getSuperiorSaleLevel(Map<String, List<String>> conditions, String filter, Integer... superiors) {
        if (superiors == null || superiors.length == 0) {
            return null;
        }
        StringBuilder searchSB = new StringBuilder();
        if (conditions != null && !conditions.isEmpty()) {
            conditions.forEach((k, v) -> {
                if (v == null || v.isEmpty()) {
                    return;
                }
                v.forEach(search -> {
                    searchSB.append(k).append(":").append(search).append(";");
                });
            });
        }
        StringBuilder sb = new StringBuilder();
        for (Integer superior : superiors) {
            sb.append(superior).append(",");
        }
        String octoToken = OctoUtil.getOctoToken(testOctoKey, testOctoSecret);
        Map<String, String> param = new HashMap<>();
        param.put("ids", sb.toString());
        param.put("_octo", octoToken);
        param.put("level", "10");
        if (StringUtils.isNotBlank(filter)) {
            param.put("filter", filter);
        }
        if (searchSB.length() > 0) {
            param.put("search", searchSB.toString());
        }
        param.put("orderBy", "username");
        param.put("sortBy", "desc");
        param.put("version", "v2");
        //auth升级
        //param.put("version", "v2");
        String result = new HttpClientUtils().httpGet(testUrl + "/auth/superior/" + sb.toString() + "/users", param);
        if (StringUtils.isBlank(result)) {
            log.error("searchUsers error: conditions:", JSON.toJSONString(superiors));
            return null;
        }
        List<UserDTO> userDTOS = FastJsonUtils.parseJsonArray(result, UserDTO.class);
        if (userDTOS == null) {
            log.error("getSuperiorSale 返回为空！: conditions:", JSON.toJSONString(superiors));
            return null;
        }
        return userDTOS;
    }


    /**
     * 查询销售信息
     * with=group，获取账号分组数据，组长也在其中(老superior_id逐渐废弃)
     *
     * @param salesId 销售id
     * @param trashed 是否查询已删除销售
     * @return
     */
    public static UserDTO getUserInfo(Integer salesId, Boolean trashed) {
        try {
            if (salesId == null || salesId < 0) {
                return null;
            }
            String octoToken = OctoUtil.getOctoToken(octoKey, octoSecret);
            Map<String, String> param = new HashMap<>();
            param.put("id", salesId.toString());
            param.put("filter", "id;name;user_id;username;mobile;city;multi_city;cities;fakeCities;role");
            param.put("with", "roles;group");
            param.put("trashed", trashed.toString());
            param.put("_octo", octoToken);
            String jsonStr = new HttpClientUtils().httpGet(url + "/auth/users/" + salesId, param);
            if (StringUtils.isBlank(jsonStr)) {
                log.error("getUserInfo error: sale_id:", salesId);
                return null;
            }
            UserDTO userDTO = FastJsonUtils.parseJson(jsonStr, UserDTO.class);
            if (userDTO == null) {
                log.error("getUserInfo error: sale_id:", salesId);
                return null;
            }
            Integer id = userDTO.getId();
            if (id == null || id <= 0) {
                return null;
            }
            return userDTO;
        } catch (Exception e) {
            log.error("getUserInfo->getUserInfo", e);
        }
        return null;
    }

    /**
     * 查询用户
     *
     * @param filter
     * @param with
     * @param trashed
     * @return
     */
    public static List<UserDTO> searchUsers(String filter, String with, Boolean trashed) {
        Map<String, List<String>> conditions = new HashMap<>();
        conditions.put("role", Lists.newArrayList("cpSales"));
        StringBuilder searchSB = new StringBuilder();
        conditions.forEach((k, v) -> {
            if (v == null || v.isEmpty()) {
                return;
            }
            v.forEach(search -> {
                searchSB.append(k).append(":").append(search).append(";");
            });
        });
        Map<String, String> param = new HashMap<>();
        String octoToken = OctoUtil.getOctoToken(octoKey, octoSecret);
        if (StringUtils.isNotBlank(filter)) {
            param.put("filter", filter);
        }
        if (StringUtils.isNotBlank(with)) {
            param.put("with", with);
        }
        param.put("trashed", trashed.toString());
        param.put("search", searchSB.toString());
        param.put("orderBy", "username");
        param.put("sortBy", "desc");
        param.put("_octo", octoToken);
        String result = new HttpClientUtils().httpPostForm(url + "/auth/users/search?_octo=" + octoToken, param);
        if (StringUtils.isBlank(result)) {
            log.error("searchUsers error: conditions:", JSON.toJSONString(conditions));
            return null;
        }
        List<UserDTO> userDTOS = FastJsonUtils.parseJsonArray(result, UserDTO.class);
        if (userDTOS == null) {
            log.error("searchUsers 返回为空！: conditions:", JSON.toJSONString(conditions));
            return null;
        }
        return userDTOS;
    }

    public static String getOctoToken(String octoKey, String octoSecret) {
        try {
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");

            Date begin = new Date();
            Date end = new Date(begin.getTime() + 2000000);

            String result = Jwts.builder().setHeader(header).setIssuer(octoKey).setIssuedAt(begin).setExpiration(end).signWith(SignatureAlgorithm.HS256, Base64Util.encode(octoSecret.getBytes("UTF-8"))).compact();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * http://wiki.shanyishanmei.com/pages/viewpage.action?pageId=4010848
     * ugroups?with=users.roles&search=group_leader_id:101012
     * 根据组长id查询该组的所有销售
     *
     * @return
     */
    public static List<UserDTO> queryGroupSales(Long groupId) {
        String octoToken = OctoUtil.getOctoToken(octoKey, octoSecret);
        String url1 = url + "/auth/ugroups?_octo=" + octoToken + "&with=" + "users.roles;leader_info.roles" + "&search=group_leader_id:" + groupId + ";users.roles:cpSales";
        String result = new HttpClientUtils().httpGet(url1);
        if (StringUtils.isBlank(result)) {
            return null;
        }
        List<GroupDTO> groupDTOS = JSONArray.parseArray(result, GroupDTO.class);
        if (groupDTOS == null || groupDTOS.isEmpty()) {
            return null;
        }
        List<UserDTO> sales = new ArrayList<>();
        for (GroupDTO groupDTO : groupDTOS) {
            List<UserDTO> users = groupDTO.getUsers();
            if (users != null) {
                sales.addAll(users);
            }
        }
        //多个组的组长都是一样的，拿第一个组长信息 判断组长是不是 合伙人销售是得加进去
        GroupDTO groupDTO = groupDTOS.get(0);
        UserDTO leaderInfo = groupDTO.getLeaderInfo();
        if (leaderInfo != null) {
            List<RolesDTO> roles = leaderInfo.getRoles();
            if (roles != null) {
                List<String> collect = roles.stream().map(RolesDTO::getTitle).collect(Collectors.toList());
                if (collect.contains("cpSales")) {
                    sales.add(leaderInfo);
                }
            }
        }

        return sales;
    }


}