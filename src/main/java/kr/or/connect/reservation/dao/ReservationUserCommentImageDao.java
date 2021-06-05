package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationUserCommentImageDTO;

import static kr.or.connect.reservation.dao.ReservationUserCommentImageDaoSqls.*;

@Repository
public class ReservationUserCommentImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationUserCommentImageDTO> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentImageDTO.class);
	
	public ReservationUserCommentImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationUserCommentImageDTO> selectByReservationUserId(Long reservationUserId) {
		return jdbc.query(SELECT_BY_RESERVATION_USER_ID, Collections.singletonMap("reservationUserId", reservationUserId),rowMapper);
	}
}
