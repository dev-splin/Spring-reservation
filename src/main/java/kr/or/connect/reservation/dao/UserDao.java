package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.UserDTO;

import static kr.or.connect.reservation.dao.UserDaoSqls.*;

import java.util.Collections; 

@Repository
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<UserDTO> rowMapper = BeanPropertyRowMapper.newInstance(UserDTO.class);
	
	public UserDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public UserDTO getUserByEmail(String email) {
		return jdbc.queryForObject(SELECT_USER_BY_EMAIL, Collections.singletonMap("email", email), rowMapper);
	}
	
}
