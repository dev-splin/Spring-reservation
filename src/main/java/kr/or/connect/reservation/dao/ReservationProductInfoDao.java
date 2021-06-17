package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationProductInfoDTO;
import static kr.or.connect.reservation.dao.ReservationProductInfoDaoSqls.*;

@Repository
public class ReservationProductInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationProductInfoDTO>  rowMapper = BeanPropertyRowMapper.newInstance(ReservationProductInfoDTO.class);
	
	public ReservationProductInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationProductInfoDTO> getReservationProductInfoByUserId(Long userId) {
		return jdbc.query(SELECT_RESERVATION_PRODUCT_INFO_BY_USER_ID, Collections.singletonMap("userId", userId) ,rowMapper);
	}
}
