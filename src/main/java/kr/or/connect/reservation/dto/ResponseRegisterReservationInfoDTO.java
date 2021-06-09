package kr.or.connect.reservation.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseRegisterReservationInfoDTO {
	private Long id;
	private Long productId;
	private int cancelFlag;
	private Long displayInfoId;
	private Long userId;
	private Date reservationDate;
	private Date createDate;
	private Date modifyDate;
	private List<ReservationInfoPriceDTO> prices;
}