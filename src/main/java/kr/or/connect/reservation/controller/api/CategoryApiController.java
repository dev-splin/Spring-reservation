package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api")
public class CategoryApiController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(path = "/categories")
	public Map<String, Object> getCategories() {
		List<Category> list = categoryService.getCategories();
		
		Map<String, Object> map = new HashMap<>();
		map.put("size", list.size());
		map.put("items", list);
		
		return map;
	}

}
