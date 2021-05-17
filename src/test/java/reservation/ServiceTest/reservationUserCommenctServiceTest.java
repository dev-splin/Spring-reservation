package reservation.ServiceTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.ReservationUserCommentDao;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.impl.ReservationUserCommentServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class reservationUserCommenctServiceTest {
	@InjectMocks
	ReservationUserCommentServiceImpl reservationUserCommentServiceImpl;
	
	@Mock
	ReservationUserCommentDao reservationUserCommentDao;
	
	@Test
	public void getScoreAvgScoreByProductIdTest() {
		// given
		given(reservationUserCommentDao.selectAvgScoreByProductId(1L)).willReturn(3);
		
		// when
		int result = reservationUserCommentServiceImpl.getScoreAvgScoreByProductId(1L);
		
		// then
		verify(reservationUserCommentDao).selectAvgScoreByProductId(anyLong());
		assertThat(result, is(3));
	}
	
	@Test
	public void getReservationUserCommentByProductIdTest() {
		// given
		ReservationUserComment reservationUserComment = new ReservationUserComment();
		reservationUserComment.setId(15L);
		reservationUserComment.setProductId(1L);
		reservationUserComment.setReservationInfoId(15L);
		reservationUserComment.setScore(5);
		reservationUserComment.setReservationEmail("dev.splin@gmail.com");
		reservationUserComment.setComment("댓글 테스트");
		reservationUserComment.setCreateDate(new Date());
		reservationUserComment.setModifyDate(new Date());
		reservationUserComment.setReservationUserCommentImages(null);
		
		List<ReservationUserComment> list = new ArrayList<>();
		list.add(reservationUserComment);
		
		given(reservationUserCommentDao.selectReservationUserCommentByProductId(1L, 0, 5)).willReturn(list);
		
		// when
		List<ReservationUserComment> result = reservationUserCommentServiceImpl.getReservationUserCommentByProductId(1L, 0, 5);
		
		// then
		verify(reservationUserCommentDao).selectReservationUserCommentByProductId(anyLong(), anyInt(), anyInt());
		assertThat(result.size(), is(list.size()));
	}
	
	@Test
	public void getReservationUserCommentCountTest() {
		// given
		given(reservationUserCommentDao.selectReservationUserCommentCount(1L)).willReturn(5);
		
		// when
		int result = reservationUserCommentServiceImpl.getReservationUserCommentCount(1L);
		
		// then
		verify(reservationUserCommentDao).selectReservationUserCommentCount(anyLong());
		assertThat(result, is(5));
	}
	
}
