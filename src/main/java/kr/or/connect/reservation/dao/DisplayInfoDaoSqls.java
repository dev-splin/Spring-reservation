package kr.or.connect.reservation.dao;

public class DisplayInfoDaoSqls {
	final static String SELECT_DISPLAY_INFO_BY_CATEGORY_ID = "SELECT product_id id, category_id, display_info_id, name, description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, file_id FROM "
			+ "(SELECT p.id id, category_id, name, description, content, event, create_date, modify_date FROM product p LEFT JOIN category c on c.id = p.category_id) p LEFT JOIN "
			+ "(SELECT d.id display_info_id, d.product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, file_id FROM display_info d LEFT JOIN product_image pimg on d.product_id = pimg.product_id where type = 'ma') d "
			+ "on p.id = d.product_id "
			+ "where category_id = :categoryId "
			+ "order by id "
			+ "limit :start, 4";
	
	final static String SELECT_DISPLAY = "SELECT product_id id, category_id, display_info_id, name, description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, file_id FROM "
			+ "(SELECT p.id id, category_id, name, description, content, event, create_date, modify_date FROM product p LEFT JOIN category c on c.id = p.category_id) p LEFT JOIN "
			+ "(SELECT d.id display_info_id, d.product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, file_id FROM display_info d LEFT JOIN product_image pimg on d.product_id = pimg.product_id where type = 'ma') d "
			+ "on p.id = d.product_id "
			+ "order by id "
			+ "limit :start, 4";
	
	final static String SELECT_DINPLAY_INFO_BY_DISPLAY_INFO_ID = "SELECT product_id id, category_id, display_info_id, name, description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, file_id FROM "
			+ "(SELECT p.id id, category_id, name, description, content, event, create_date, modify_date FROM product p LEFT JOIN category c on c.id = p.category_id) p LEFT JOIN "
			+ "(SELECT d.id display_info_id, d.product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, file_id FROM display_info d LEFT JOIN product_image pimg on d.product_id = pimg.product_id where type = 'ma') d "
			+ "on p.id = d.product_id where display_info_id = :display_info_id";
}
