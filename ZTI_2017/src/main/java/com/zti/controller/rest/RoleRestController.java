package com.zti.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zti.model.Role;
import com.zti.service.RoleService;

@RestController
public class RoleRestController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/rest/roles")
	public List<Role> getRoles() {
		return roleService.findAll();
	}

	@GetMapping("/rest/role/{id}")
	public Role getRole(@PathVariable("id") Long id) {

		Role role = roleService.findById(id);
		return role;
	}

}