package kr.or.connect.reservation.ServiceTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dto.CategoryDTO;
import kr.or.connect.reservation.service.impl.CategoryServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
	@InjectMocks
	CategoryServiceImpl categoryService;
	
	@Mock
	CategoryDao categoryDao;
	
	@Test
	public void countTest() throws Exception {
		// given
		given(categoryDao.selectCount()).willReturn(1);
				
		//when
		int result = categoryService.getCount();
		
		//then
		verify(categoryDao).selectCount();
		assertThat(result, is(1));
	}
	
	@Test
	public void countbyCategoryIdTest() throws Exception {
		// given
		given(categoryDao.selectCountByCategoryId(1L)).willReturn(1);
		
		//when
		int result = categoryService.getCountByCategoryId(1L);
		
		//then
		verify(categoryDao).selectCountByCategoryId(anyLong());
		Assert.assertEquals(1, result);
	}

	@Test
	public void selectAllTest() throws Exception {
		// given
		CategoryDTO category = new CategoryDTO();
		category.setCount(1L);
		category.setId(1L);
		category.setName("test");
		List<CategoryDTO> list = new ArrayList<>();
		list.add(category);
		
		given(categoryDao.selectAll()).willReturn(list);
		
		//when
		List<CategoryDTO> result = categoryService.getCategories();
		
		//then
		verify(categoryDao).selectAll();
		Assert.assertEquals(1, result.size());
	}
}
