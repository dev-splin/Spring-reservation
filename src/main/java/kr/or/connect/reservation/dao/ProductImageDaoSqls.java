package kr.or.connect.reservation.dao;

public class ProductImageDaoSqls {
	final static String SELECT_PRODUCT_IMAGE_BY_PRODUCT_ID = "SELECT p.product_id, p.id product_image_id, p.type, p.file_id file_info_id, f.file_name, f.save_file_name, f.content_type, f.delete_flag, f.create_date, f.modify_date\r\n"
			+ " FROM product_image p JOIN file_info f on p.file_id = f.id where p.type = :type AND p.product_id = :product_id";
}
