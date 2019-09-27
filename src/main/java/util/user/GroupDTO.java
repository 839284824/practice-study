package util.user;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户分组
 *
 * @author zhangguangliang
 */
@Data
public class GroupDTO implements Serializable {

    private static final long serialVersionUID = -6903538129115553786L;

    private Integer id;
    private String name;
    private Integer groupBusinessId;
    private Integer groupLeaderId;
    private String groupLeaderName;

    private List<UserDTO> users;

    /**
     * 组长信息
     */
    private UserDTO leaderInfo;
}
