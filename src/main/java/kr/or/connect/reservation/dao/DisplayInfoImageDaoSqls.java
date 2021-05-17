package kr.or.connect.reservation.dao;

public class DisplayInfoImageDaoSqls {
	final static String SELECT_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_ID = "SELECT d.id, d.display_info_id, d.file_id, f.file_name, f.save_file_name, f.content_type, f.delete_flag, f.create_date, f.modify_date "
			+ "FROM display_info_image d JOIN file_info f on d.file_id = f.id where d.display_info_id = :displayInfoId";
}
