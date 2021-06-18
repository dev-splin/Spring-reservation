package kr.or.connect.reservation.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestReservationCancelDTO {
	@NotNull
	private Long id;
}
