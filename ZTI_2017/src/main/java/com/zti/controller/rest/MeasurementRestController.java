package com.zti.controller.rest;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zti.model.Measurement;
import com.zti.service.MeasurementService;

/**
 * RestController REST-API dla klasy Measurement
 * 
 * @author PawełN
 *
 */
@RestController
public class MeasurementRestController {

	/**
	 * Serwis pomiarów
	 */
	@Autowired
	private MeasurementService measurementService;

	/**
	 * Wyświetla listę wszystkich pomiarów w bazie
	 * 
	 * @return Lista wszystkich pomiarów w bazie
	 */
	@GetMapping("/rest/measurements")
	public List<Measurement> getMeasurements() {
		return measurementService.findAll();
	}

	/**
	 * Wyświetla pojedynczy pomiar
	 * 
	 * @param id
	 *            Indetyfikator pomiaru
	 * @return Żądany pomiary
	 */
	@GetMapping("/rest/measurement/{id}")
	public Measurement getMeasurement(@PathVariable("id") Long id) {

		return measurementService.findById(id);
	}

	/**
	 * Dodawnie pomiaru do bazy
	 * 
	 * @param measurement
	 *            Model dodawanego obiektu
	 * @return Dodany obiekt
	 */
	@PostMapping(value = "/rest/measurements")
	public Measurement createMeasurement(@RequestBody Measurement measurement) {

		return measurementService.save(measurement);
	}

	/**
	 * Usuwanie obiektu z bazy
	 * 
	 * @param id
	 *            Indetyfikator obiektu
	 * @return Komunikat o sukcesie lub błędzie
	 */
	@DeleteMapping("/rest/measurement/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {

		JSONObject result = new JSONObject();
		if (null == measurementService.findById(id)) {

			result.put("message", "No measurement found for ID " + id);
			result.put("status", "Not found");
			return new ResponseEntity<String>(result.toString(), HttpStatus.NOT_FOUND);
		}

		measurementService.delete(id);
		result.put("id", id);
		result.put("status", "Deleted");

		return new ResponseEntity<String>(result.toString(), HttpStatus.OK);

	}

	/**
	 * Aktualizowanie obiektu
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 * @param measurement
	 *            Model edytowane obiektu
	 * @return Komunikat o błędzie lub edytowany model
	 */
	@PutMapping("/rest/measurement/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Measurement measurement) {

		Measurement newMeasurement = measurementService.findById(id);
		if (newMeasurement == null) {
			JSONObject result = new JSONObject();
			result.put("message", "No measurement found for ID " + id);
			result.put("status", "Not found");
			return new ResponseEntity<String>(result.toString(), HttpStatus.NOT_FOUND);
		}

		Measurement obj = measurementService.update(measurement);

		return new ResponseEntity<Measurement>(obj, HttpStatus.OK);
	}

}