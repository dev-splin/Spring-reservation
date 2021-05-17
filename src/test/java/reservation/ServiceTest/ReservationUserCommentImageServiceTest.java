package reservation.ServiceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.ReservationUserCommentImageDao;
import kr.or.connect.reservation.dto.ReservationUserCommentImage;
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
		ReservationUserCommentImage reservationUserCommentImage = new ReservationUserCommentImage();
		
		List<ReservationUserCommentImage> list = new ArrayList<>();
		list.add(reservationUserCommentImage);
		
		given(reservationUserCommentImageDao.selectByReservationUserId(15L)).willReturn(list);
		
		// when
		List<ReservationUserCommentImage> result = reservationUserCommentImageServiceImpl.getReservationUserCommentImageByReservationUserId(15L);
		
		// then
		verify(reservationUserCommentImageDao).selectByReservationUserId(anyLong());
		assertThat(result.size(), is(list.size()));
	}
}
