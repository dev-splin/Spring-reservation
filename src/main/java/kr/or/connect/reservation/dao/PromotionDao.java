package kr.or.connect.reservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.PromotionDTO;

import static kr.or.connect.reservation.dao.PromotionDaoSqls.*;

@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<PromotionDTO>  rowMapper = BeanPropertyRowMapper.newInstance(PromotionDTO.class);
	
	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<PromotionDTO> selectAll() {
		return jdbc.query(SELECT_PROMOTION, rowMapper);
	}
}
