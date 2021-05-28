package kr.or.connect.reservation.dao;

public class UserDaoSqls {
	final static String SELECT_USER_BY_EMAIL = 
			"SELECT id, name, password, email, phone, create_date, modify_date "
			+ "FROM user WHERE email = :email";
}
