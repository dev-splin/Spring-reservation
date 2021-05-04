package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserComment;

public interface ReservationUserCommentService {
	public int getScoreAvgScoreByProductId(Long productId);
	public List<ReservationUserComment> getReservationUserCommentByProductId(Long productId, int start, int limit);
	public int getReservationUserCommentCount(Long productId);
}
