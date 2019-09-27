package util.user;

import lombok.Data;

import java.io.Serializable;

/**
 * "pivot":{
 * "user_id":258,
 * "role_id":97
 * }
 *
 * @author zhangguangliang
 */
@Data
public class PivotDTO  implements Serializable {
    private Integer userId;
    private Integer roleId;
}
