package kr.or.connect.reservation.dao;



import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfo;

import static kr.or.connect.reservation.dao.DisplayInfoDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfo> selectByCategoryId(Long categoryId, Long start) {
		Map<String, Long> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		return jdbc.query(SELECT_DISPLAY_INFO_BY_CATEGORY_ID, params, rowMapper);
	}
	
	public List<DisplayInfo> selectAll(Long start) {
		return jdbc.query(SELECT_DISPLAY, Collections.singletonMap("start", start), rowMapper);
	}
	
	public DisplayInfo selectByDisplayInfoId(Long displayInfoId) {
		return jdbc.queryForObject(SELECT_DINPLAY_INFO_BY_DISPLAY_INFO_ID, Collections.singletonMap("display_info_id", displayInfoId), rowMapper);
	}
}
