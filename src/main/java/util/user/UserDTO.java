package util.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * auth 服务的用户
 *
 * @author zhangguangliang
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 2184875495369879640L;

    private Integer id;
    /**
     * 用户名字
     */
    private String name;

    private String username;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 城市
     */
    private String city;

    private String cityArea;

    private String role;

    private String multiCity;

    private Date deletedAt;
    /**
     * 组长id auth 升级该字段不可用
     */
    //private Integer superiorId;
    /**
     * 角色
     */
    private List<RolesDTO> roles;

    private List<String> fakeCities;

    private List<CitiesDTO> cities;
    /**
     * 获取账号分组数据，组长也在其中(老superior_id逐渐废弃)
     */
    private List<GroupDTO> group;

}
