package kr.or.connect.reservation.dao;

public class ReservationUserCommentImageDaoSqls {
	final static String SELECT_BY_RESERVATION_USER_ID = 
			"SELECT id, reservation_info_id, reservation_user_comment_id, file_id "
			+ "FROM reservation_user_comment_image "
			+ "WHERE reservation_user_comment_id = :reservationUserId";
}
