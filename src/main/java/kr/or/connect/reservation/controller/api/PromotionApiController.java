package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/api")
public class PromotionApiController {
	
	@Autowired
	PromotionService promotionService;

	@GetMapping(path = "/promotions")
	public Map<String, Object> getPromotions() {
		
		List<Promotion> list = promotionService.getPromotion();
		int size = list.size();
		
		Map<String, Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		
		return map;
	}
}
