package reservation.ServiceTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class PromotionServiceTest {
	@Autowired
	PromotionService promotionService;
	
	@Test
	public void selectAllTest() throws Exception {
		List<Promotion> list = promotionService.getPromotion();
		
		for(Promotion p : list)
			System.out.println(p);
	}
}
