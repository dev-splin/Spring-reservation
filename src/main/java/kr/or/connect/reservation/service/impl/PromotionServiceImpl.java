package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.PromotionDTO;
import kr.or.connect.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	private final PromotionDao promotionDao;
	
	public PromotionServiceImpl(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}

	@Override
	@Transactional
	public List<PromotionDTO> getPromotion() {
		return promotionDao.selectAll();
	}
}
