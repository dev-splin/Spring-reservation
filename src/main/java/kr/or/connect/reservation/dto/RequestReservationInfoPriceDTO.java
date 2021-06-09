package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestReservationInfoPriceDTO {
	private Long productPriceId;
	private int count;
}
