package reservation.ServiceTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.service.ProductImageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ProductImageServiceTest {
	@Autowired
	ProductImageService productImageService;
	
	@Test
	public void selectByIdTest() throws Exception {
		List<ProductImage> list = productImageService.getProductImageByProductId(1L, "ma");
		
		for(ProductImage p : list)
			System.out.println(p);
	}
}
