package com.services;

import java.awt.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.Orderdao;
import com.dao.Productdao;
import com.pojo.Product;



@Service
public class Productservice {
//	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");  
//	Productdao pdao=(Productdao) ctx.getBean("product");
//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//	Productdao pdao=context.getBean(Productdao.class);
	@Autowired
	Productdao pdao;
public java.util.List<Product> retrive()
{  
	return pdao.retrive();
}
public void change(int id,int quantity)
{
	pdao.change(id, quantity);
}
public int change(int id)
{
	Product pd=pdao.quantity(id);
	return pd.getQuantity();
}
public int add(Product pd)
{
	return pdao.add(pd);
}
}
