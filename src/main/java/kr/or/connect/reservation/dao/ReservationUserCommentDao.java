package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationUserCommentDTO;
import static kr.or.connect.reservation.dao.ReservationUserCommentDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReservationUserCommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationUserCommentDTO> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentDTO.class);
	
	public ReservationUserCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Integer selectAvgScoreByProductId(Long productId) {
		return jdbc.queryForObject(SELECT_SCORE_AVG_BY_PRODUCT_ID, Collections.singletonMap("productId", productId), Integer.class);
	}
	
	public List<ReservationUserCommentDTO> selectReservationUserCommentByProductId(Long productId, int start, int limit) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_RESERVATION_USER_COMMENT_BY_PRODUCT_ID, params, rowMapper);
	}
	
	public int selectReservationUserCommentCount(Long productId) {
		return jdbc.queryForObject(SELECT_RESERVATION_USER_COMMENT_COUNT, Collections.singletonMap("productId", productId) ,Integer.class);
	}
}
