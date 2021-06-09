package kr.or.connect.reservation.service;

import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.ResponseRegisterReservationInfoDTO;

public interface ReservationInfoService {
	ResponseRegisterReservationInfoDTO RegisterReservation(
			RequestReservationInfoDTO requestReservationInfoDTO);
}
