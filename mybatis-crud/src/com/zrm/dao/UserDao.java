package com.zrm.dao;

import java.util.ArrayList;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.zrm.pojo.User;
import com.zrm.util.MybatisUtil;


public class UserDao {

	//查询
	public static List<User> getAll(){
		
		SqlSession session = MybatisUtil.getSession();
		List<User> list = session.selectList("com.zrm.pojo.User.selectAll");
		MybatisUtil.closeAll();
		return list;
	}
	//增加
	public static int addUser(User user) {
		SqlSession session = MybatisUtil.getSession();
 		int result = session.insert("com.zrm.pojo.User.addUser", user);
 		session.commit();
 		MybatisUtil.closeAll();
 		return result;
	} 
	//修改
	public static int updateUser(User user) {
		SqlSession session = MybatisUtil.getSession();
 		int result = session.update("com.zrm.pojo.User.updateUser", user);
 		session.commit();
 		MybatisUtil.closeAll();
 		return result;
	} 
	//修改
	public static int deleteUser(Integer id) {
		SqlSession session = MybatisUtil.getSession();
 		int result = session.update("com.zrm.pojo.User.deleteUser", id);
 		session.commit();
 		MybatisUtil.closeAll();
 		return result;
	} 
}
