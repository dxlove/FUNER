package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.Resource;
import cn.cdu.fang.entity.User;

public class UserServiceTest {
	
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		userService = (UserService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("userService");
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setEmail("shouli@baidu.com");
		user.setGender(Gender.UNKNOWN);
		user.setName("小李");
		user.setPassword("123456");
		user.setRole(Role.USER);
		user.setCreateAt(new Date());
		user.setStatus(UserStatus.VALID);
		
		userService.save(user);
	}
	
	@Test
	public void testSaveWithImage() {
		User user = new User();
		user.setEmail("shoulai@baidu.com");
		user.setGender(Gender.UNKNOWN);
		user.setName("小李a");
		user.setPassword("123456");
		user.setRole(Role.USER);
		user.setCreateAt(new Date());
		user.setStatus(UserStatus.VALID);
		
		Resource avatar = new Resource();
		avatar.setResId("71247194719");
		avatar.setOrgSize(new Integer[]{1,2,32,4324});
		user.setAvatar(avatar);
		
		userService.save(user);
	}

	@Test
	public void testGetEntities() {
		for(User user : userService.getEntities()){
			System.out.println("email:"+user.getEmail());
			System.out.println("--"+user.getSpots().size());
		}
	}

	@Test
	public void testGetUserByEmail() {
		
		System.out.println("GetUserByEmail:"+userService.getUserByEmail("shouliaaa@baidu.com"));
		
	}

}