package kr.or.connect.reservation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//category, product, display_info 테이블 사용
public class CategoryDTO { 
	private Long id;
	private String name;
	private Long count;
}
