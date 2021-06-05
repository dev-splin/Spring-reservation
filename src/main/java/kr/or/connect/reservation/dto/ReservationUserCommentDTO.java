package kr.or.connect.reservation.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
// reservation_user_comment, user 테이블 사용
public class ReservationUserCommentDTO {
	private Long id;
	private Long productId;
	private Long reservationInfoId;
	@JsonIgnore
	private Long userId;
	private Integer score;
	private String reservationEmail;
	private String comment;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	private Date modifyDate;
	List<ReservationUserCommentImageDTO> reservationUserCommentImages;
}
