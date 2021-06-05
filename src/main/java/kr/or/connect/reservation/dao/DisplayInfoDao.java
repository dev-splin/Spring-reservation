package kr.or.connect.reservation.dao;



import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfoDTO;

import static kr.or.connect.reservation.dao.DisplayInfoDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoDTO> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDTO.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfoDTO> selectByCategoryId(Long categoryId, Long start) {
		Map<String, Long> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		return jdbc.query(SELECT_DISPLAY_INFO_BY_CATEGORY_ID, params, rowMapper);
	}
	
	public List<DisplayInfoDTO> selectAll(Long start) {
		return jdbc.query(SELECT_DISPLAY, Collections.singletonMap("start", start), rowMapper);
	}
	
	public DisplayInfoDTO selectByDisplayInfoId(Long displayInfoId) {
		return jdbc.queryForObject(SELECT_DINPLAY_INFO_BY_DISPLAY_INFO_ID, Collections.singletonMap("displayInfoId", displayInfoId), rowMapper);
	}
}
