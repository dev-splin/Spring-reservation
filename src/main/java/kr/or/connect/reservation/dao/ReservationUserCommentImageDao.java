package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationUserCommentImage;

import static kr.or.connect.reservation.dao.ReservationUserCommentImageDaoSqls.*;

@Repository
public class ReservationUserCommentImageDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ReservationUserCommentImage> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentImage.class);
	
	public ReservationUserCommentImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationUserCommentImage> selectByReservationUserId(Long ReservationUserId) {
		return jdbc.query(SELECT_BY_RESERVATION_USER_ID, Collections.singletonMap("reservation_user_comment_id", ReservationUserId),rowMapper);
	}
}
