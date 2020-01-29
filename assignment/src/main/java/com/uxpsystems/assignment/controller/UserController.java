package com.uxpsystems.assignment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;	
	
	@RequestMapping("/")
	public String setupForm(Map<String, Object> map){
		User user = new User();
		map.put("user", user);
		map.put("userList", userService.getAllUser());
		return "user";
	}
	
	@RequestMapping(value="/user.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String, Object> map)
	{
		String message = "";
		try
		{	
			User userResult = new User();
			if(action.equalsIgnoreCase("add"))
			{
				User addUser = userService.getUser(user.getId());
				if(addUser != null)
				{
					message = "Same Id already exists";
				}
				else
				{					
					if(user.getStatus().equalsIgnoreCase("Activated") || user.getStatus().equals("Activated"))
					{
						userService.add(user);
						userResult = user;
					}
					else
					{
						message = "Status should be either of value ('Activated' or 'Deactivated')";
					}
				}
			}
			else if(action.equalsIgnoreCase("edit"))
			{				
				User editUser = userService.getUser(user.getId());
				if(editUser != null )
				{
					if(user.getStatus().equalsIgnoreCase("Activated") || user.getStatus().equals("Activated"))
					{
						userService.edit(user);
						userResult = user;
					}
					else
					{
						message = "Status should be either of value ('Activated' or 'Deactivated')";
					}
				}					
				else
				{
					message = "User not found to edit";
				}
			}
			else if(action.equalsIgnoreCase("delete"))
			{
				User deleteUser = userService.getUser(user.getId());
				if(deleteUser != null)
				{
					userService.delete(user.getId());
				}
				else
				{
					message = "User not found to delete";
				}
				userResult = new User();
			}
			else if(action.equalsIgnoreCase("search"))
			{				
				User searchedUser = userService.getUser(user.getId());
				if(searchedUser != null)
				{
					userResult = searchedUser;
				}
				else
				{
					message = "User not found";
					userResult = new User();
				}				
			}
			map.put("user", userResult);
			map.put("userList", userService.getAllUser());
			map.put("message", message);
		}
		catch(Exception e)
		{
			System.out.print(e);
			map.put("userList", userService.getAllUser());
		}
		return "user";
	}
}
