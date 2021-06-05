package kr.or.connect.reservation.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
// display_info_image, file_info 테이블 사용
public class DisplayInfoImageDTO {
	private Long id;
	private Long displayInfoId;
	private Long fileId;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private int deleteFlag;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	private Date modifyDate;
}
