package kr.or.connect.reservation.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductPriceEntity {
	private Long id;
	private Long productId;
	private String priceTypeName;
	private Integer price;
	private Integer discountRate;
	private Date createDate;
	private Date modifyDate;
	
	@Builder
	private ProductPriceEntity(Long id, Long productId, String priceTypeName, Integer price,
			Integer discountRate, Date createDate, Date modifyDate) {
		this.id = id;
		this.productId = productId;
		this.priceTypeName = priceTypeName;
		this.price = price;
		this.discountRate = discountRate;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
}
