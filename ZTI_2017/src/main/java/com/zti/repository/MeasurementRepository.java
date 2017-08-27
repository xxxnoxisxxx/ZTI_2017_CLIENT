package com.zti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zti.model.Measurement;

/**
 * Repository Repozytorium dla klasy Measurement
 * 
 * @author PawełN
 *
 */
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
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
	 *            Indetyfikator obiektu
	 * @return Obiekt klasy Measurement
	 */
	public Measurement findById(Long id);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	public List<Measurement> findAll();
}