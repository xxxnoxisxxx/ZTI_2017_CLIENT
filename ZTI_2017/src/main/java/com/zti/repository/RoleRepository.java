package com.zti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zti.model.Role;

/**
 * Repository Repozytorium dla klasy Role
 * 
 * @author PawełN
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	/**
	 * Znajdywanie obiektu klasy Role po nazwie
	 * 
	 * @param name
	 *            Nazwa roli
	 * @return Obiekt klasy Role
	 */
	Role findByName(String name);

	/**
	 * Znajdywanie obiektu klasy Role po id
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 * @return Obiekt klasy Role
	 */
	Role findById(Long id);
}