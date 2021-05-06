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
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.dto.ReservationUserCommentImage;
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
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") Long categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") Long start) {
		
		int totalCount;
		List<DisplayInfo> products;
		
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
	
	@GetMapping("/comments")
	// productId에 해당하는 상품의 댓글정보들과 총 개수, 읽어온 댓글 수를 json으로 반환합니다. 
	public Map<String, Object> getProductComments(
			@RequestParam(name = "productId", required = false, defaultValue = "1") Long productId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		
		int commentCount = 5;
		
		List<ReservationUserComment> reservationUserComments = 
				reservationUserCommentService.getReservationUserCommentByProductId(productId, start, commentCount);
		
		int totalCount = reservationUserCommentService.getReservationUserCommentCount(productId);
		
		for(ReservationUserComment c : reservationUserComments) {
			List<ReservationUserCommentImage> reservationUserCommentImages = 
					reservationUserCommentImageService.getReservationUserCommentImageByReservationUserId(c.getUserId());
			c.setReservationUserCommentImages(reservationUserCommentImages);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("commentCount", commentCount);
		map.put("reservationUserComments", reservationUserComments);
		
		return map;
	}
	
	@GetMapping("/{displayId}")
	// displayId에 해당하는 전시정보들을 가져와 json으로 반환합니다.
	public Map<String, Object> getDetailedDisplayInfos(@PathVariable(name = "displayId") Long id) {
		
		DisplayInfo product = displayInfoService.getDisplayInfoByDisplayInfoId(id);
		
		List<ProductImage> productImages = productImageService.getProductImageByProductId(product.getId(), "ma");
		List<DisplayInfoImage> displayInfoImages = displayInfoImageService.getDisplayImageByDisplayInfoId(id);
		
		int avgScore = reservationUserCommentService.getScoreAvgScoreByProductId(product.getId());
		
		List<ProductPrice> productPrices = productPriceService.getProductPrices(product.getId());
		
		Map<String, Object> map = new HashMap<>();
		map.put("product", product);
		map.put("productImages", productImages);
		map.put("displayInfoImages", displayInfoImages);
		map.put("avgScore", avgScore);
		map.put("productPrices", productPrices);
		
		return map;
	}
}
