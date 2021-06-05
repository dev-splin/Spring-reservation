package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// user_role 테이블만 사용
public class UserRoleDTO {
	private Long id;
	private Long userId;
	private String roleName;
}
