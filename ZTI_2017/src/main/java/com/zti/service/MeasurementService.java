package com.zti.service;

import java.time.LocalDateTime;
import java.util.List;

import com.zti.model.Measurement;

public interface MeasurementService {
	public List<Measurement> findByCity(String city);

	public Measurement findById(Long id);

	public List<Measurement> findByDateOfMeasurement(LocalDateTime dateOfMeasurement);

	public List<Measurement> findAll();

	public void delete(Long id);

	public Measurement update(Measurement measurement);

	public Measurement save(Measurement measurement);
}
