package kr.or.connect.reservation.dao;

public class ProductPriceDaoSqls {
	final static String SELECT_PRODUCT_PRICE_BY_PRODUCT_ID = "SELECT id, product_id, price_type_name, price, discount_rate, create_date, modify_date "
			+ "FROM product_price where product_id = :product_id ORDER BY id DESC";
}
