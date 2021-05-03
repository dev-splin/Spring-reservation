package kr.or.connect.reservation.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationUserComment {
	private Long id;
	private Long productId;
	private Long reservationInfoId;
	private Long userId;
	private Integer score;
	private String comment;
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
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(Long reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
		return "ReservationUserComment [id=" + id + ", productId=" + productId + ", reservationInfoId="
				+ reservationInfoId + ", userId=" + userId + ", score=" + score + ", comment=" + comment
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
}
