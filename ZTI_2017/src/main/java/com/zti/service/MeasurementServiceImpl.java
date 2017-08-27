package com.zti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zti.model.Measurement;
import com.zti.repository.MeasurementRepository;

/**
 * Implementacja serwisu dla klasy MeasurementService
 * 
 * @author PawełN
 *
 */
@Service
public class MeasurementServiceImpl implements MeasurementService {

	/**
	 * Repozytorium klasy Measurement
	 */
	@Autowired
	private MeasurementRepository measurementRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.MeasurementService#findAll()
	 */
	@Override
	public List<Measurement> findAll() {
		return measurementRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.MeasurementService#findById(java.lang.Long)
	 */
	@Override
	public Measurement findById(Long id) {
		return measurementRepository.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.MeasurementService#findByCity(java.lang.String)
	 */
	@Override
	public List<Measurement> findByCity(String city) {
		return measurementRepository.findByCity(city);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.MeasurementService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		measurementRepository.delete(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.MeasurementService#update(com.zti.model.Measurement)
	 */
	@Override
	public Measurement update(Measurement measurement) {
		return measurementRepository.save(measurement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.MeasurementService#save(com.zti.model.Measurement)
	 */
	@Override
	public Measurement save(Measurement measurement) {
		return measurementRepository.save(measurement);
	}

}