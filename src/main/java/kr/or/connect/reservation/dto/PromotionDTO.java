package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// product, promotion, category, product_image 테이블 사용
public class PromotionDTO {
	Long id;
	Long productId;
	Long categoryId;
	String categoryName;
	String description;
	Long fileId;
}
