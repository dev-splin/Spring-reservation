package kr.or.connect.reservation.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// user 테이블만 사용
public class UserDTO {
	private Long id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private Date createDate;
	private Date modifyDate;
}
