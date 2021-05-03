package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ProductImage;

import static kr.or.connect.reservation.dao.ProductImageDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	
	public ProductImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductImage> selectByProductId(Long productId, String type) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		params.put("type", type);
		
		return jdbc.query(SELECT_PRODUCT_IMAGE_BY_PRODUCT_ID, params, rowMapper);
	}
}
