package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserCommentImageDTO;

public interface ReservationUserCommentImageService {
	List<ReservationUserCommentImageDTO> getReservationUserCommentImageByReservationUserId(Long reservationUserId);
}
