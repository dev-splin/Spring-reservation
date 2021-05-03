package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfoImage;

public interface DisplayInfoImageService {
	public List<DisplayInfoImage> getDisplayImageByDisplayInfoId(Long displayInfoId);
}
