package com.zti.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zti.model.Role;
import com.zti.service.RoleService;

/**
 * RestController REST-API dla klasy Role
 * 
 * @author PawełN
 *
 */
@RestController
public class RoleRestController {

	/**
	 * Serwis ról
	 */
	@Autowired
	private RoleService roleService;

	/**
	 * Wyświetla wszystkie role w bazie
	 * 
	 * @return List wszystkich ról w bazie
	 */
	@GetMapping("/rest/roles")
	public List<Role> getRoles() {
		return roleService.findAll();
	}

	/**
	 * Wyświetla pojedynczą role
	 * 
	 * @param id
	 *            Indetyfikator roli
	 * @return Żądana rola
	 */
	@GetMapping("/rest/role/{id}")
	public Role getRole(@PathVariable("id") Long id) {

		return roleService.findById(id);
	}

}