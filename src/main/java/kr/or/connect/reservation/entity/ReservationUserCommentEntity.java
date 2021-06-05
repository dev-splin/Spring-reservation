package kr.or.connect.reservation.entity;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationUserCommentEntity {
	private Long id;
	private Long productId;
	private Long reservationInfoId;
	private Long userId;
	private Integer score;
	private String reservationEmail;
	private String comment;
	private Date createDate;
	private Date modifyDate;
	
	@Builder
	private ReservationUserCommentEntity(Long id, Long productId,
			Long reservationInfoId, Long userId,
			Integer score, String reservationEmail,
			String comment, Date createDate, Date modifyDate) {
		this.id = id;
		this.productId = productId;
		this.reservationInfoId = reservationInfoId;
		this.userId = userId;
		this.score = score;
		this.reservationEmail = reservationEmail;
		this.comment = comment;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
}
