package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfoDTO;

public interface DisplayInfoService {
	List<DisplayInfoDTO> getDisplayInfoByCategoryId(Long categoryId, Long start);
	List<DisplayInfoDTO> getDisplayInfo(Long start);
	DisplayInfoDTO getDisplayInfoByDisplayInfoId(Long displayInfoId);
}
