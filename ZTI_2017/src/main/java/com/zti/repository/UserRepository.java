package com.zti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zti.model.User;

/**
 * Repository Repozytorium dla klasy User
 * 
 * @author PawełN
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Znajdywanie obiektu klasy User po nazwie użytkownika
	 * 
	 * @param username
	 *            Nazwa użytkownika
	 * @return Obiekt klasy User
	 */
	User findByUsername(String username);

	/**
	 * Znajdywanie obiektu klasy User po email
	 * 
	 * @param email
	 *            Email
	 * @return Obiekt klasy User
	 */
	User findByEmail(String email);

	/**
	 * Znajdywanie obiektu klasy User po identyfikatorze
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 * @return Obekt klasy id
	 */
	User findById(Long id);

	/**
	 * Usuwanie obiektu klasy User
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 */
	@Transactional
	void deleteById(Long id);
}