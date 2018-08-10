package com.visa.training.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	// we need a method which will handle get request with   /hello
	public ModelAndView handleHello() {
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("todaysDate", new Date());
		data.put("greeting","Welome to Spring Mvc");
		// this is similar to request.setAttribute();
		String viewName="helloview";
		return new ModelAndView(viewName,data);
		
		
	}
	// another sytle of writing it 
	// here in this spring itself will create an empty map and then call this method 
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String handleHello( Map<String,Object>data ) {
		//Map<String,Object> data = new HashMap<String,Object>();
		data.put("todaysDate", new Date());
		data.put("greeting","Welome to Spring Mvc");
		// this is similar to request.setAttribute();
		String viewName="helloview";
		return viewName;
		
		
	}

}
