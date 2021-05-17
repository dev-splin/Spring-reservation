package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	final static String SELECT_PROMOTION = 
			"SELECT pm.id, pm.product_id, p.category_id, c.name category_name, p.description, i.file_id FROM "
			+ "promotion pm "
			+ "JOIN product p on pm.product_id = p.id "
			+ "JOIN category c on p.category_id = c.id "
			+ "JOIN product_image i on p.id = i.product_id "
			+ "WHERE i.type = \"ma\"";
}
