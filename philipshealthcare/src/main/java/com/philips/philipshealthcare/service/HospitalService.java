package com.philips.philipshealthcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.philipshealthcare.model.Hospital;
import com.philips.philipshealthcare.repository.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	
	public Hospital addHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
 
	public List<Hospital> getAllHospitals()
	{
		List<Hospital>hospital=new ArrayList<>();
	    hospitalRepository.findAll().forEach(hospital::add);;
		return hospital;
	}
	
	public Optional<Hospital> getHospitalById(Long id) {
		return hospitalRepository.findById(id);
	}
	
	public void delete(long hid)
	{
		 hospitalRepository.deleteById(hid);
	}
	
	public Hospital updateHospital(Long hid, Hospital hospital) {
		hospital.setHid(hid);
		return hospitalRepository.save(hospital);
	}
}
