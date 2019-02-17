package com.philips.philipshealthcare.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.PathParam;

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

import com.philips.philipshealthcare.model.Hospital;
import com.philips.philipshealthcare.service.HospitalService;

@RestController
@RequestMapping("/philips")
public class HospitalController {

	@Autowired
	HospitalService hospitalService;
	
	@GetMapping("/hospitals")
	public ResponseEntity<List<Hospital>> getAllHospitals()
	{
		List<Hospital>allHospitals=hospitalService.getAllHospitals();
		if(allHospitals==null){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(allHospitals);
		
	}
	@GetMapping("/hospitals/{hid}")
	public ResponseEntity<Optional<Hospital>> getHospitalById(@PathVariable(value="hid") long hid)
	{
		Optional<Hospital> hospitals = hospitalService.getHospitalById(hid);
		if(hospitals==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(hospitals);
		
	}
	@PostMapping("/hospitals")
	public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital)
	{
		Hospital save = hospitalService.addHospital(hospital);
		return ResponseEntity.ok().body(save);
	}
	
	@PutMapping("/hospitals/{hid}")
	public ResponseEntity<Hospital> updateHospital(@PathParam(value="hid") Long hid, Hospital hospital){
		Hospital updateHospital = hospitalService.updateHospital(hid, hospital);
		return  ResponseEntity.ok().body(updateHospital); 
	}
	@DeleteMapping("/hospitals/{hid}")
	public void DeleteHospital(@PathParam(value="hid") Long hid){
		hospitalService.delete(hid);
	}
	
}
