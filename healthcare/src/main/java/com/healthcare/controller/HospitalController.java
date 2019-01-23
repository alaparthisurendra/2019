package com.healthcare.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.model.Hospital;
import com.healthcare.service.Hospitalservice;

@RestController
@RequestMapping("/philips")
public class HospitalController {

	@Autowired
	Hospitalservice hospitalservice;

	/* get all hospitals */

	/*
	 * @RequestMapping(value="", method=RequestedMethod.Get)
	 * 
	 * @GetMapping("/hospitals") public List<Hospital> getAllHospitals() { return
	 * hospitalservice.getAllHospitals(); }
	 */

	@GetMapping("/hospitals")
	public ResponseEntity<List<Hospital>> getAllHospitals() {
		List<Hospital> allHospitals = hospitalservice.getAllHospitals();
		if (allHospitals == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allHospitals);

	}

	/* get hospital by id */
	@GetMapping("/hospitals/{id}")
	/* @GetMapping("/id/{id}") */
	public ResponseEntity<Hospital> getHospitalById(@PathVariable(value = "id") Long id) {
		Hospital hs = hospitalservice.findById(id);
		if (hs == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(hs);
	}

	@PutMapping("/hospitals/{id}")
	// @PutMapping("/update/{id}")
	public ResponseEntity<Hospital> updateHospital(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Hospital hospDetails) {
		Hospital hs = hospitalservice.findById(id);
		if (hs == null) {
			return ResponseEntity.notFound().build();
		}
		hs.setName(hospDetails.getName());
		hs.setId(hospDetails.getId());
		hs.setDescription(hospDetails.getDescription());
		hs.setPatient(hospDetails.getPatient());

		// save the value
		// Hospital updateHospital = hospitalservice.save(hs);
		Hospital updateHospital = hospitalservice.save(hospDetails);

		return ResponseEntity.ok().body(updateHospital);
	}

	// @PostMapping("/new")
	@PostMapping("/hospitals")
	public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital) {
		Hospital addHospital = new Hospital();
		addHospital.setId(hospital.getId());
		addHospital.setName(hospital.getName());
		addHospital.setDescription(hospital.getDescription());
		addHospital.setPatient(hospital.getPatient());
		// Hospital addHosp = hospitalservice.save(addHospital);
		Hospital addHosp = hospitalservice.save(hospital);
		return ResponseEntity.ok().body(addHosp);

	}

	@DeleteMapping("/hospitals/{id}")
	// @DeleteMapping("/delete/{id}")
	public ResponseEntity<Hospital> deleteHospital(@PathVariable(value = "id") Long id) {
		hospitalservice.delete(id);
		/*
		 * if (hs == null) { return ResponseEntity.notFound().build(); }
		 */
		return ResponseEntity.ok().build();

	}

}
