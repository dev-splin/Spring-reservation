package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductImageDao;
import kr.or.connect.reservation.dto.ProductImageDTO;
import kr.or.connect.reservation.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	private final ProductImageDao productImageDao;
	
	public ProductImageServiceImpl(ProductImageDao productImageDao) {
		this.productImageDao = productImageDao;
	}

	@Override
	@Transactional
	public List<ProductImageDTO> getProductImageByProductId(Long productId, String type) {
		return productImageDao.selectByProductId(productId,type);
	}
}
