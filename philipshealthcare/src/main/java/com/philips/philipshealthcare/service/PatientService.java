package com.philips.philipshealthcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.philipshealthcare.model.Patient;
import com.philips.philipshealthcare.repository.PatientRepository;

@Service
public class PatientService {
   
	@Autowired
	PatientRepository patientRepository;
	
	public Patient save(Patient patients)
	{
		return patientRepository.save(patients);
		
	}
	
	public List<Patient> getAllPatients()
	{
		List<Patient> patients=new ArrayList<>();
		patientRepository.findAll().forEach(patients::add);
		
		/*patients.stream().filter(p->p.getPid()>5000);
		
		Collections.sort(patients,(a,b)->{
			return a.getName().compareTo(b.getName());
		});*/
		
		return patients;
		
	}

	public Patient findById(long pid) {
		return patientRepository.getOne(pid);
		
	}
	
	public void Delete(Long pid)
	{
		patientRepository.deleteById(pid);
	}
	
}
