package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// reservation_user_comment_image 테이블만 사용
public class ReservationUserCommentImageDTO {
	private Long id;
	private Long reservationInfoId;
	private Long reservationUserCommentId;
	private Long fileId;
}
