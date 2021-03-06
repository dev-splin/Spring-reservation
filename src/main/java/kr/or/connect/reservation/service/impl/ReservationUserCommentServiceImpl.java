package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationUserCommentDao;
import kr.or.connect.reservation.dto.ReservationUserCommentDTO;
import kr.or.connect.reservation.service.ReservationUserCommentService;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService {
	private final ReservationUserCommentDao reservationUserCommenctDao;
	
	public ReservationUserCommentServiceImpl(ReservationUserCommentDao reservationUserCommenctDao) {
		this.reservationUserCommenctDao = reservationUserCommenctDao;
	}
	
	@Override
	@Transactional
	public Integer getScoreAvgScoreByProductId(Long productId) {
		return reservationUserCommenctDao.selectAvgScoreByProductId(productId);
	}

	@Override
	@Transactional
	public List<ReservationUserCommentDTO> getReservationUserCommentByProductId(Long productId, int start, int limit) {
		return reservationUserCommenctDao.selectReservationUserCommentByProductId(productId, start, limit);
	}
	
	public int getReservationUserCommentCount(Long productId) {
		return reservationUserCommenctDao.selectReservationUserCommentCount(productId);
	}

}
