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
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoImageService;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductImageService;
import kr.or.connect.reservation.service.ProductPriceService;
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
