package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfo;

public interface DisplayInfoService {
	List<DisplayInfo> getDisplayInfoByCategoryId(Long categoryId, Long start);
	List<DisplayInfo> getDisplayInfo(Long start);
	DisplayInfo getDisplayInfoByDisplayInfoId(Long displayInfoId);
}
