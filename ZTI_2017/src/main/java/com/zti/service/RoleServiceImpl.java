package com.zti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zti.model.Role;
import com.zti.repository.RoleRepository;

/**
 * Implementacja serwisu dla klasy RoleService
 * 
 * @author PawełN
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	/**
	 * Repozytorium klasy Role
	 */
	@Autowired
	private RoleRepository roleRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.RoleService#findAll()
	 */
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.RoleService#findById(java.lang.Long)
	 */
	@Override
	public Role findById(Long id) {
		return roleRepository.findById(id);
	}

}