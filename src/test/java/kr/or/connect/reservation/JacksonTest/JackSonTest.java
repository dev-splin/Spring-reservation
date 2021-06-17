package kr.or.connect.reservation.JacksonTest;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.config.SecurityConfig;
import kr.or.connect.reservation.config.WebMvcContextConfiguration;
import kr.or.connect.reservation.dto.ReservationProductInfoDTO;
import kr.or.connect.reservation.dto.ResponseReservationProductInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcContextConfiguration.class, ApplicationConfig.class, SecurityConfig.class})
public class JackSonTest {

	@Test
	public void responseReservationProductInfoDTOTest() throws Exception{
		ResponseReservationProductInfoDTO responseReservationProductInfoDTO = new ResponseReservationProductInfoDTO();
		responseReservationProductInfoDTO.setSize(1);
		ReservationProductInfoDTO reservationProductInfoDTO = new ReservationProductInfoDTO();
		
		List<ReservationProductInfoDTO> list = Arrays.asList(reservationProductInfoDTO);
		
		responseReservationProductInfoDTO.setItems(list);
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println(mapper.writeValueAsString(responseReservationProductInfoDTO));
	}
	
}
