package kr.or.connect.reservation.ServiceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.DisplayInfoImageDao;
import kr.or.connect.reservation.dto.DisplayInfoImageDTO;
import kr.or.connect.reservation.service.impl.DisplayInfoImageServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class DisplayInfoImageServiceTest {
	@InjectMocks
	DisplayInfoImageServiceImpl displayInfoImageServiceImpl;
	
	@Mock
	DisplayInfoImageDao displayInfoImageDao;
	
	@Test
	public void selectByIdTest() {
		// given
		DisplayInfoImageDTO displayInfoImage = new DisplayInfoImageDTO();
		displayInfoImage.setId(1L);
		displayInfoImage.setDisplayInfoId(1L);
		displayInfoImage.setFileId(1L);
		displayInfoImage.setFileName("파일 이름 테스트");
		displayInfoImage.setSaveFileName("세이브 파일 이름 테스트");
		displayInfoImage.setContentType("내용 타입 테스트");
		displayInfoImage.setDeleteFlag(0);
		displayInfoImage.setCreateDate(new Date());
		displayInfoImage.setModifyDate(new Date());
		
		List<DisplayInfoImageDTO> list = new ArrayList<>();
		list.add(displayInfoImage);
		
		given(displayInfoImageDao.selectByDisplayInfoId(1L)).willReturn(list);
		
		// when
		List<DisplayInfoImageDTO> result = displayInfoImageDao.selectByDisplayInfoId(1L);
		
		// then
		verify(displayInfoImageDao).selectByDisplayInfoId(anyLong());
		assertThat(result.size(), is(list.size()));
	}
}
