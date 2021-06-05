package kr.or.connect.reservation.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationUserCommentImageEntity {
	private Long id;
	private Long reservationInfoId;
	private Long reservationUserCommentId;
	private Long fileId;
	
	@Builder
	private ReservationUserCommentImageEntity(Long id, Long reservationInfoId,
			Long reservationUserCommentId, Long fildId) {
		this.id = id;
		this.reservationInfoId = reservationInfoId;
		this.reservationUserCommentId = reservationUserCommentId;
		this.fileId = fildId;
	}
}
