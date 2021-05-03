package kr.or.connect.reservation.dao;

public class ReservationUserCommentDaoSqls {
	final static String SELECT_SCORE_AVG_BY_PRODUCT_ID = "SELECT AVG(r.score) FROM reservation_user_comment r LEFT JOIN product p "
			+ "on p.id = r.product_id where p.id = :product_id;";
}
