package kr.or.connect.reservation.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.ResponseRegisterReservationInfoDTO;
import kr.or.connect.reservation.dto.ResponseReservationProductInfoDTO;
import kr.or.connect.reservation.security.CustomUserDetails;
import kr.or.connect.reservation.service.ReservationInfoService;
import kr.or.connect.reservation.service.ReservationProductInfoService;

@RestController
@RequestMapping("/api/reservationInfos")
public class ReservationInfoApiController {
	
	private final ReservationInfoService reservationInfoService;
	private final ReservationProductInfoService reservationProductInfoService;
	
	public ReservationInfoApiController(ReservationInfoService reservationInfoService,
			ReservationProductInfoService reservationProductInfoService) {
		this.reservationInfoService = reservationInfoService;
		this.reservationProductInfoService = reservationProductInfoService;
	}

	@PostMapping
	public ResponseRegisterReservationInfoDTO reservationRegister(
			@RequestBody @Valid RequestReservationInfoDTO requestReservationInfoDTO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors()
				.forEach(objectError -> {
					System.err.println("code : " + objectError.getCode());
					System.err.println("message : " + objectError.getDefaultMessage());
					System.err.println("name : " + objectError.getObjectName());
				});
			
			return null;
		}
		
		ResponseRegisterReservationInfoDTO result = reservationInfoService.RegisterReservation(requestReservationInfoDTO);
		
		return result;
	}
	
	@GetMapping
	public ResponseEntity<ResponseReservationProductInfoDTO> getReservationProductInfo(
			@AuthenticationPrincipal CustomUserDetails customUserDetails) {
		
		ResponseReservationProductInfoDTO responseReservationProductInfoDTO = 
				reservationProductInfoService.getReservationProductInfo(customUserDetails.getUserDTO().getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<>(responseReservationProductInfoDTO, headers, HttpStatus.OK);
	}
}
