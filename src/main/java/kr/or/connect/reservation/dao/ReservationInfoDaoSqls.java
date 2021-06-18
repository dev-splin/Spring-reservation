package kr.or.connect.reservation.dao;

public class ReservationInfoDaoSqls {
	final static String SELECT_RESERVATION_INFO_BY_ID = 
			"SELECT id, product_id, cancel_flag, display_info_id, user_id, "
			+ "reservation_date, create_date, modify_date FROM reservation_info where id = :id";
	
	final static String UPDATE_CANCEL_FLAG_BY_RESERVATION_INFO_ID =
			"UPDATE reservation_info SET cancel_flag = 1 WHERE cancel_flag = 0 AND id = :id";
}
