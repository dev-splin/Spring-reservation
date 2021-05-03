package reservation.ServiceTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.DisplayInfoImageDao;
import kr.or.connect.reservation.dto.DisplayInfoImage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class DisplayInfoImageService {
	@Autowired
	DisplayInfoImageDao displayInfoImageDao;
	
	@Test
	public void selectByIdTest() {
		List<DisplayInfoImage> list = displayInfoImageDao.selectByDisplayInfoId(1L);
		
		for(DisplayInfoImage d : list)
			System.out.println(d);
	}
}
