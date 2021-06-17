package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.ResponseReservationProductInfoDTO;

public interface ReservationProductInfoService {
	ResponseReservationProductInfoDTO getReservationProductInfo(Long userId);
}
