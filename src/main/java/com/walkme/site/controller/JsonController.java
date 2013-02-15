package com.walkme.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.walkme.core.model.entity.Task;
import com.walkme.core.model.entity.User;
import com.walkme.core.repository.TaskRepository;
import com.walkme.core.repository.UserRepository;
import com.walkme.core.service.TaskService;
import com.walkme.core.service.UserService;

@Controller
@RequestMapping("/json")
public class JsonController {

	@Autowired
	private TaskService taskService;
		
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public @ResponseBody List<Task> landing() {
		
		//User user = userService.getById(id);
		
		//
		//mav.addObject("testObj", "Great I am available in the view");
		//mav.addObject(user);
		List<Task> all = taskService.getAll();
		
		return all;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public @ResponseBody Long create(@RequestBody Task task) {			
		taskService.save(task);
		return task.getId();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public @ResponseBody String delete(@RequestBody Task task) {			
		taskService.delete(task.getId());
		return "\"deleted\"";
	}
	
}
