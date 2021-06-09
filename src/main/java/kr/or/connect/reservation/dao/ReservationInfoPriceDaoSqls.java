package kr.or.connect.reservation.dao;

public class ReservationInfoPriceDaoSqls {
	final static String SELECT_RESERVATION_INFO_PRICE_BY__ID = 
			"SELECT id, reservation_info_id, product_price_id, count "
			+ "FROM reservation_info_price where id = :id";
}
