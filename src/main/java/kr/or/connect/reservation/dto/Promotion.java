package kr.or.connect.reservation.dto;

// product, promotion, category, product_image 테이블 사용
public class Promotion {
	int id;
	int productId;
	int categoryId;
	String categoryName;
	String description;
	int fileId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", productId=" + productId + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", description=" + description + ", fileId=" + fileId + "]";
	}
}
