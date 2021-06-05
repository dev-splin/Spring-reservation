package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfoImageDTO;

public interface DisplayInfoImageService {
	List<DisplayInfoImageDTO> getDisplayImageByDisplayInfoId(Long displayInfoId);
}
