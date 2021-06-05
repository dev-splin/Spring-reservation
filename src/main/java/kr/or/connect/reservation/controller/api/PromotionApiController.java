package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.PromotionDTO;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/api/promotions")
public class PromotionApiController {
	
	@Autowired
	PromotionService promotionService;

	@GetMapping
	// 프로모션 정보를 가져와 size와 함께 json으로 반환합니다.
	public Map<String, Object> getPromotions() {
		
		List<PromotionDTO> list = promotionService.getPromotion();
		int size = list.size();
		
		Map<String, Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		
		return map;
	}
}
