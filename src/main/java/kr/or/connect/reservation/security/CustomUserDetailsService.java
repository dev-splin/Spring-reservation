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

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserEntityService userEntityService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		
		// loginId를 이용해 userEntity를 가져옵니다. 없을 시 예외처리
		UserEntity userEntity = userEntityService.getUserEntity(loginId);
		
		// 이 메서드는 UserDetails를 반환하기 때문에 UserDetails를 상속받는 CustomUserDetails 생성
		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.setUsername(userEntity.getLoginUserId());
		customUserDetails.setPassword(userEntity.getPassword());
		
		// loginId에 해당하는 권한들을 가져오고 CustomUserDetails에도 넣어줍니다.
		List<UserRoleEntity> userRoleEntityList = userEntityService.getUserRoleEntitys(loginId);
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(userRoleEntityList != null) {
			for(UserRoleEntity userRoleEntity : userRoleEntityList)
				authorities.add(new SimpleGrantedAuthority(userRoleEntity.getRoleName()));
		}
		
		customUserDetails.setAuthorities(authorities);
		customUserDetails.setEnabled(true);
		customUserDetails.setAccountNonExpired(true);
		customUserDetails.setAccountNonLocked(true);
		customUserDetails.setCredentialsNonExpired(true);
		
		return customUserDetails;
	}

}
