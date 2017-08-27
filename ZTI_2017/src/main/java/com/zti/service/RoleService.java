package com.zti.service;

import java.util.List;

import com.zti.model.Role;

/**
 * Interfejs Serwisu dla klasy Role
 * 
 * @author PawełN
 *
 */
public interface RoleService {
	/**
	 * Znajdywanie obiektu klasy Role po indetyfikatorze
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 * @return Obiekt klasy Role
	 */
	public Role findById(Long id);

	/**
	 * Znadywanie wszystkich obiektów klasy Role
	 * 
	 * @return Lista obiektów klasy Role
	 */
	public List<Role> findAll();
}
