package reservation.ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.service.ReservationUserCommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class reservationUserCommenctServiceTest {
	@Autowired
	ReservationUserCommentService reservationUserCommentService;
	
	@Test
	public void getAvgScoreTest() {
		System.out.println(reservationUserCommentService.getScoreAvgScoreByProductId(1L));
	}
	
}
