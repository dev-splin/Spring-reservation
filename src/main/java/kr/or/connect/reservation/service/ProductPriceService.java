package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ProductPriceDTO;

public interface ProductPriceService {
	List<ProductPriceDTO> getProductPrices(Long productId);
}
