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

@RestController
public class MeasurementRestController {

	@Autowired
	private MeasurementService measurementService;

	@GetMapping("/rest/measurements")
	public List<Measurement> getMeasurements() {
		return measurementService.findAll();
	}

	@GetMapping("/rest/measurement/{id}")
	public Measurement getMeasurement(@PathVariable("id") Long id) {

		Measurement measurement = measurementService.findById(id);
		return measurement;
	}

	@PostMapping(value = "/rest/measurements")
	public Measurement createMeasurement(@RequestBody Measurement measurement) {

		Measurement obj = measurementService.save(measurement);

		return obj;
	}

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