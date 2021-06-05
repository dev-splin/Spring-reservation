package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.UserRoleDTO;

import static kr.or.connect.reservation.dao.UserRoleDaoSqls.*;

import java.util.Collections;
import java.util.List; 

@Repository
public class UserRoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<UserRoleDTO> rowMapper = BeanPropertyRowMapper.newInstance(UserRoleDTO.class);
	
	public UserRoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<UserRoleDTO> getUserRoleByEmail(String email) {
		return jdbc.query(SELECT_USERROLE_BY_EMAIL, Collections.singletonMap("email", email), rowMapper);
	}
	
}
