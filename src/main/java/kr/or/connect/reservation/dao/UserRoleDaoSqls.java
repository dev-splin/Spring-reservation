package kr.or.connect.reservation.dao;

public class UserRoleDaoSqls {
	final static String SELECT_USERROLE_BY_EMAIL = 
			"SELECT ur.id, user_id, role_name FROM user_role ur JOIN user u "
			+ "ON ur.user_id = u.id WHERE u.email = :email";
}
