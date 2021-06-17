package kr.or.connect.reservation.ApiControllerTest;

import org.junit.Before;
import org.junit.BeforeClass;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.SecurityConfig;
import kr.or.connect.reservation.config.WebMvcContextConfiguration;
import kr.or.connect.reservation.controller.api.ReservationInfoApiController;
import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.RequestReservationInfoPriceDTO;
import kr.or.connect.reservation.dto.ReservationInfoDTO;
import kr.or.connect.reservation.dto.ReservationInfoPriceDTO;
import kr.or.connect.reservation.dto.ResponseRegisterReservationInfoDTO;
import kr.or.connect.reservation.service.ReservationInfoService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcContextConfiguration.class, ApplicationConfig.class, SecurityConfig.class})
public class ReservationInfoApiControllerTest {
	
	@InjectMocks
	ReservationInfoApiController reservationInfoApiController;
	
	@Mock
	ReservationInfoService reservationInfoService;
	
	private MockMvc mockMvc;
	
//	private static Validator validator;
//	
//	@BeforeClass
//	public static void init() {
//		validator = Validation.buildDefaultValidatorFactory().getValidator();
//	}
	
	@Before
	public void createController() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(reservationInfoApiController).addFilters(new CharacterEncodingFilter("UTF-8",true)).build();
	}
	
//	@Test
//	public void validTest() throws Exception {
//		RequestReservationInfoDTO dto = new RequestReservationInfoDTO();
//		dto.setProductId(1L);
//		RequestReservationInfoPriceDTO priceDTO = new RequestReservationInfoPriceDTO();
//		
//		List<RequestReservationInfoPriceDTO> prices = new ArrayList<>();
//		prices.add(priceDTO);
//		
//		dto.setPrices(prices);
//		
//		Set<ConstraintViolation<RequestReservationInfoDTO>> set = validator.validate(dto);
//		
//		for(ConstraintViolation<RequestReservationInfoDTO> objectError : set) {
//			System.err.println("message : " + objectError.getMessage());
//			System.err.println("propertyPath : " + objectError.getPropertyPath());
//			System.err.println("invalidValue : " + objectError.getInvalidValue());
//		}
//	}
	
	@Test
	public void reservationRegisterTest() throws Exception{
		// given
		RequestReservationInfoDTO dto = new RequestReservationInfoDTO();
		dto.setProductId(1L);
		dto.setDisplayInfoId(1L);
		dto.setReservationYearMonthDay(new Date());
		dto.setUserId(1L);
		
		List<RequestReservationInfoPriceDTO> prices = new ArrayList<>();
		RequestReservationInfoPriceDTO priceDTO = new RequestReservationInfoPriceDTO();
		priceDTO.setCount(2);
		priceDTO.setProductPriceId(3L);
		prices.add(priceDTO);
		dto.setPrices(prices);
		
		ResponseRegisterReservationInfoDTO response = new ResponseRegisterReservationInfoDTO();
		ReservationInfoDTO reservationInfoDTO = new ReservationInfoDTO();
		reservationInfoDTO.setId(17L);
		reservationInfoDTO.setProductId(1L);
		reservationInfoDTO.setCancelFlag(0);
		reservationInfoDTO.setDisplayInfoId(1L);
		reservationInfoDTO.setUserId(1L);
		reservationInfoDTO.setReservationDate(dto.getReservationYearMonthDay());
		reservationInfoDTO.setCreateDate(new Date());
		reservationInfoDTO.setModifyDate(new Date());
		response.setReservationInfoDTO(reservationInfoDTO);
		
		List<ReservationInfoPriceDTO> responsePrices = new ArrayList<>();
		ReservationInfoPriceDTO responsePriceDTO = new ReservationInfoPriceDTO();
		responsePriceDTO.setId(21L);
		responsePriceDTO.setReservationInfoId(response.getReservationInfoDTO().getId());
		responsePriceDTO.setProductPriceId(priceDTO.getProductPriceId());
		responsePriceDTO.setCount(priceDTO.getCount());
		responsePrices.add(responsePriceDTO);
		
		response.setPrices(responsePrices);
		
		// when 
		when(reservationInfoService.RegisterReservation(any(RequestReservationInfoDTO.class))).thenReturn(response);
		
		// then
		ObjectMapper mapper = new ObjectMapper();
		mockMvc.perform(post("/api/reservationInfos")
				.content(mapper.writeValueAsString(dto))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}
}
