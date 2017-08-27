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

/**
 * Model Pomiar reprezentujący obiekt w bazie danych
 * 
 * @author PawełN
 *
 */
@Entity
@Table(name = "measurement")
public class Measurement {

	/**
	 * Identyfikator obiektu
	 */
	private Long id;
	/**
	 * Miasto
	 */
	private String city;
	/**
	 * Temperatura
	 */
	@Digits(integer = 3, fraction = 2)
	private BigDecimal temperature;
	/**
	 * Ilość opadów
	 */
	@Digits(integer = 3, fraction = 2)
	private BigDecimal totalPrecipitation;
	/**
	 * Prędkość wiatru
	 */
	@Digits(integer = 3, fraction = 2)
	private BigDecimal windSpeed;
	/**
	 * Data pomiaru
	 */
	private LocalDateTime dateOfMeasurement;

	/**
	 * @return Zwraca atrybut ID
	 */
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "measurement_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	public Long getId() {
		return id;
	}

	/**
	 * Ustawia atrybut ID
	 * 
	 * @param id
	 *            Idetyfikator obiektu
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Zwraca atrybut city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Ustawia atrybut city
	 * 
	 * @param city
	 *            Nazwa miasta
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return Zwraca atrybut temperature
	 */
	public BigDecimal getTemperature() {
		return temperature;
	}

	/**
	 * Ustawia atrybut temperature
	 * 
	 * @param temperature
	 *            Temperatura
	 */
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return Zwraca atrybut totalPrecipitation
	 */
	public BigDecimal getTotalPrecipitation() {
		return totalPrecipitation;
	}

	/**
	 * Ustawia atrybut totalPrecipitation
	 * 
	 * @param totalPrecipitation
	 *            Ilość opadów
	 */
	public void setTotalPrecipitation(BigDecimal totalPrecipitation) {
		this.totalPrecipitation = totalPrecipitation;
	}

	/**
	 * @return Zwraca atrybut windSpeed
	 */
	public BigDecimal getWindSpeed() {
		return windSpeed;
	}

	/**
	 * Ustawia atrybut windSpeed
	 * 
	 * @param windSpeed
	 *            Prędkość wiatru
	 */
	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}

	/**
	 * @return Zwraca atrybut dateOfMeasurement
	 */
	@Convert(converter = LocalDateTimeConverter.class)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getDateOfMeasurement() {
		return dateOfMeasurement;
	}

	/**
	 * Ustawia atrybut dateOfMeasurement
	 * 
	 * @param dateOfMeasurement
	 *            Data pomiaru
	 */
	public void setDateOfMeasurement(LocalDateTime dateOfMeasurement) {
		this.dateOfMeasurement = dateOfMeasurement;
	}

}
