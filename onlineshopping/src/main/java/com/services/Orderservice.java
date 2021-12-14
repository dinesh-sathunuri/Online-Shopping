package com.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.Orderdao;
import com.pojo.Order;
import com.pojo.Product;

@Service
public class Orderservice {
//	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");  
//	Orderdao odao=(Orderdao) ctx.getBean("order");
//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//	Orderdao odao=context.getBean(Orderdao.class);
	@Autowired
	Orderdao odao;
	public int insert(List<Order>order) throws ClassNotFoundException 
	{
		int c=1;
		System.out.print("in service");
		for(Order o:order)
		{
			
			if(odao.insertintoorederdetails(o)!=1)
				c=0;
		}
		return c;
	}
	public List<Order> retrive(String user)
	{
		List<Order>order=odao.retrive(user);
		return order;
		
	}
	public int change(int id,int status)
	{
		return odao.updatestatus(id, status);
		
	}
	public int quantity(int id)
	{
		Order or=odao.quantity(id);
		
		return or.getQuatity();
	}
	public int productid(int id)
	{
		Order or=odao.productid(id);
		
		return or.getProductid();
	}
}
