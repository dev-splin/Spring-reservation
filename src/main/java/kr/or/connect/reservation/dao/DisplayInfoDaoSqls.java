package kr.or.connect.reservation.dao;

public class DisplayInfoDaoSqls {
	final static String SELECT_DISPLAY_INFO_BY_CATEGORY_ID = 
			"SELECT p.id, category_id, d.id display_info_id, name, description, "
			+ "content, event, opening_hours, place_name, place_lot, place_street, "
			+ "tel, homepage, email, p.create_date, p.modify_date, file_id FROM "
			+ "product p "
			+ "JOIN category c on c.id = p.category_id "
			+ "JOIN display_info d on p.id = d.product_id "
			+ "JOIN product_image pimg on d.product_id = pimg.product_id "
			+ "where type = 'ma' AND :categoryId = 3 order by id limit :start, 4";
	
	final static String SELECT_DISPLAY = 
			"SELECT p.id, category_id, d.id display_info_id, name, description, "
			+ "content, event, opening_hours, place_name, place_lot, place_street, "
			+ "tel, homepage, email, p.create_date, p.modify_date, file_id FROM "
			+ "product p "
			+ "JOIN category c on c.id = p.category_id "
			+ "JOIN display_info d on p.id = d.product_id "
			+ "JOIN product_image pimg on d.product_id = pimg.product_id "
			+ "where type = 'ma' ORDER BY id limit :start, 4";
	
	final static String SELECT_DINPLAY_INFO_BY_DISPLAY_INFO_ID = 
			"SELECT p.id, category_id, d.id display_info_id, name, description, "
			+ "content, event, opening_hours, place_name, place_lot, place_street, "
			+ "tel, homepage, email, p.create_date, p.modify_date, file_id FROM "
			+ "product p "
			+ "JOIN category c on c.id = p.category_id "
			+ "JOIN display_info d on p.id = d.product_id "
			+ "JOIN product_image pimg on d.product_id = pimg.product_id "
			+ "where type = 'ma' AND d.id = :displayInfoId";
}
