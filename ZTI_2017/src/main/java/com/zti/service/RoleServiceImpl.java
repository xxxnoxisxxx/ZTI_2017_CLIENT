package com.zti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zti.model.Role;
import com.zti.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		List<Role> roles = roleRepository.findAll();
		return roles;
	}

	@Override
	public Role findById(Long id) {
		return roleRepository.findById(id);
	}

}