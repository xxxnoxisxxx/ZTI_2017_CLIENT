package com.zti.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zti.converter.LocalDateTimeConverter;

@Entity
@Table(name = "measurement")
public class Measurement {

	private Long id;
	private String city;
	@Digits(integer = 3, fraction = 2)
	private BigDecimal temperature;
	@Digits(integer = 3, fraction = 2)
	private BigDecimal totalPrecipitation;
	@Digits(integer = 3, fraction = 2)
	private BigDecimal windSpeed;
	private LocalDateTime dateOfMeasurement;

	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "measurement_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getTotalPrecipitation() {
		return totalPrecipitation;
	}

	public void setTotalPrecipitation(BigDecimal totalPrecipitation) {
		this.totalPrecipitation = totalPrecipitation;
	}

	public BigDecimal getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Convert(converter = LocalDateTimeConverter.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getDateOfMeasurement() {
		return dateOfMeasurement;
	}

	public void setDateOfMeasurement(LocalDateTime dateOfMeasurement) {
		this.dateOfMeasurement = dateOfMeasurement;
	}

}
