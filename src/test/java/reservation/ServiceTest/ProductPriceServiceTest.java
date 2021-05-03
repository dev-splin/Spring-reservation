package reservation.ServiceTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.service.ProductPriceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ProductPriceServiceTest {
	@Autowired
	ProductPriceService productPriceService;
	
	@Test
	public void getProductPricesTest() {
		List<ProductPrice> list = productPriceService.getProductPrices(1L);
		
		for(ProductPrice p : list)
			System.out.println(p);
	}
}
