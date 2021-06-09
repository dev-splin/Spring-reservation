package kr.or.connect.reservation.dao;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.RequestReservationInfoPriceDTO;
import kr.or.connect.reservation.dto.ReservationInfoPriceDTO;
import kr.or.connect.reservation.mapper.ReservationInfoPriceMapper;

import static kr.or.connect.reservation.dao.ReservationInfoPriceDaoSqls.*;

@Repository
public class ReservationInfoPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insert;
	private RowMapper<ReservationInfoPriceDTO>  rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoPriceDTO.class);
	
	public ReservationInfoPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insert = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info_price")
				.usingGeneratedKeyColumns("id");
	}
	
	public ReservationInfoPriceDTO getReservationInfoPriceById(Long id) {
		return jdbc.queryForObject(SELECT_RESERVATION_INFO_PRICE_BY__ID, Collections.singletonMap("id", id), rowMapper);
		
	}
	
	public Long insertReservationInfo(RequestReservationInfoPriceDTO requestReservationInfoPriceDTO, Long reservationInfoId) {
		ReservationInfoPriceDTO reservationInfoPriceDTO = ReservationInfoPriceMapper.INSTANCE.DTOToEntity(requestReservationInfoPriceDTO);
		reservationInfoPriceDTO.setReservationInfoId(reservationInfoId);
		
		return insert.executeAndReturnKey(new BeanPropertySqlParameterSource(reservationInfoPriceDTO)).longValue();
	}
}
