package kr.or.connect.reservation.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.UserDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserEntityService userEntityService;
	
	CustomUserDetailsService(UserEntityService userEntityService) {
		this.userEntityService = userEntityService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		
		// loginId를 이용해 userEntity를 가져옵니다. 없을 시 예외처리
		UserDTO userDTO = userEntityService.getUserDTO(loginId);
		if(userDTO == null)
			throw new UsernameNotFoundException("사용자가 입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.");
				
		// loginId에 해당하는 권한들을 가져오고 CustomUserDetails에도 넣어줍니다.
		List<UserLoginRoleDTO> userRoleEntityList = userEntityService.getUserRoleEntitys(loginId);
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(userRoleEntityList != null) {
			for(UserLoginRoleDTO userRoleEntity : userRoleEntityList)
				authorities.add(new SimpleGrantedAuthority(userRoleEntity.getRoleName()));
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(userDTO, authorities);
		
		return customUserDetails;
	}

}
