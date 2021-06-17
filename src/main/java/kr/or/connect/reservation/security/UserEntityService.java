package kr.or.connect.reservation.security;

import java.util.List;

import kr.or.connect.reservation.dto.UserDTO;

public interface UserEntityService {
	UserDTO getUserDTO(String loginUserId);
    List<UserLoginRoleDTO> getUserRoleEntitys(String loginUserId);
}
