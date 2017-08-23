package com.zti.service;

import java.util.List;

import com.zti.model.Role;

public interface RoleService {
	public Role findById(Long id);

	public List<Role> findAll();
}
