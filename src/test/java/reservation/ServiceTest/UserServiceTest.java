package reservation.ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.UserDao;
import kr.or.connect.reservation.dao.UserRoleDao;
import kr.or.connect.reservation.dto.User;
import kr.or.connect.reservation.dto.UserRole;
import kr.or.connect.reservation.security.UserEntity;
import kr.or.connect.reservation.security.UserRoleEntity;
import kr.or.connect.reservation.service.impl.UserServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserDao userDao;
	@Mock
	UserRoleDao userRoleDao;
	
	@Test
	public void getUserEntityTest() {
		// given
		User user = new User();
		user.setId(1L);
		user.setEmail("test");
		user.setName("testName");
		user.setPassword("1234");
		given(userDao.getUserByEmail("test")).willReturn(user);
		
		// when
		UserEntity result = userServiceImpl.getUserEntity("test");
		
		// then
		verify(userDao).getUserByEmail(anyString());
		assertThat(result.getLoginUserId(), is("test"));
	}
	
	@Test
	public void getUserRoleEntitysTest() {
		// given
		UserRole userRole = new UserRole();
		userRole.setId(1L);
		userRole.setRoleName("testRole");
		userRole.setUserId(2L);
		
		List<UserRole> list = new ArrayList<>();
		list.add(userRole);
		
		given(userRoleDao.getUserRoleByEmail("test")).willReturn(list);
		
		// when
		List<UserRoleEntity> result = userServiceImpl.getUserRoleEntitys("test");
		
		// then
		verify(userRoleDao).getUserRoleByEmail(anyString());
		assertThat(result.size(), is(list.size()));
	}
}
