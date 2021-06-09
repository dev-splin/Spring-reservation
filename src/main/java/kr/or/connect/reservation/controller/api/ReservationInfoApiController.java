package kr.or.connect.reservation.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.ResponseRegisterReservationInfoDTO;
import kr.or.connect.reservation.service.ReservationInfoService;

@RestController
@RequestMapping("/api/reservationInfos")
public class ReservationInfoApiController {
	
	private final ReservationInfoService reservationInfoService;
	
	public ReservationInfoApiController(ReservationInfoService reservationInfoService) {
		this.reservationInfoService = reservationInfoService;
	}
	
	@PostMapping
	public ResponseRegisterReservationInfoDTO reservationRegister(
			@RequestBody RequestReservationInfoDTO requestReservationInfoDTO) {
		
		return reservationInfoService.RegisterReservation(requestReservationInfoDTO);
	}
}
