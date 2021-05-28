package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.UserRole;

import static kr.or.connect.reservation.dao.UserRoleDaoSqls.*;

import java.util.Collections;
import java.util.List; 

@Repository
public class UserRoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<UserRole> rowMapper = BeanPropertyRowMapper.newInstance(UserRole.class);
	
	public UserRoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<UserRole> getUserRoleByEmail(String email) {
		return jdbc.query(SELECT_USERROLE_BY_EMAIL, Collections.singletonMap("email", email), rowMapper);
	}
	
}
