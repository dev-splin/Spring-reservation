package kr.or.connect.reservation.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
// product_price 테이블만 사용
public class ProductPriceDTO {
	private Long id;
	private Long productId;
	private String priceTypeName;
	private Integer price;
	private Integer discountRate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
	private Date modifyDate;
}
