package kr.or.connect.reservation.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReservationProductInfoDTO {
	private Long id;
	private Long productId;
	private Long displayInfoId;
	private int cancelFlag;
	private String productDescription;
	private String productContent;
	private Long userId;
	private int sumPrice;
	private Date reservationDate;
	private Date createDate;
	private Date modifyDate;
}
