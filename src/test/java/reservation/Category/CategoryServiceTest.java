package reservation.Category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class CategoryServiceTest {
	@Autowired
	CategoryService categoryService;
	
	@Test
	public void countTest() throws Exception {
		int count = categoryService.getCount(3);
		
		System.out.println(count);
	}

}
