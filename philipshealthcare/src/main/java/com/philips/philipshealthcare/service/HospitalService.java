package com.philips.philipshealthcare.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.philips.philipshealthcare.model.Hospital;
import com.philips.philipshealthcare.repository.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	@Qualifier("hospitalRepository")
	HospitalRepository hospitalRepository;
	
	public Hospital save(Hospital hospitals) {
		return hospitalRepository.save(hospitals);
	}
 
	public List<Hospital> getAllHospitals()
	{
		List<Hospital>hospital=new ArrayList<>();
	    hospitalRepository.findAll().forEach(hospital::add);;
		return hospital;
	}
	
	public Hospital findById(long hid)
	{
		//hospitalRepository.findById(hid).map(q->q).orElseThrow(()->new RuntimeException("ID not found"));
		
		return hospitalRepository.getOne(hid);
	}
	
	public void delete(long hid)
	{
		 hospitalRepository.deleteById(hid);
	}
}
