package kr.or.connect.reservation.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DisplayInfoImage {
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(Long displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public Long getfileId() {
		return fileId;
	}
	public void setfileId(Long file_id) {
		this.fileId = file_id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	@Override
	public String toString() {
		return "DisplayInfoImage [id=" + id + ", displayInfoId=" + displayInfoId + ", fileId=" + fileId
				+ ", fileName=" + fileName + ", saveFileName=" + saveFileName + ", contentType=" + contentType
				+ ", deleteFlag=" + deleteFlag + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
}
