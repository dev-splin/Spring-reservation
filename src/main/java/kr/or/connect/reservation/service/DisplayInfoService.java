package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfo;

public interface DisplayInfoService {
	public List<DisplayInfo> getDisplayInfoById(int categoryId, int start);
	public List<DisplayInfo> getDisplayInfo(int start);
}
