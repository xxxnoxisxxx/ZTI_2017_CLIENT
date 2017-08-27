package com.zti.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zti.model.Measurement;

/**
 * Repository Repozytorium dla klasy Measurement
 * 
 * @author PawełN
 *
 */
public interface MeasurementRepository extends PagingAndSortingRepository<Measurement, Long> {
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

	/**
	 * Znajdywanie wszystkich obiektów klasy Measurement w posortowanej
	 * kolejności według daty
	 * 
	 * @return Lista posortowanych obiektów klasy Measurement
	 */
	public List<Measurement> findAllByOrderByDateOfMeasurementAsc();
}