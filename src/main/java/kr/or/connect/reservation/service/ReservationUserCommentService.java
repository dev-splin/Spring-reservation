package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserComment;

public interface ReservationUserCommentService {
	Integer getScoreAvgScoreByProductId(Long productId);
	List<ReservationUserComment> getReservationUserCommentByProductId(Long productId, int start, int limit);
	int getReservationUserCommentCount(Long productId);
}
