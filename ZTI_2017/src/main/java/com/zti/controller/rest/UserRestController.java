package com.zti.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zti.model.User;
import com.zti.service.UserService;

/**
 * RestController REST-API dla klasy User
 * 
 * @author PawełN
 *
 */
@RestController
public class UserRestController {

	/**
	 * Serwis użytkowników
	 */
	@Autowired
	private UserService userService;

	/**
	 * Wyświetla wszystkich użytkowników w bazie
	 * 
	 * @return Lista wszystkich użytkowników
	 */
	@GetMapping("/rest/users")
	public List<User> getUsers() {
		return userService.findAll();
	}

	/**
	 * Wyświetla pojedynczego użytkownika
	 * 
	 * @param id
	 *            Indetyfikator użytkownika
	 * @return
	 */
	@GetMapping("/rest/user/{id}")
	public User getUser(@PathVariable("id") Long id) {

		return userService.findById(id);

	}

}