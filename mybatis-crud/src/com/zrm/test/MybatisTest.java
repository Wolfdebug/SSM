package com.zrm.test;

import java.util.List;


import org.junit.Test;

import com.zrm.dao.UserDao;
import com.zrm.pojo.User;

public class MybatisTest {
	UserDao userdao = new UserDao();
    @Test
	public  void testQuery () {
		List<User> list = UserDao.getAll();
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	@Test
	public void testInsert() {
		User user = new User();
		user.setName("datianshi");
		user.setPwd("8985947");
		int result = UserDao.addUser(user);
		System.out.println(result);
		
	}
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(5);
		user.setName("datianshi");
		user.setPwd("8985947");
		int result = UserDao.updateUser(user);
		System.out.println(result);
		
	}
	@Test
	public void testDelete() {
		int result = UserDao.deleteUser(5);
		System.out.println(result);
		
	}
	
}
