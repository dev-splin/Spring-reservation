package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	final static String SELECT_PROMOTION = "SELECT pm.id, pm.product_id, pci.category_id, pci.category_name, pci.description, pci.file_id FROM"
			+ " promotion pm LEFT JOIN"
			+ " ("
			+ "SELECT pc.product_id, pc.category_id, pc.category_name, pc.description, pi.file_id FROM"
			+ " (SELECT p.id product_id, p.category_id, c.name category_name, p.description FROM"
			+ " product p LEFT JOIN category c on p.category_id = c.id) pc LEFT JOIN"
			+ " (SELECT p.id product_id, i.file_id FROM product p LEFT JOIN product_image i"
			+ " on p.id = i.product_id WHERE i.type = \"ma\") pi"
			+ " on pc.product_id = pi.product_id"
			+ ") pci"
			+ " on pm.product_id = pci.product_id";
}
