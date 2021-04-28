package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.DisplayInfoDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService{
	@Autowired
	DisplayInfoDao displayInfoDao;

	@Override
	@Transactional
	public List<DisplayInfo> getDisplayInfoById(int categoryId, int start) {
		return displayInfoDao.selectById(categoryId, start);
	}

	@Override
	@Transactional
	public List<DisplayInfo> getDisplayInfo(int start) {
		return displayInfoDao.selectAll(start);
	}
}
