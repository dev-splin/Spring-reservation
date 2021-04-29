package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;

import static kr.or.connect.reservation.dao.CategoryDaoSqls.*;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category>  rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> selectAll() {
		return jdbc.query(SELECT_GROUP_COUNT, rowMapper);
	}
	
	public int selectCountById(Long categoryId) {
		return jdbc.queryForObject(SELECT_COUNT_BY_ID, Collections.singletonMap("categoryId", categoryId), Integer.class);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
}
