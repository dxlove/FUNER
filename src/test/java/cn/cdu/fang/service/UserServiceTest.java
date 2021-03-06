package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.Resource;
import cn.cdu.fang.entity.Spot;
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
	
	@Test 
	public void testCount(){
		System.out.println(userService.count(UserStatus.VALID,Role.USER));
	}
	@Test
	public void testFindAll(){
		for(User user : userService.findAll(UserStatus.VALID,Role.USER,new PageRequest(0, 10)).getContent()){
			for(Spot spot : user.getSpots()){
				System.out.println(spot.getName());
			}
		}
	}
	
	@Test
	public void testLoginWithnameandpwd(){
//		assertNull(userService.findByEmailAndPassword("shouli1990@gmail.com", "aaaaaa"));
		
//		assertNotNull(userService.findByEmailAndPassword("shouli1990@gmail.com", "aaaaaa"));
	}

}