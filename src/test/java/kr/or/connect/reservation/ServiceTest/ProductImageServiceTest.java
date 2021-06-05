package kr.or.connect.reservation.ServiceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.ProductImageDao;
import kr.or.connect.reservation.dto.ProductImageDTO;
import kr.or.connect.reservation.service.impl.ProductImageServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ProductImageServiceTest {
	@InjectMocks
	ProductImageServiceImpl productImageServiceImpl;
	
	@Mock
	ProductImageDao productImageDao;
	
	@Test
	public void selectByIdTest() throws Exception {
		// given
		ProductImageDTO productImage = new ProductImageDTO();
		productImage.setProductId(1L);
		productImage.setProductImageId(2L);
		productImage.setType("ma");
		productImage.setFileInfoId(61L);
		productImage.setFileName("파일 이름 테스트");
		productImage.setSaveFileName("세이브 파일 이름 테스트");
		productImage.setContentType("내용 타입 테스트");
		productImage.setDeleteFlag(0);
		productImage.setCreateDate(new Date());
		productImage.setModifyDate(new Date());
		
		List<ProductImageDTO> list = new ArrayList<>();
		list.add(productImage);
		
		given(productImageDao.selectByProductId(1L, "ma")).willReturn(list);
		
		// when
		List<ProductImageDTO> result = productImageServiceImpl.getProductImageByProductId(1L, "ma");
		
		// then
		verify(productImageDao).selectByProductId(anyLong(), anyString());
		assertThat(result.size(), is(list.size()));
	}
}
