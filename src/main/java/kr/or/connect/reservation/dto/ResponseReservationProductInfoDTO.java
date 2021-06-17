package kr.or.connect.reservation.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseReservationProductInfoDTO {
	private int size;
	private List<ReservationProductInfoDTO> items;
}
