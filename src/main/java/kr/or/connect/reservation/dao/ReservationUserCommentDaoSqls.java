package kr.or.connect.reservation.dao;

public class ReservationUserCommentDaoSqls {
	final static String SELECT_SCORE_AVG_BY_PRODUCT_ID = "SELECT AVG(r.score) FROM reservation_user_comment r LEFT JOIN product p "
			+ "on p.id = r.product_id where p.id = :product_id;";
	final static String SELECT_RESERVATION_USER_COMMENT_BY_PRODUCT_ID = "SELECT c.id, c.product_id, c.reservation_info_id, c.user_id, c.score, u.email reservation_email, c.comment, c.create_date, c.modify_date "
			+ "FROM reservation_user_comment c LEFT JOIN user u on c.user_id = u.id where product_id = :product_id ORDER BY c.id DESC LIMIT :start, :limit";
	final static String SELECT_RESERVATION_USER_COMMENT_COUNT = "SELECT COUNT(c.id) FROM reservation_user_comment c LEFT JOIN user u "
			+ "on c.user_id = u.id where product_id = :product_id";
	
}
