package kr.or.connect.reservation.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.connect.reservation.dto.UserDTO;
import lombok.Getter;

@Getterpublic class CustomUserDetails extends User {
	private UserDTO userDTO;

	public CustomUserDetails(UserDTO userDTO, List<GrantedAuthority> authorities) {
		super(userDTO.getEmail(), userDTO.getPassword(), authorities);
		this.userDTO = userDTO;
	}
}
