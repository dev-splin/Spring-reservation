package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationUserCommentDao;
import kr.or.connect.reservation.service.ReservationUserCommentService;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService {
	@Autowired
	ReservationUserCommentDao reservationUserCommenctDao;
	
	@Override
	@Transactional
	public int getScoreAvgScoreByProductId(Long productId) {
		return reservationUserCommenctDao.selectAvgScoreByProductId(productId);
	}

}
