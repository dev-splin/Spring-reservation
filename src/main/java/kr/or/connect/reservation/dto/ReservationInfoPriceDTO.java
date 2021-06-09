package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReservationInfoPriceDTO {
	private Long id;
	private Long reservationInfoId;
	private Long productPriceId;
	private int count;
}
