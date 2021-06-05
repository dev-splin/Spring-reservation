package kr.or.connect.reservation.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserLoginRoleDTO {
	private String loginUserId;
    private String roleName;

    public UserLoginRoleDTO(String loginUserId, String roleName) {
        this.loginUserId = loginUserId;
        this.roleName = roleName;
    }
}
