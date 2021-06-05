package kr.or.connect.reservation.ServiceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.ReservationUserCommentImageDao;
import kr.or.connect.reservation.dto.ReservationUserCommentImageDTO;
import kr.or.connect.reservation.service.impl.ReservationUserCommentImageServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ReservationUserCommentImageServiceTest {
	@InjectMocks
	ReservationUserCommentImageServiceImpl reservationUserCommentImageServiceImpl;
	
	@Mock
	ReservationUserCommentImageDao reservationUserCommentImageDao;
	
	@Test
	public void getReservationUserCommentImageByReservationUserIdTest() {
		// given
		ReservationUserCommentImageDTO reservationUserCommentImage = new ReservationUserCommentImageDTO();
		reservationUserCommentImage.setId(1L);
		reservationUserCommentImage.setReservationInfoId(2L);
		reservationUserCommentImage.setReservationUserCommentId(3L);
		reservationUserCommentImage.setFileId(4L);
		
		List<ReservationUserCommentImageDTO> list = new ArrayList<>();
		list.add(reservationUserCommentImage);
		
		given(reservationUserCommentImageDao.selectByReservationUserId(15L)).willReturn(list);
		
		// when
		List<ReservationUserCommentImageDTO> result = reservationUserCommentImageServiceImpl.getReservationUserCommentImageByReservationUserId(15L);
		
		// then
		verify(reservationUserCommentImageDao).selectByReservationUserId(anyLong());
		assertThat(result.size(), is(list.size()));
	}
}
