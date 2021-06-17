package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ReservationProductInfoDao;
import kr.or.connect.reservation.dto.ReservationProductInfoDTO;
import kr.or.connect.reservation.dto.ResponseReservationProductInfoDTO;
import kr.or.connect.reservation.service.ReservationProductInfoService;

@Service
public class ReservationProductInfoServiceImpl implements ReservationProductInfoService {
	private final ReservationProductInfoDao reservationProductInfoDao;
	
	public ReservationProductInfoServiceImpl(ReservationProductInfoDao reservationProductInfoDao) {
		this.reservationProductInfoDao = reservationProductInfoDao;
	}

	@Override
	public ResponseReservationProductInfoDTO getReservationProductInfo(Long userId) {
		ResponseReservationProductInfoDTO responseReservationProductInfoDTO = new ResponseReservationProductInfoDTO();;
		
		List<ReservationProductInfoDTO> list = reservationProductInfoDao.getReservationProductInfoByUserId(userId);
		responseReservationProductInfoDTO.setSize(list.size());
		responseReservationProductInfoDTO.setItems(list);
		
		return responseReservationProductInfoDTO;
	}
}
