package com.zrm.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory factory = null;
	private static SqlSession session = null;
	private static String resource = null;
	public static SqlSessionFactory getFactory() {
		resource = "mybatis.cfg.xml";
		try {
			InputStream inputstream = Resources.getResourceAsStream(resource);
			factory =  new SqlSessionFactoryBuilder().build(inputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      		
		return factory;
		
	}
	public static SqlSession getSession() {
		if(factory!=null)
			return factory.openSession();
		return getFactory().openSession();
		
	}
	
	public static void closeAll() {
		if(session!=null)
			session.close();
		
	}
	

}
