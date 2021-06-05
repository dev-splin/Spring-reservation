package kr.or.connect.reservation.dao;

public class ReservationUserCommentDaoSqls {
	final static String SELECT_SCORE_AVG_BY_PRODUCT_ID = 
			"SELECT AVG(r.score) FROM reservation_user_comment r JOIN product p "
			+ "on p.id = r.product_id where p.id = :productId;";
	
	final static String SELECT_RESERVATION_USER_COMMENT_BY_PRODUCT_ID = 
			"SELECT c.id, c.product_id, c.reservation_info_id, c.user_id, c.score, " 
			+ "u.email reservation_email, c.comment, c.create_date, c.modify_date "
			+ "FROM reservation_user_comment c JOIN user u on c.user_id = u.id "
			+ "WHERE product_id = :productId ORDER BY c.id DESC LIMIT :start, :limit";
	
	final static String SELECT_RESERVATION_USER_COMMENT_COUNT = 
			"SELECT COUNT(c.id) FROM reservation_user_comment c JOIN user u "
			+ "on c.user_id = u.id where product_id = :productId";
	
}
