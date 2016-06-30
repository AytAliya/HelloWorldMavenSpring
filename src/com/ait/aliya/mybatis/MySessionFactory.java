package com.ait.aliya.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySessionFactory {
	private static SqlSessionFactory factory;
	
	private MySessionFactory(){}
	
	static {
		String resource = "/com/ait/aliya/mybatis/xml/configuration.xml";
		InputStream inputStream = null;
		try{
			inputStream = Resources.getResourceAsStream(resource);
		} catch(IOException ex) {
			throw new RuntimeException(ex.getMessage());			
		}
		
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
}
