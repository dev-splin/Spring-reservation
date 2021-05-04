package reservation.ServiceTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ReservationUserCommentImage;
import kr.or.connect.reservation.service.ReservationUserCommentImageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ReservationUserCommentImageServiceTest {
	@Autowired
	ReservationUserCommentImageService reservationUserCommentImageService;
	
	@Test
	public void getReservationUserCommentImageTest() {
		List<ReservationUserCommentImage> list = 
				reservationUserCommentImageService.getReservationUserCommentImageByReservationUserId(1L);
		
		for(ReservationUserCommentImage r : list)
			System.out.println(r);
	}
}
