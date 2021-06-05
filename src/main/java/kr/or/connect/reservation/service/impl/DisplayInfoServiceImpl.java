package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.DisplayInfoDao;
import kr.or.connect.reservation.dto.DisplayInfoDTO;
import kr.or.connect.reservation.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService{
	@Autowired
	DisplayInfoDao displayInfoDao;

	@Override
	@Transactional
	public List<DisplayInfoDTO> getDisplayInfoByCategoryId(Long categoryId, Long start) {
		return displayInfoDao.selectByCategoryId(categoryId, start);
	}

	@Override
	@Transactional
	public List<DisplayInfoDTO> getDisplayInfo(Long start) {
		return displayInfoDao.selectAll(start);
	}

	@Override
	@Transactional
	public DisplayInfoDTO getDisplayInfoByDisplayInfoId(Long displayInfoId) {
		return displayInfoDao.selectByDisplayInfoId(displayInfoId);
	}
}
