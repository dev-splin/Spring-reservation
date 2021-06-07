package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationUserCommentImageDao;
import kr.or.connect.reservation.dto.ReservationUserCommentImageDTO;
import kr.or.connect.reservation.service.ReservationUserCommentImageService;

@Service
public class ReservationUserCommentImageServiceImpl implements ReservationUserCommentImageService {
	private final ReservationUserCommentImageDao reservationUserCommentImageDao;
	
	public ReservationUserCommentImageServiceImpl(ReservationUserCommentImageDao reservationUserCommentImageDao) {
		this.reservationUserCommentImageDao = reservationUserCommentImageDao;
	}
	
	@Override
	@Transactional
	public List<ReservationUserCommentImageDTO> getReservationUserCommentImageByReservationUserId(Long reservationUserId) {
		return reservationUserCommentImageDao.selectByReservationUserId(reservationUserId);
	}

}
