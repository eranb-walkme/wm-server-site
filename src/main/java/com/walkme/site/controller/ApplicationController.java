package com.walkme.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walkme.core.model.entity.User;
import com.walkme.core.repository.UserRepository;
import com.walkme.core.service.TaskService;
import com.walkme.core.service.UserService;

@Controller
@RequestMapping("/")
public class ApplicationController {

	@Autowired
	private TaskService taskService;
		
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView landing(ModelAndView mav) {
		
		//User user = userService.getById(id);
		
		//
		//mav.addObject("testObj", "Great I am available in the view");
		//mav.addObject(user);
		
		mav.setViewName("index");
		return mav;
	}
	
}
