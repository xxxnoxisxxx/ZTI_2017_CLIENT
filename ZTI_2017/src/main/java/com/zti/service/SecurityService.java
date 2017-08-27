package com.zti.service;

/**
 * Interfejs serwisu dla klasy SecurityService
 * 
 * @author PawełN
 *
 */
public interface SecurityService {
	/**
	 * Znajdywanie nazwy zalogowanego użytkownika
	 * 
	 * @return Nazwa zalogowanego użytkownika
	 */
	public String findLoggedInUsername();

	/**
	 * Logowanie użytkownika
	 * 
	 * @param username
	 *            Nazwa użytkownika
	 * @param password
	 *            Hasło
	 */
	public void autologin(String username, String password);
}
