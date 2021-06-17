package kr.or.connect.reservation.ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import kr.or.connect.reservation.dao.UserDao;
import kr.or.connect.reservation.dao.UserRoleDao;
import kr.or.connect.reservation.dto.UserDTO;
import kr.or.connect.reservation.dto.UserRoleDTO;
import kr.or.connect.reservation.security.UserLoginInfoDTO;
import kr.or.connect.reservation.security.UserLoginRoleDTO;
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
		UserDTO user = new UserDTO();
		user.setId(1L);
		user.setEmail("test");
		user.setName("testName");
		user.setPassword("1234");
		given(userDao.getUserByEmail("test")).willReturn(user);
		
		// when
		UserDTO result = userServiceImpl.getUserDTO("test");
		
		// then
		verify(userDao).getUserByEmail(anyString());
		assertThat(result.getEmail(), is("test"));
	}
	
	@Test
	public void getUserRoleEntitysTest() {
		// given
		UserRoleDTO userRole = new UserRoleDTO();
		userRole.setId(1L);
		userRole.setRoleName("testRole");
		userRole.setUserId(2L);
		
		List<UserRoleDTO> list = new ArrayList<>();
		list.add(userRole);
		
		given(userRoleDao.getUserRoleByEmail("test")).willReturn(list);
		
		// when
		List<UserLoginRoleDTO> result = userServiceImpl.getUserRoleEntitys("test");
		
		// then
		verify(userRoleDao).getUserRoleByEmail(anyString());
		assertThat(result.size(), is(list.size()));
	}
}
