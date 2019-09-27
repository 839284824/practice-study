package com.renrenche.sales.mismanage.dto.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.renrenche.sales.mismanage.common.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * "roles":[
 * {
 * "id":37,
 * "title":"SALES",
 * "name":"带看销售",
 * "description":null,
 * "created_at":"2016-04-23 16:18:01",
 * "updated_at":"2016-04-23 16:18:01",
 * "deleted_at":null,
 * "pivot":{
 * "user_id":30336,
 * "role_id":37
 * }
 * }
 * ]
 * 销售用户的角色
 *
 * @author zhangguangliang
 */
@Data
public class RolesDTO implements Serializable {

    private Integer id;
    /**
     * "SALES",
     */
    private String title;
    /**
     * "name":"带看销售",
     */
    private String name;

    private String description;


    @JSONField(format = DateUtils.DATE_FORMAT_FULL_STRING)
    private Date createdAt;
    @JSONField(format = DateUtils.DATE_FORMAT_FULL_STRING)
    private Date updatedAt;

    private List<PivotDTO> pivot;
}
