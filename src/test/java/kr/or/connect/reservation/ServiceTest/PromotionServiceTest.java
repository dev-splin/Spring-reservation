package kr.or.connect.reservation.ServiceTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.PromotionDTO;
import kr.or.connect.reservation.service.impl.PromotionServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class PromotionServiceTest {
	@InjectMocks
	PromotionServiceImpl promotionServiceImpl;
	
	@Mock
	PromotionDao promotionDao;
	
	@Test
	public void selectAllTest() throws Exception {
		// given
		PromotionDTO promotion = new PromotionDTO();
		promotion.setId(1L);
		promotion.setProductId(1L);
		promotion.setCategoryId(1L);
		promotion.setCategoryName("카테고리 이름 테스트");
		promotion.setDescription("설명 테스트");
		promotion.setFileId(61L);
		
		List<PromotionDTO> list = new ArrayList<>();
		list.add(promotion); 
		
		given(promotionDao.selectAll()).willReturn(list);
		
		//when
		List<PromotionDTO> result = promotionServiceImpl.getPromotion();
		
		//then
		verify(promotionDao).selectAll();
		assertThat(result.size(), is(list.size()));
	}
}
