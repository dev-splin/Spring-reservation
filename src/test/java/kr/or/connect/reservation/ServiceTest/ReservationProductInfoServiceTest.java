package kr.or.connect.reservation.ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.ReservationProductInfoDao;
import kr.or.connect.reservation.dto.ReservationProductInfoDTO;
import kr.or.connect.reservation.dto.ResponseReservationProductInfoDTO;
import kr.or.connect.reservation.service.impl.ReservationProductInfoServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ReservationProductInfoServiceTest {
	@InjectMocks
	ReservationProductInfoServiceImpl reservationProductInfoServiceImpl;
	
	@Mock
	ReservationProductInfoDao reservationProductInfoDao;
	
	@Test
	public void reservationProductInfoServiceImplTest() {
		// given
		ReservationProductInfoDTO reservationProductInfoDTO = new ReservationProductInfoDTO();
		reservationProductInfoDTO.setId(16L);
		reservationProductInfoDTO.setProductId(1L);
		reservationProductInfoDTO.setDisplayInfoId(1L);
		reservationProductInfoDTO.setCancelFlag(1);
		reservationProductInfoDTO.setProductDescription("description test");
		reservationProductInfoDTO.setProductContent("content test");
		reservationProductInfoDTO.setUserId(1L);
		reservationProductInfoDTO.setSumPrice(4000);
		reservationProductInfoDTO.setReservationDate(new Date());
		reservationProductInfoDTO.setCreateDate(new Date());
		reservationProductInfoDTO.setModifyDate(new Date());
		
		List<ReservationProductInfoDTO> list = Arrays.asList(reservationProductInfoDTO);
		
		
		given(reservationProductInfoDao.getReservationProductInfoByUserId(1L)).willReturn(list);
		
		// when
		ResponseReservationProductInfoDTO result = reservationProductInfoServiceImpl.getReservationProductInfo(1L);
		
		// then
		assertThat(result.getSize(), is(1));
	}
}
