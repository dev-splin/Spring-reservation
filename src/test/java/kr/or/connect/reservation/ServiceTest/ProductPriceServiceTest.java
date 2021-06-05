package kr.or.connect.reservation.ServiceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.ProductPriceDao;
import kr.or.connect.reservation.dto.ProductPriceDTO;
import kr.or.connect.reservation.service.impl.ProductPriceServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceServiceTest {
	@InjectMocks
	ProductPriceServiceImpl productPriceServiceImpl;
	
	@Mock
	ProductPriceDao productPriceDao;
	
	@Test
	public void getProductPricesTest() {
		// given
		ProductPriceDTO productPrice = new ProductPriceDTO();
		productPrice.setId(3L);
		productPrice.setProductId(1L);
		productPrice.setPriceTypeName("가격 타입 이름 테스트");
		productPrice.setPrice(2000);
		productPrice.setDiscountRate(50);
		productPrice.setCreateDate(new Date());
		productPrice.setModifyDate(new Date());
		
		List<ProductPriceDTO> list = new ArrayList<>();
		list.add(productPrice);
		
		for(ProductPriceDTO dto : list)
			System.out.println(dto);
		
		given(productPriceDao.selectByProductId(1L)).willReturn(list);
		
		// when
		List<ProductPriceDTO> result = productPriceServiceImpl.getProductPrices(1L);
		
		// then
		verify(productPriceDao).selectByProductId(anyLong());
		assertThat(result.size(), is(list.size()));
	}
}
