package kr.or.connect.reservation.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestReservationInfoDTO {
	@NotNull
	private Long productId;
	@NotNull
	private Long displayInfoId;
	@NotNull
	private Long userId;
	@JsonFormat(pattern = "yyyy.MM.dd")
	private Date reservationYearMonthDay;
	@NotEmpty
	@Valid
	List<RequestReservationInfoPriceDTO> prices;
}
