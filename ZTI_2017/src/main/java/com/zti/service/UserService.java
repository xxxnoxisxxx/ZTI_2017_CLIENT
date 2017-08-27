package com.zti.service;

import java.util.List;

import com.zti.model.User;

/**
 * Interfejs serwisu dla klasy User
 * 
 * @author PawełN
 *
 */
public interface UserService {
	/**
	 * Zapisywanie obiektu klasy User
	 * 
	 * @param user
	 *            Obiekt klasy User
	 */
	public void save(User user);

	/**
	 * Znajdywanie obiektu klasy User po nazwie użytkownika
	 * 
	 * @param username
	 *            Nazwa użytkownika
	 * @return Zwraca obiekt klasy User
	 */
	public User findByUsername(String username);

	/**
	 * Znajdywanie obiektu klasy User po email
	 * 
	 * @param email
	 *            Email
	 * @return Zwraca obiekt klasy User
	 */
	public User findByEmail(String email);

	/**
	 * Znajdywanie obiketu klasy po identyfikatorze
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 * @return Zwraca obiekt klasy User
	 */
	public User findById(Long id);

	/**
	 * Usuwanie obiektu klasy User
	 * 
	 * @param id
	 *            Indetyfikator obiektu
	 */
	public void deleteById(Long id);

	/**
	 * Znajdywanie wszystkich obiektów klasy User
	 * 
	 * @return Liste obiektów klasy User
	 */
	public List<User> findAll();

	/**
	 * Sprawdzanie czy użytkownik jest zalogowany
	 * 
	 * @return Zwraca informacje na temat czy dany użytkownik jest zalogowany
	 *         czy nie
	 */
	public boolean isAuthenticated();
}
