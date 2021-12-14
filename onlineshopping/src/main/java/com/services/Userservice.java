package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.Orderdao;
import com.dao.Userdao;
import com.pojo.User;



@Service
public class Userservice {
	
//	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");  
//	Userdao userdao = (Userdao) ctx.getBean("user");
//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//	Userdao userdao=context.getBean(Userdao.class);
	@Autowired
	Userdao userdao;
	public int checklogin(User user)
	{
		return userdao.validateUser(user);
	}
	public int register(User user)
	{
		if(userdao.validate(user)==0)
		return userdao.register(user);	
		else
			return 0;
		
	}
}
