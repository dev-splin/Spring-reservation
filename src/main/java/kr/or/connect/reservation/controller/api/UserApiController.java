package kr.or.connect.reservation.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.service.UserService;

@Controller
@RequestMapping(path = "/users")
public class UserApiController {
	
	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// 로그인 폼
	@GetMapping("/loginform")
	public String loginform() {
		return "users/loginform";
	}
	
	// 로그인 에러 페이지
	@RequestMapping("/loginerror")
	public String loginerror(@RequestParam String login_error) {
		return "users/loginerror";
	}
}
