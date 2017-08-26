package com.zti.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zti.model.Measurement;
import com.zti.repository.MeasurementRepository;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	@Autowired
	private MeasurementRepository measurementRepository;

	@Override
	public List<Measurement> findAll() {
		List<Measurement> measurements = measurementRepository.findAll();
		return measurements;
	}

	@Override
	public Measurement findById(Long id) {
		return measurementRepository.findById(id);
	}

	@Override
	public List<Measurement> findByCity(String city) {
		List<Measurement> measurements = measurementRepository.findByCity(city);
		return measurements;
	}

	@Override
	public List<Measurement> findByDateOfMeasurement(LocalDateTime dateOfMeasurement) {
		List<Measurement> measurements = measurementRepository.findByDateOfMeasurement(dateOfMeasurement);
		return measurements;
	}

	@Override
	public void delete(Long id) {
		measurementRepository.delete(id);

	}

	@Override
	public Measurement update(Measurement measurement) {
		return measurementRepository.save(measurement);
	}

	@Override
	public Measurement save(Measurement measurement) {
		return measurementRepository.save(measurement);
	}

}