package com.healthcare.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

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
import com.healthcare.model.Patient;
import com.healthcare.service.Patientservice;

@RestController
/*@RequestMapping("/philips")*/
@RequestMapping("/philips")
public class PatientController {

	@Autowired
	Patientservice patientService;

	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> allPatients = patientService.getAllPatients();
		if (allPatients == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allPatients);
	}

	/*@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long id) {
		Patient pat = patientService.findByPatientId(id);
		if (pat == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pat);

	}*/
	
	@GetMapping("/patients/{gender}")
	public ResponseEntity<List<Patient>> getPatientByGender(@QueryParam("gender") String gender)
	{
		List<Patient> patientsbygender=patientService.findByPatientGender(gender);
		if(patientsbygender == null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(patientsbygender);
		
	}
	
	@GetMapping("/hospitals/{id}/patients")
	public ResponseEntity<List<Patient>> getAllPatients(@PathVariable long id) {
		List<Patient> allPatients = patientService.getAllPatients(id);
		if (allPatients == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allPatients);
	}

	@GetMapping("/hospitals/{hospitalId}/patients/{id}/")
	public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") final Long id) {
		Patient pat = patientService.findByPatientId(id);
		if (pat == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pat);

	}
	
	@PostMapping("/hospitals/{hospitalid}/patients/")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient, @PathVariable Long id ) {
		Patient addPatient=new Patient();
		addPatient.setId(patient.getId());
		addPatient.setName(patient.getName());
		addPatient.setDateofbirth(patient.getDateofbirth());
		addPatient.setGender(patient.getGender());
		addPatient.setHospital(patient.getHospital());
	    addPatient.setExamination(patient.getExamination());
		//Hospital addHosp = hospitalservice.save(addHospital);
		Patient addPat = patientService.save(patient);
		return ResponseEntity.ok().body(addPat);

	}
	
	@PutMapping("/hospitals/{hospitalid}/patients/{id}/")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long hospitalidd, @PathVariable Long id,
			@Valid @RequestBody Patient patDetails) {
		Patient ps = patientService.findByPatientId(id);
		if (ps == null) {
			return ResponseEntity.notFound().build();
		}
		ps.setId(patDetails.getId());
		ps.setName(patDetails.getName());
		ps.setGender(patDetails.getGender());
		ps.setDateofbirth(patDetails.getDateofbirth());
		ps.setHospital(patDetails.getHospital());
		ps.setExamination(patDetails.getExamination());
		
		Patient updatePatient = patientService.save(patDetails);

		return ResponseEntity.ok().body(updatePatient);
	}
	
	@DeleteMapping("/hospitals/{hospitalid}/patients/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable(value = "id") Long id) {
		patientService.delete(id);
		
		return ResponseEntity.ok().build();

	}

}
