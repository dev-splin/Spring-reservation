package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoService;

@RestController
@RequestMapping(path = "/api/displayinfos")
public class DisplayinfoApiController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	DisplayInfoService displayInfoService;
	
	@GetMapping
	public Map<String, Object> getDisplayInfos(
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") Long categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") Long start) {
		
		int totalCount;
		List<DisplayInfo> products;
		
		if(categoryId == 0) {
			products = displayInfoService.getDisplayInfo(start);
			totalCount = categoryService.getCount();
		}
		else {
			products = displayInfoService.getDisplayInfoById(categoryId, start);
			totalCount = categoryService.getCountById(categoryId);
		}
		
		int productCount = products.size();
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("productCount", productCount);
		map.put("products", products);
		
		return map;
	}
	
	@GetMapping("/{displayId}")
	public Map<String, Object> getDetailedDisplayInfos(@PathVariable(name = "displayId") Long id) {
		
		return null;
	}
}
