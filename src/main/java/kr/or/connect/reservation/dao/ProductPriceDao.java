package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ProductPriceDTO;

import static kr.or.connect.reservation.dao.ProductPriceDaoSqls.*;

@Repository
public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductPriceDTO> rowMapper = BeanPropertyRowMapper.newInstance(ProductPriceDTO.class);
	
	public ProductPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductPriceDTO> selectByProductId(Long productId) {
		return jdbc.query(SELECT_PRODUCT_PRICE_BY_PRODUCT_ID, Collections.singletonMap("productId", productId), rowMapper);
	}
}
