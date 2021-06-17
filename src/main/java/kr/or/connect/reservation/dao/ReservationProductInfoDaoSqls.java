package kr.or.connect.reservation.dao;

public class ReservationProductInfoDaoSqls {
	static final String SELECT_RESERVATION_PRODUCT_INFO_BY_USER_ID = 
			"SELECT ri.id, product_id, display_info_id, cancel_flag, p.description product_description, "
			+ "p.content product_content, user_id, reservation_date, ri.create_date, ri.modify_date "
			+ "FROM reservation_info ri JOIN product p ON ri.product_id = p.id WHERE user_id = :userId";
}
