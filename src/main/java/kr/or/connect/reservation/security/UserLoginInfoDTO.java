package kr.or.connect.reservation.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserLoginInfoDTO {
 	private String loginUserId;
    private String password;

    public UserLoginInfoDTO(String loginUserId, String password) {
        this.loginUserId = loginUserId;
        this.password = password;
    }
}
