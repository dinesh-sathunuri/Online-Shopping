package com.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Order;
import com.pojo.Product;
import com.services.Orderservice;
import com.services.Productservice;

@Controller
public class Ordercontroller {
	@Autowired
	Orderservice os;
	@Autowired
	Productservice ps;
	@RequestMapping("intoorderdao")
	public ModelAndView insert(HttpServletRequest req) throws ClassNotFoundException
	{
		 ModelAndView mav=new  ModelAndView();
		 Cookie[] s=req.getCookies();
			List<Order>order=new ArrayList<Order>();
			List<Product> product=ps.retrive();
			int i,j;
			int quantity,totalQuantity = 0;
			for(Cookie c:s)
			{
				if(c.getValue().equals("1"))
				{
					i=Integer.parseInt(c.getName());
					j=0;
					while(j<product.size())
					{
						if(product.get(j)!=null)
						{
							if(product.get(j).getId()==i)
							{
								Product pd=product.get(j);
								
								Order oh=new Order();
								quantity=Integer.parseInt(req.getParameter("quantity"+i));
								
								Date date=new Date();
								oh.setDatecreated(date.toString());
								totalQuantity=pd.getQuantity();
								totalQuantity-=quantity;
								ps.change(pd.getId(), totalQuantity);
								oh.setProductid(pd.getId());
									oh.setAmount(quantity*pd.getAmount());
									oh.setStatus(0);
									oh.setQuatity(quantity);
									
									oh.setUsername((String)req.getSession().getAttribute("user"));
									order.add(oh);
									
							}
						}
						j++;
					}
				}
			}
		
		 if(os.insert(order)==1)
		 {
			 mav.setViewName("redirect:/historypage");
			 return mav;
		 }
		 else
		 {
			 mav.setViewName("checkoutpage");
			 return mav;
		 }
	}
	@RequestMapping("historypage")
	public ModelAndView retrive(HttpServletRequest req)
	{
		String user=(String) req.getSession().getAttribute("user");
		 ModelAndView mav=new  ModelAndView();
		 List<Order> order=os.retrive(user);
		 mav.addObject("order", order);
//			if(user.substring(0,5).equals("admin"))
//			mav.setViewName("history1");
//			else
				mav.setViewName("history");
		return mav;
	}
	@RequestMapping(value="/approve/{id}",method = RequestMethod.GET)
	public ModelAndView approveStatus(@PathVariable int id)
	{
		int Status=1;
		ModelAndView mav=new  ModelAndView();
		if(os.change(id, Status)==1)
			mav.setViewName("redirect:/historypage");
		return mav;
	}
	@RequestMapping(value="/reject/{id}",method = RequestMethod.GET)
	public ModelAndView rejectStatus(@PathVariable int id)
	{
		int Status=2;
		ModelAndView mav=new  ModelAndView();
		int productid=os.productid(id);
		int totalquantity=ps.change(productid);
		System.out.print("totalquantity"+totalquantity);
		int quantity=os.quantity(id);
		System.out.print("quantity"+quantity);
		ps.change(productid, totalquantity+quantity);
		if(os.change(id, Status)==1)
			mav.setViewName("redirect:/historypage");
		return mav;
	}

}
