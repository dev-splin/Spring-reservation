package kr.or.connect.reservation.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseRegisterReservationInfoDTO {
	@JsonUnwrapped
	ReservationInfoDTO reservationInfoDTO;
	private List<ReservationInfoPriceDTO> prices;
}