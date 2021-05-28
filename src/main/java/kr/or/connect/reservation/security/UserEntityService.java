package kr.or.connect.reservation.security;

import java.util.List;

public interface UserEntityService {
	UserEntity getUserEntity(String loginUserId);
    List<UserRoleEntity> getUserRoleEntitys(String loginUserId);
}
