package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.User;
import com.services.Userservice;

@Controller
public class Usercontroller {
@Autowired
Userservice userservice;

@RequestMapping("/login")
public ModelAndView checklogin(HttpServletRequest req,HttpServletResponse res)
	{
	
	String user=(String) req.getParameter("name");
	String password=(String) req.getParameter("password");
	ModelAndView mav =new ModelAndView();
	User user1=new User();
	user1.setUser(user);
	user1.setPass(password);
	int result=userservice.checklogin(user1);
	if(result==1)
	{
	req.getSession().setAttribute("user", user);
	mav.setViewName("redirect:/homepage");
	return mav;
	}
	else
	{
		mav.setViewName("redirect:/Login.jsp");
		return mav;
	}
}
@RequestMapping("/register")
public ModelAndView register()
{
	ModelAndView mav =new ModelAndView();
	mav.setViewName("register");
	User user=new User();
	mav.addObject("user", user);
	return mav;
}
@RequestMapping("/registerProcess")
public ModelAndView insert(@ModelAttribute("user") User user)
{
	ModelAndView mav =new ModelAndView();
	if(userservice.register(user)==1)
	{
		mav.setViewName("redirect:/Login.jsp");
		return mav;
	}
	else
	{
		mav.setViewName("register");
		return mav;
	}
	
}
@RequestMapping("/logout")
public ModelAndView logout(HttpServletRequest req)
{
	ModelAndView mav =new ModelAndView();
	req.getSession().setAttribute("user","" );
	mav.setViewName("redirect:/Login.jsp");
	return mav;
	
}

}
