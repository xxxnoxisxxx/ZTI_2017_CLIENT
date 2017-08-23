package com.zti.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zti.model.User;
import com.zti.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/rest/users")
	public List<User> getUsers() {
		return userService.findAll();
	}

	@GetMapping("/rest/user/{id}")
	public User getUser(@PathVariable("id") Long id) {

		User user = userService.findById(id);
		return user;
	}

}