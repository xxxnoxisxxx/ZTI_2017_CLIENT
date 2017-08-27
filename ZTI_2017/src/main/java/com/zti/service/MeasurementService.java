package com.zti.service;

import java.util.List;

import com.zti.model.Measurement;

/**
 * Interfejs Serwisu dla klasy Measurement
 * 
 * @author PawełN
 *
 */
public interface MeasurementService {
	/**
	 * Znajdywanie obiektów klasy Measurement po nazwie miasta
	 * 
	 * @param city
	 *            Nazwa miasta
	 * @return Lista obiektów klasy Measurement
	 */
	public List<Measurement> findByCity(String city);

	/**
	 * Znajdywanie obiektu po indetyfikatorze
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 * @return Obiekt klasy Measurement
	 */
	public Measurement findById(Long id);

	/**
	 * Znajdywanie wszystkich obiektów klasy Measurement
	 * 
	 * @return Lista obiektów klasy Measurement
	 */
	public List<Measurement> findAll();

	/**
	 * Usuwanie obiektu z bazy danych
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 */
	public void delete(Long id);

	/**
	 * Aktualizowanie obiektu w bazie danych
	 * 
	 * @param measurement
	 *            Obiekt
	 * @return Zwraca zaktualizowany obiekt
	 */
	public Measurement update(Measurement measurement);

	/**
	 * Tworzenie obiektu w bazie danych
	 * 
	 * @param measurement
	 *            Obiekt do utworzenia
	 * @return Zwraca utworzony obiekt
	 */
	public Measurement save(Measurement measurement);

	/**
	 * Zwraca liste wszystkich pomiarów posortowanych po dacie pomiaru
	 * 
	 * @return Lista wszystkich posortowanych obiektów klasy Measurement
	 */
	public List<Measurement> findAllByOrderByDateOfMeasurement();
}
