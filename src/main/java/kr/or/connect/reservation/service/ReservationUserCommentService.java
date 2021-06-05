package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserCommentDTO;

public interface ReservationUserCommentService {
	Integer getScoreAvgScoreByProductId(Long productId);
	List<ReservationUserCommentDTO> getReservationUserCommentByProductId(Long productId, int start, int limit);
	int getReservationUserCommentCount(Long productId);
}
