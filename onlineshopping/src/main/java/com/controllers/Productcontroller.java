package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Product;
import com.services.Productservice;

@Controller
public class Productcontroller {
	@Autowired
	Productservice ps;
	@RequestMapping("/homepage")
	public ModelAndView home(HttpServletRequest req)
	{
		ModelAndView mav=new ModelAndView();
		List<Product> product=ps.retrive();
		mav.addObject("product",product);
//		String user=(String) req.getSession().getAttribute("user");
//		if(user.substring(0,5).equals("admin"))
//		mav.setViewName("home1");
//		else
			mav.setViewName("home");
		return mav;	
	}
	@RequestMapping("/checkoutpage")
	public ModelAndView checkout(HttpServletRequest req)
	{
		ModelAndView mav=new ModelAndView();
		Cookie[] s=req.getCookies();
		Product pd =new Product();
		List<Product> product=ps.retrive();
		List<Product> checkoutproduct=new ArrayList<Product>();
		int i,j;
		for(Cookie c:s)
		{
			if(c.getValue().equals("1"))
			{
				i=Integer.parseInt(c.getName());
				j=0;
				while(j<20)
				{
					if(product.get(j)!=null)
					{
						if(product.get(j).getId()==i)
							break;
					}
					j++;
				}
						
					pd=product.get(j);
				checkoutproduct.add(pd);
			}
		}
		mav.addObject("product",checkoutproduct);
		mav.setViewName("checkout");
		return mav;
	}
	@RequestMapping("addProducts")
	public ModelAndView newProduct(HttpServletRequest req) {
		 String name=req.getParameter("name");
		 int amount=Integer.parseInt(req.getParameter("price"));
		 String link=req.getParameter("photo");
		 int quantity=Integer.parseInt(req.getParameter("quantity"));
		 Product pd=new Product();
		 pd.setAmount(amount);
		 pd.setQuantity(quantity);
		 pd.setLink(link);
		 pd.setName(name);
		 ps.add(pd);
		 ModelAndView mav=new ModelAndView();
		 mav.setViewName("redirect:/homepage");
		return mav;
	}
	@RequestMapping(value="/editproduct/{id}",method=RequestMethod.GET)
	public ModelAndView editproduct(HttpServletRequest req,@PathVariable int id)
	{
		String s=req.getParameter("quantity"+id);
		System.out.print(s);
		ModelAndView mav=new ModelAndView();
		Product pd=new Product(); 
		pd.setId(id);
		mav.addObject("pd",pd);
		mav.setViewName("Edit");
		return mav;
	}
	@RequestMapping("/editform")
	public ModelAndView edit(@ModelAttribute("pd")Product pd)
	{
		ModelAndView mav=new ModelAndView();
		ps.change(pd.getId(), pd.getQuantity());
		mav.setViewName("redirect:/homepage");
		return mav;
	}
	
}
