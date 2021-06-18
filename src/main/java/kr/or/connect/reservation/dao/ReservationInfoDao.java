package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.RequestReservationInfoDTO;
import kr.or.connect.reservation.dto.ReservationInfoDTO;
import kr.or.connect.reservation.mapper.ReservationInfoMapper;

import static kr.or.connect.reservation.dao.ReservationInfoDaoSqls.*;

@Repository
public class ReservationInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insert;
	private RowMapper<ReservationInfoDTO>  rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoDTO.class);
	
	public ReservationInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insert = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}
	
	public ReservationInfoDTO getReservationInfoById(Long id) {
		return jdbc.queryForObject(SELECT_RESERVATION_INFO_BY_ID, Collections.singletonMap("id", id), rowMapper);
	}
	
	public Long insertReservationInfo(RequestReservationInfoDTO requestReservationInfoDTO) {
		ReservationInfoDTO reservationInfoDTO = ReservationInfoMapper.INSTANCE.DTOToEntity(requestReservationInfoDTO);
		reservationInfoDTO.setCancelFlag(0);
		reservationInfoDTO.setCreateDate(new Date());
		reservationInfoDTO.setModifyDate(new Date());
		
		return insert.executeAndReturnKey(new BeanPropertySqlParameterSource(reservationInfoDTO)).longValue();
	}
	
	public int getCancelFlagById(Long id) {
		return jdbc.update(UPDATE_CANCEL_FLAG_BY_RESERVATION_INFO_ID, Collections.singletonMap("id", id));
	}
}
