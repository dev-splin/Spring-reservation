package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfo;

public interface DisplayInfoService {
	public List<DisplayInfo> getDisplayInfoById(Long categoryId, Long start);
	public List<DisplayInfo> getDisplayInfo(Long start);
}
