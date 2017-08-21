package com.zti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zti.model.User;
import com.zti.service.UserService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "users" }, method = RequestMethod.GET)
	public String admin(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/users";
	}

}
