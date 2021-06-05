package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfoImageDTO;

import static kr.or.connect.reservation.dao.DisplayInfoImageDaoSqls.*;

@Repository
public class DisplayInfoImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoImageDTO> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImageDTO.class);
	
	public DisplayInfoImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfoImageDTO> selectByDisplayInfoId(Long displayInfoId) {
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_ID, Collections.singletonMap("displayInfoId", displayInfoId), rowMapper);
	}
}
