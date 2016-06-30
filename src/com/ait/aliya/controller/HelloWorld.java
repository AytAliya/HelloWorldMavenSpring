package com.ait.aliya.controller;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ait.aliya.mybatis.model.Greeting;
import com.ait.aliya.mybatis.MySessionFactory;

@Controller
public class HelloWorld {
	
	@RequestMapping("/greeting")
	public ModelAndView hello(){
		SqlSessionFactory factory = MySessionFactory.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		Greeting greeting = session.selectOne("selectFirstGreeting");
		if (greeting == null) {
			greeting = new Greeting();
			greeting.setGreetingText("HELLO WORLD!!!");
			
			session.insert("insertGreeting", greeting);
			session.commit();
		}
		
		return new ModelAndView("greeting", "message", greeting.getGreetingText());
	}
}
