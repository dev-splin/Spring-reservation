package kr.or.connect.reservation.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api")
public class DisplayinfoApliController {
	
	@Autowired
	CategoryService categoryService;
	
	
}
