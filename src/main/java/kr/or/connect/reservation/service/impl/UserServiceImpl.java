package kr.or.connect.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.UserDao;
import kr.or.connect.reservation.dao.UserRoleDao;
import kr.or.connect.reservation.dto.UserDTO;
import kr.or.connect.reservation.dto.UserRoleDTO;
import kr.or.connect.reservation.security.UserLoginInfoDTO;
import kr.or.connect.reservation.security.UserLoginRoleDTO;
import kr.or.connect.reservation.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	
	public UserServiceImpl(UserDao userDao, UserRoleDao userRoleDao) {
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
	}

	@Override
	@Transactional
	public UserDTO getUserDTO(String loginUserId) {
		return userDao.getUserByEmail(loginUserId);
	}

	@Override
	@Transactional
	public List<UserLoginRoleDTO> getUserRoleEntitys(String loginUserId) {
		List<UserRoleDTO> userRoles = userRoleDao.getUserRoleByEmail(loginUserId);
		List<UserLoginRoleDTO> userRoleEntitys = new ArrayList<>();
		
		for(UserRoleDTO userRole : userRoles)
			userRoleEntitys.add(new UserLoginRoleDTO(loginUserId, userRole.getRoleName()));
		
		return userRoleEntitys;
	}
}
