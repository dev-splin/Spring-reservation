package kr.or.connect.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.UserDao;
import kr.or.connect.reservation.dao.UserRoleDao;
import kr.or.connect.reservation.dto.User;
import kr.or.connect.reservation.dto.UserRole;
import kr.or.connect.reservation.security.UserEntity;
import kr.or.connect.reservation.security.UserRoleEntity;
import kr.or.connect.reservation.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	UserRoleDao userRoleDao;

	@Override
	@Transactional
	public UserEntity getUserEntity(String loginUserId) {
		User user = userDao.getUserByEmail(loginUserId);
		return new UserEntity(user.getEmail(), user.getPassword());
	}

	@Override
	@Transactional
	public List<UserRoleEntity> getUserRoleEntitys(String loginUserId) {
		List<UserRole> userRoles = userRoleDao.getUserRoleByEmail(loginUserId);
		List<UserRoleEntity> userRoleEntitys = new ArrayList<>();
		
		for(UserRole userRole : userRoles)
			userRoleEntitys.add(new UserRoleEntity(loginUserId, userRole.getRoleName()));
		
		return userRoleEntitys;
	}
}
