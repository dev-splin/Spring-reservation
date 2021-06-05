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

import kr.or.connect.reservation.dto.DisplayInfoDTO;
import kr.or.connect.reservation.dto.DisplayInfoImageDTO;
import kr.or.connect.reservation.dto.ProductImageDTO;
import kr.or.connect.reservation.dto.ProductPriceDTO;
import kr.or.connect.reservation.dto.ReservationUserCommentDTO;
import kr.or.connect.reservation.dto.ReservationUserCommentImageDTO;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoImageService;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductImageService;
import kr.or.connect.reservation.service.ProductPriceService;
import kr.or.connect.reservation.service.ReservationUserCommentImageService;
import kr.or.connect.reservation.service.ReservationUserCommentService;

@RestController
@RequestMapping(path = "/api/displayinfos")
public class DisplayinfoApiController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	DisplayInfoService displayInfoService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	DisplayInfoImageService displayInfoImageService;
	@Autowired
	ReservationUserCommentService reservationUserCommentService;
	@Autowired
	ProductPriceService productPriceService;
	@Autowired
	ReservationUserCommentImageService reservationUserCommentImageService;
	
	@GetMapping
	// 카테고리id에 해당하는 디스플레이 정보 4개, 총 개수를 가져와 json으로 반환합니다.
	public Map<String, Object> getDisplayInfos(
			@RequestParam(defaultValue = "0") Long categoryId,
			@RequestParam(defaultValue = "0") Long start) {
		
		int totalCount;
		List<DisplayInfoDTO> products;
		
		if(categoryId == 0) {
			products = displayInfoService.getDisplayInfo(start);
			totalCount = categoryService.getCount();
		}
		else {
			products = displayInfoService.getDisplayInfoByCategoryId(categoryId, start);
			totalCount = categoryService.getCountByCategoryId(categoryId);
		}
		
		int productCount = products.size();
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("productCount", productCount);
		map.put("products", products);
		
		return map;
	}
	
	@GetMapping("/{displayId}")
	// displayId에 해당하는 전시정보들을 가져와 json으로 반환합니다.
	public Map<String, Object> getDetailedDisplayInfos(@PathVariable Long displayId) {
		
		DisplayInfoDTO product = displayInfoService.getDisplayInfoByDisplayInfoId(displayId);
		
		List<ProductImageDTO> productImages = productImageService.getProductImageByProductId(product.getId(), "ma");
		List<DisplayInfoImageDTO> displayInfoImages = displayInfoImageService.getDisplayImageByDisplayInfoId(displayId);
		
		Integer avgScore = null;
		try {
			avgScore = reservationUserCommentService.getScoreAvgScoreByProductId(product.getId());
		} catch (NullPointerException e) {
			avgScore = 0;
		}
		
		List<ProductPriceDTO> productPrices = productPriceService.getProductPrices(product.getId());
		
		Map<String, Object> map = new HashMap<>();
		map.put("product", product);
		map.put("productImages", productImages);
		map.put("displayInfoImages", displayInfoImages);
		map.put("avgScore", avgScore);
		map.put("productPrices", productPrices);
		
		return map;
	}
	
	@GetMapping("/comments")
	// productId에 해당하는 상품의 댓글정보들과 총 개수, 읽어온 댓글 수를 json으로 반환합니다. 
	public Map<String, Object> getProductComments(
			@RequestParam(defaultValue = "1") Long productId,
			@RequestParam(defaultValue = "0") int start) {
		
		int commentCount = 5;
		
		List<ReservationUserCommentDTO> reservationUserComments = 
				reservationUserCommentService.getReservationUserCommentByProductId(productId, start, commentCount);
		
		int totalCount = reservationUserCommentService.getReservationUserCommentCount(productId);
		
		for(ReservationUserCommentDTO c : reservationUserComments) {
			List<ReservationUserCommentImageDTO> reservationUserCommentImages = 
					reservationUserCommentImageService.getReservationUserCommentImageByReservationUserId(c.getUserId());
			c.setReservationUserCommentImages(reservationUserCommentImages);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("commentCount", commentCount);
		map.put("reservationUserComments", reservationUserComments);
		
		return map;
	}
	
}
