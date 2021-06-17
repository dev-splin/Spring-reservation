package kr.or.connect.reservation.dto;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestReservationInfoPriceDTO {
	@NotNull
	private Long productPriceId;
	@Min(value = 1)
	private int count;
}
