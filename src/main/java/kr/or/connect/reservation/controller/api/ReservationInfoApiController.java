package kr.or.connect.reservation.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.RequestReservationCancelDTO;
import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.ResponseRegisterReservationInfoDTO;
import kr.or.connect.reservation.dto.ResponseReservationCancelDTO;
import kr.or.connect.reservation.dto.ResponseReservationProductInfoDTO;
import kr.or.connect.reservation.security.CustomUserDetails;
import kr.or.connect.reservation.service.ReservationInfoService;
import kr.or.connect.reservation.service.ReservationProductInfoService;

@RestController
@RequestMapping("/api/reservationInfos")
@Validated
public class ReservationInfoApiController {
	
	private final ReservationInfoService reservationInfoService;
	private final ReservationProductInfoService reservationProductInfoService;
	
	public ReservationInfoApiController(ReservationInfoService reservationInfoService,
			ReservationProductInfoService reservationProductInfoService) {
		this.reservationInfoService = reservationInfoService;
		this.reservationProductInfoService = reservationProductInfoService;
	}

	@PostMapping
	// Request를 받은 정보를 이용해 예약 정보를 만들어 저장합니다.
	public ResponseEntity<ResponseRegisterReservationInfoDTO> reservationRegister(
			@RequestBody @Valid RequestReservationInfoDTO requestReservationInfoDTO) {
		
		ResponseRegisterReservationInfoDTO result = reservationInfoService.RegisterReservation(requestReservationInfoDTO);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<>(result, headers, HttpStatus.OK);
	}
	
	@GetMapping
	// 현재 로그인한 유저의 예약 목록들을 가져옵니다.
	public ResponseEntity<ResponseReservationProductInfoDTO> getReservationProductInfo(
			@AuthenticationPrincipal CustomUserDetails customUserDetails) {
		
		ResponseReservationProductInfoDTO responseReservationProductInfoDTO = 
				reservationProductInfoService.getReservationProductInfo(customUserDetails.getUserDTO().getId());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<>(responseReservationProductInfoDTO, headers, HttpStatus.OK);
	}
	
	@PutMapping
	// 예약을 취소합니다.(예약 데이터의 예약 flag를 1로 바꿉니다.)
	public ResponseEntity<ResponseReservationCancelDTO> reservationCancel(
			@RequestBody @Valid RequestReservationCancelDTO requestReservationCancelDTO) {

		int updateResult = reservationInfoService.reservationCancel(requestReservationCancelDTO.getId());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpStatus httpStatus = HttpStatus.OK;
		
		String result = "success";
		if(updateResult == 0) {
			result = "fail";
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		
		ResponseReservationCancelDTO responseReservationCancelDTO = new ResponseReservationCancelDTO();
		responseReservationCancelDTO.setResult(result);
		
		return new ResponseEntity<>(responseReservationCancelDTO, headers, httpStatus);
	}
}
