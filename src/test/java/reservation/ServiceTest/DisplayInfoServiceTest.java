package reservation.ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.DisplayInfoDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.service.impl.DisplayInfoServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DisplayInfoServiceTest {
	@InjectMocks
	DisplayInfoServiceImpl displayInfoServiceImpl;
	
	@Mock
	DisplayInfoDao displayInfoDao;
	
	@Test
	public void getDisplayInfoByCategoryIdTest() throws Exception {
		//given
		DisplayInfo displayInfo = new DisplayInfo();
		displayInfo.setId(21L);
		displayInfo.setCategoryId(3L);
		displayInfo.setDisplayInfoId(21L);
		displayInfo.setName("이름 테스트");
		displayInfo.setDescription("설명 테스트");
		displayInfo.setContent("내용 테스트.");
		displayInfo.setEvent("이벤트 테스트");
		displayInfo.setOpeningHours("2021년 5월 17일(월) 9PM");
		displayInfo.setPlaceName("장소 테스트");
		displayInfo.setPlaceLot("주소 테스트");
		displayInfo.setPlaceStreet("도로 주소 테스트");
		displayInfo.setTel("010-1234-5678");
		displayInfo.setHomepage("https://dev-splin.github.io/");
		displayInfo.setEmail("dev.splin@gmail.com");
		displayInfo.setCreateDate(new Date());
		displayInfo.setModifyDate(new Date());
		displayInfo.setFileId(113L);
		
		List<DisplayInfo> list = new ArrayList<>();
		list.add(displayInfo);
		
		given(displayInfoDao.selectByCategoryId(3L, 0L)).willReturn(list);
		
		//when
		List<DisplayInfo> result = displayInfoServiceImpl.getDisplayInfoByCategoryId(3L, 0L);
		
		//then
		verify(displayInfoDao).selectByCategoryId(anyLong(), anyLong());
		assertThat(result.size(), is(list.size()));
	}
	
	@Test
	public void getDisplayInfoTest() throws Exception {
		//given
		DisplayInfo displayInfo = new DisplayInfo();
		displayInfo.setId(21L);
		displayInfo.setCategoryId(3L);
		displayInfo.setDisplayInfoId(21L);
		displayInfo.setName("이름 테스트");
		displayInfo.setDescription("설명 테스트");
		displayInfo.setContent("내용 테스트.");
		displayInfo.setEvent("이벤트 테스트");
		displayInfo.setOpeningHours("2021년 5월 17일(월) 9PM");
		displayInfo.setPlaceName("장소 테스트");
		displayInfo.setPlaceLot("주소 테스트");
		displayInfo.setPlaceStreet("도로 주소 테스트");
		displayInfo.setTel("010-1234-5678");
		displayInfo.setHomepage("https://dev-splin.github.io/");
		displayInfo.setEmail("dev.splin@gmail.com");
		displayInfo.setCreateDate(new Date());
		displayInfo.setModifyDate(new Date());
		displayInfo.setFileId(113L);
		
		List<DisplayInfo> list = new ArrayList<>();
		list.add(displayInfo);
		
		given(displayInfoDao.selectAll(3L)).willReturn(list);
		
		//when
		List<DisplayInfo> result = displayInfoServiceImpl.getDisplayInfo(3L);
		
		//then
		verify(displayInfoDao).selectAll(anyLong());
		assertThat(result.size(), is(list.size()));
	}
	
	@Test
	public void getDisplayInfoByDisplayInfoIdTest() throws Exception {
		//given
		DisplayInfo displayInfo = new DisplayInfo();
		displayInfo.setId(1L);
		displayInfo.setCategoryId(1L);
		displayInfo.setDisplayInfoId(1L);
		displayInfo.setName("이름 테스트");
		displayInfo.setDescription("설명 테스트");
		displayInfo.setContent("내용 테스트.");
		displayInfo.setEvent("이벤트 테스트");
		displayInfo.setOpeningHours("2021년 5월 17일(월) 9PM");
		displayInfo.setPlaceName("장소 테스트");
		displayInfo.setPlaceLot("주소 테스트");
		displayInfo.setPlaceStreet("도로 주소 테스트");
		displayInfo.setTel("010-1234-5678");
		displayInfo.setHomepage("https://dev-splin.github.io/");
		displayInfo.setEmail("dev.splin@gmail.com");
		displayInfo.setCreateDate(new Date());
		displayInfo.setModifyDate(new Date());
		displayInfo.setFileId(113L);
		
		
		given(displayInfoDao.selectByDisplayInfoId(1L)).willReturn(displayInfo);
		
		//when
		DisplayInfo result = displayInfoServiceImpl.getDisplayInfoByDisplayInfoId(1L);
		
		//then
		verify(displayInfoDao).selectByDisplayInfoId(anyLong());
		assertThat(result, is(displayInfo));
	}
}
