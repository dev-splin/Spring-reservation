package kr.or.connect.reservation.ApiControllerTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.SecurityConfig;
import kr.or.connect.reservation.config.WebMvcContextConfiguration;
import kr.or.connect.reservation.controller.api.DisplayinfoApiController;
import kr.or.connect.reservation.dto.DisplayInfoDTO;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.DisplayInfoService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcContextConfiguration.class, ApplicationConfig.class, SecurityConfig.class})
public class DisplayInfoApiControllerTest {

	@InjectMocks
	DisplayinfoApiController displayinfoApiController;
	@Mock
	CategoryService categoryService;
	@Mock
	DisplayInfoService displayInfoService;
	
	private MockMvc mockMvc;
	@Before
	public void createController() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(displayinfoApiController).build();
	}
	
	@Test
	public void getDisplayInfos() throws Exception {
		DisplayInfoDTO displayInfo = new DisplayInfoDTO();
		displayInfo.setId(21L);
		displayInfo.setCategoryId(3L);
		displayInfo.setName("테스트이름");
		displayInfo.setDescription("테스트설명");
		displayInfo.setContent("테스트 중 입니다.");
		displayInfo.setEvent("이벤트는 없습니다.");
		displayInfo.setOpeningHours("2021년 4월 28일(수) 9PM");
		displayInfo.setPlaceName("우리 집");
		displayInfo.setPlaceLot("주소는 비밀입니다.");
		displayInfo.setPlaceStreet("주소 길도 비밀입니다.");
		displayInfo.setTel("전화번호도 비밀입니다.");
		displayInfo.setHomepage("https://dev-splin.github.io/");
		displayInfo.setEmail("dev.splin@gmail.com");
		displayInfo.setCreateDate(new Date());
		displayInfo.setModifyDate(new Date());
		displayInfo.setFileId(28L);
		
		List<DisplayInfoDTO> list = Arrays.asList(displayInfo);
		when(categoryService.getCountByCategoryId(3L)).thenReturn(1);
		when(displayInfoService.getDisplayInfoByCategoryId(3L, 0L)).thenReturn(list);
		
		RequestBuilder reqbuilder = MockMvcRequestBuilders.get("/api/displayinfos?categoryId="+3).contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(reqbuilder).andExpect(status().isOk()).andDo(print());
		
		verify(categoryService).getCountByCategoryId(3L);
		verify(displayInfoService).getDisplayInfoByCategoryId(3L, 0L);
	}
}
