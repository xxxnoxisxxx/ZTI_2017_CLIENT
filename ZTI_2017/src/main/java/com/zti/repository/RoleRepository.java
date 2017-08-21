package com.zti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zti.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}