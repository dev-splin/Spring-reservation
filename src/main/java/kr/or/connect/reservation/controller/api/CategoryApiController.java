package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.CategoryDTO;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryApiController {
	
	private final CategoryService categoryService;
	
	public CategoryApiController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	// category를 가져와서 json으로 반환합니다.
	@GetMapping
	public Map<String, Object> getCategories() {
		List<CategoryDTO> list = categoryService.getCategories();
		Map<String, Object> map = new HashMap<>();
		
		map.put("size", list.size());
		map.put("items", list);
		
		return map;
	}

}
