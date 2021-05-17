package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
	final static String SELECT_GROUP_COUNT = "SELECT c.id id, c.name name, count(c.id) count "
			+ "FROM category c JOIN product p ON c.id = p.category_id "
			+ "JOIN display_info d ON p.id = d.product_id "
			+ "GROUP BY c.id ORDER BY id asc";
	
	final static String SELECT_COUNT_BY_CATEGORY_ID = "SELECT count(c.id) count "
			+ "FROM category c JOIN product p ON c.id = p.category_id "
			+ "JOIN display_info d ON p.id = d.product_id "
			+ "WHERE c.id = :categoryId";
	
	final static String SELECT_COUNT = "SELECT count(c.id) count "
			+ "FROM category c JOIN product p ON c.id = p.category_id "
			+ "JOIN display_info d ON p.id = d.product_id";
}
