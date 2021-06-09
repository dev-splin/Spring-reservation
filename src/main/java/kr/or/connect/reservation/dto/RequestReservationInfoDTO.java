package kr.or.connect.reservation.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestReservationInfoDTO {
	private Long productId;
	private Long displayInfoId;
	private Long userId;
	@JsonFormat(pattern = "yyyy.MM.dd")
	private Date reservationYearMonthDay;
	List<RequestReservationInfoPriceDTO> prices;
}
