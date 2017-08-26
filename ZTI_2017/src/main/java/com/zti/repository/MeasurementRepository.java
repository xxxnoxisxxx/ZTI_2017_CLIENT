package com.zti.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zti.model.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
	public List<Measurement> findByCity(String city);

	public Measurement findById(Long id);

	public List<Measurement> findByDateOfMeasurement(LocalDateTime dateOfMeasurement);

	public List<Measurement> findAll();
}