package kr.or.connect.reservation.entity;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
	private Long id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private Date createDate;
	private Date modifyDate;
	
	@Builder
	private UserEntity(Long id, String name,
			String password, String email,
			String phone, Date createDate, Date modifyDate) {
		this.id =id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
}
