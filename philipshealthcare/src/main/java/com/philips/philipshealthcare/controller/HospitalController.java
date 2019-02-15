package com.philips.philipshealthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Hospital> getHospitalById(@PathVariable(value="hid") long hid)
	{
		Hospital findById = hospitalService.findById(hid);
		if(findById==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(findById);
		
	}
	@PostMapping("/hospitals")
	public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital)
	{
		Hospital save = hospitalService.save(hospital);
		return ResponseEntity.ok().body(save);
	}
}
