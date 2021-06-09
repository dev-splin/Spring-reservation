package kr.or.connect.reservation.ServiceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dao.ReservationInfoPriceDao;
import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.RequestReservationInfoPriceDTO;
import kr.or.connect.reservation.dto.ReservationInfoDTO;
import kr.or.connect.reservation.dto.ReservationInfoPriceDTO;
import kr.or.connect.reservation.dto.ResponseRegisterReservationInfoDTO;
import kr.or.connect.reservation.service.impl.ReservationInfoServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ReservationInfoServiceTest {
	@InjectMocks
	ReservationInfoServiceImpl reservationInfoServiceImpl;
	
	@Mock
	ReservationInfoDao reservationInfoDao;
	
	@Mock
	ReservationInfoPriceDao reservationInfoPriceDao;
	
	@Test
	public void registerReservationTest() {
		// given
		
		ReservationInfoDTO reservationInfoDTO = new ReservationInfoDTO();
		reservationInfoDTO.setId(1L);
		reservationInfoDTO.setProductId(1L);
		reservationInfoDTO.setCancelFlag(0);
		reservationInfoDTO.setDisplayInfoId(1L);
		reservationInfoDTO.setUserId(1L);
		reservationInfoDTO.setReservationDate(new Date());
		reservationInfoDTO.setCreateDate(new Date());
		reservationInfoDTO.setModifyDate(new Date());
		
		ReservationInfoPriceDTO	reservationInfoPriceDTO = new ReservationInfoPriceDTO();
		reservationInfoPriceDTO.setId(1L);
		reservationInfoPriceDTO.setReservationInfoId(1L);
		reservationInfoPriceDTO.setProductPriceId(1L);
		reservationInfoPriceDTO.setCount(1);
		
		RequestReservationInfoDTO requestReservationInfoDTO = 
				new RequestReservationInfoDTO();
		
		requestReservationInfoDTO.setProductId(1L);
		requestReservationInfoDTO.setDisplayInfoId(1L);
		requestReservationInfoDTO.setReservationYearMonthDay(new Date());
		requestReservationInfoDTO.setUserId(1L);
		
		RequestReservationInfoPriceDTO requestReservationInfoPriceDTO = new RequestReservationInfoPriceDTO();
		requestReservationInfoPriceDTO.setProductPriceId(1L);
		requestReservationInfoPriceDTO.setCount(1);
		
		List<RequestReservationInfoPriceDTO> list = new ArrayList<>();
		list.add(requestReservationInfoPriceDTO);
		
		requestReservationInfoDTO.setPrices(list);
		
		given(reservationInfoDao.insertReservationInfo(requestReservationInfoDTO)).willReturn(1L);
		given(reservationInfoDao.getReservationInfoById(1L)).willReturn(reservationInfoDTO);
		given(reservationInfoPriceDao.insertReservationInfo(requestReservationInfoPriceDTO, 1L)).willReturn(1L);
		given(reservationInfoPriceDao.getReservationInfoPriceById(1L)).willReturn(reservationInfoPriceDTO);
		
		// when
		ResponseRegisterReservationInfoDTO result = reservationInfoServiceImpl.RegisterReservation(requestReservationInfoDTO);
		
		System.out.println(result);
		
		// then
		verify(reservationInfoDao).getReservationInfoById(anyLong());
		verify(reservationInfoPriceDao).getReservationInfoPriceById(anyLong());
		assertThat(result.getId(), is(1L));
	}
}
