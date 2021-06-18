package kr.or.connect.reservation.dao;

public class ProductPriceDaoSqls {
	final static String SELECT_PRODUCT_PRICE_BY_PRODUCT_ID = 
			"SELECT id, product_id, price_type_name, price, discount_rate, create_date, modify_date "
			+ "FROM product_price where product_id = :productId ORDER BY id DESC";
	
	final static String PRICE_SUM_BY_RESERVATION_INFO_ID = 
			"SELECT SUM(price*count ) FROM product_price pp "
			+ "JOIN reservation_info_price rip ON pp.id = rip.product_price_id "
			+ "JOIN reservation_info ri ON rip.reservation_info_id = ri.id "
			+ "WHERE ri.id = :reservationInfoId";
}
