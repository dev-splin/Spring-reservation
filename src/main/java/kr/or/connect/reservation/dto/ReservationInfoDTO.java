package kr.or.connect.reservation.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReservationInfoDTO {
	private Long id;
	private Long productId;
	private int cancelFlag;
	private Long displayInfoId;
	private Long userId;
	private Date reservationDate;
	private Date createDate;
	private Date modifyDate;
}
