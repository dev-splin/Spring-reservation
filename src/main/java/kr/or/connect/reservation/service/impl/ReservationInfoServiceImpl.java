package kr.or.connect.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dao.ReservationInfoPriceDao;
import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.RequestReservationInfoPriceDTO;
import kr.or.connect.reservation.dto.ReservationInfoDTO;
import kr.or.connect.reservation.dto.ReservationInfoPriceDTO;
import kr.or.connect.reservation.dto.ResponseRegisterReservationInfoDTO;
import kr.or.connect.reservation.mapper.ReservationInfoMapper;
import kr.or.connect.reservation.service.ReservationInfoService;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService {
	private final ReservationInfoDao reservationInfoDao;
	private final ReservationInfoPriceDao reservationInfoPriceDao;
	
	public ReservationInfoServiceImpl(ReservationInfoDao reservationInfoDao,
			ReservationInfoPriceDao reservationInfoPriceDao) {
		this.reservationInfoDao = reservationInfoDao;
		this.reservationInfoPriceDao = reservationInfoPriceDao;
	}

	@Override
	@Transactional
	public ResponseRegisterReservationInfoDTO RegisterReservation(
			RequestReservationInfoDTO requestReservationInfoDTO) {
		
		Long reservationInfoId = reservationInfoDao.insertReservationInfo(
				requestReservationInfoDTO);
		
		ReservationInfoDTO reservationInfoDTO = reservationInfoDao.getReservationInfoById(reservationInfoId);
		
		ResponseRegisterReservationInfoDTO responseRegisterReservationInfoDTO = new ResponseRegisterReservationInfoDTO();
		responseRegisterReservationInfoDTO.setReservationInfoDTO(reservationInfoDTO);
		
		List<ReservationInfoPriceDTO> list = new ArrayList<>();
		
		for(RequestReservationInfoPriceDTO requestReservationInfoPriceDTO : 
			requestReservationInfoDTO.getPrices()) {
			Long id = reservationInfoPriceDao.insertReservationInfo(requestReservationInfoPriceDTO, reservationInfoId);
			list.add(reservationInfoPriceDao.getReservationInfoPriceById(id));
		}
		
		responseRegisterReservationInfoDTO.setPrices(list);
		
		return responseRegisterReservationInfoDTO;
	}

	@Override
	@Transactional
	public int reservationCancel(Long id) {
		return reservationInfoDao.getCancelFlagById(id);
	}
}
