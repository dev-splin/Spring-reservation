package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ProductImageDTO;

public interface ProductImageService {
	List<ProductImageDTO> getProductImageByProductId(Long productId, String type);
}
