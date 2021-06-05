package kr.or.connect.reservation.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRoleEntity {
	private Long id;
	private Long userId;
	private String roleName;
	
	@Builder
	private UserRoleEntity(Long id, Long userId, String roleName) {
		this.id = id;
		this.userId = userId;
		this.roleName = roleName;
	}
}
