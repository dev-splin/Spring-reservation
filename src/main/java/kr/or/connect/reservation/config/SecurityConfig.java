package kr.or.connect.reservation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.connect.reservation.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Override
	// 인증/인가가 필요 없는 경로 설정
	public void configure(WebSecurity web) throws Exception {
		// 해당 경로를 무시합니다.
		web.ignoring().antMatchers("/webjars/**");
	}
	
	@Override
	// AuthenticationFilter는 아이디/암호를 입력해서 로그인할 때 처리해주는 필터
	// UserDetailsService를 구현한 CustomUserDetailsService을 넣어줍니다.
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Override
	// 페이지 인가 설정 ,로그인 및 로그아웃 인증 설정 
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/reservationInfos/**").hasRole("USER")
		.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/users/loginform")
			.usernameParameter("userId")
			.passwordParameter("password")
			.loginProcessingUrl("/authenticate")
			.failureForwardUrl("/users/loginerror?login_error=1")
			.defaultSuccessUrl("/", true)
			.permitAll()
		.and()
			.logout()
			.logoutUrl("/users/logout")
			.logoutSuccessUrl("/");
	}

	@Bean
	// 패스워드 인코더
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
