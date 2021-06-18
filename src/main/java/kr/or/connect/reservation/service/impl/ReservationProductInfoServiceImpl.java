package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductPriceDao;
import kr.or.connect.reservation.dao.ReservationProductInfoDao;
import kr.or.connect.reservation.dto.ReservationProductInfoDTO;
import kr.or.connect.reservation.dto.ResponseReservationProductInfoDTO;
import kr.or.connect.reservation.service.ReservationProductInfoService;

@Service
public class ReservationProductInfoServiceImpl implements ReservationProductInfoService {
	private final ReservationProductInfoDao reservationProductInfoDao;
	private final ProductPriceDao productPriceDao;
	
	public ReservationProductInfoServiceImpl(ReservationProductInfoDao reservationProductInfoDao,
			ProductPriceDao productPriceDao) {
		this.reservationProductInfoDao = reservationProductInfoDao;
		this.productPriceDao = productPriceDao;
	}

	@Override
	@Transactional
	public ResponseReservationProductInfoDTO getReservationProductInfo(Long userId) {
		ResponseReservationProductInfoDTO responseReservationProductInfoDTO = new ResponseReservationProductInfoDTO();;
		
		List<ReservationProductInfoDTO> list = reservationProductInfoDao.getReservationProductInfoByUserId(userId);
		
		for(ReservationProductInfoDTO reservationProductInfoDTO : list) {
			reservationProductInfoDTO.setSumPrice(
					productPriceDao.selectPriceSumByReservationInfoId(reservationProductInfoDTO.getId()));
		}
		
		responseReservationProductInfoDTO.setSize(list.size());
		responseReservationProductInfoDTO.setItems(list);
		
		return responseReservationProductInfoDTO;
	}
}
