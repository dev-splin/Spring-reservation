package kr.or.connect.reservation.security;

import java.util.List;

public interface UserEntityService {
	UserLoginInfoDTO getUserEntity(String loginUserId);
    List<UserLoginRoleDTO> getUserRoleEntitys(String loginUserId);
}
