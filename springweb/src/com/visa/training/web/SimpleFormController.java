package com.visa.training.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleFormController {
	@RequestMapping(value="/simpleform", method=RequestMethod.POST)
	public String handleFormSubmitssion(HttpServletRequest request) {
		// the request here cab be anything a request,response,session,collection,maps etc !! 
		// when
		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		String message ;
		//public String handleFormSubmitssion(@RequestParam("user")String username, @RequestParam("password")String password ) {
		//}
		if(userName.equalsIgnoreCase(password)) {
			message = "loginsuccess" ;
		}
		else
			message = "loginfailed" ;
		return message;
		
	}
}
