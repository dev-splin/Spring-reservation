package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserCommentImage;

public interface ReservationUserCommentImageService {
	public List<ReservationUserCommentImage> getReservationUserCommentImageByReservationUserId(Long ReservationUserId);
}
