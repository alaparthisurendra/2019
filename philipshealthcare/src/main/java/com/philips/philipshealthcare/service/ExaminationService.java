package com.philips.philipshealthcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.philipshealthcare.model.Examination;
import com.philips.philipshealthcare.repository.ExaminationRepository;

@Service
public class ExaminationService {
	
	@Autowired
	ExaminationRepository examinationRepository;
	
	public Examination save(Examination examinations)
	{
		return examinationRepository.save(examinations);
		
	}
	public List<Examination> getAllExaminations()
	{
		List<Examination>examinations=new ArrayList<>();
		examinationRepository.findAll().forEach(examinations::add);
		return examinations;
		
	}
    
	public Examination findById(long eid)
	{
		return examinationRepository.getOne(eid);
	}
	
	public void delete(long eid)
	{
		examinationRepository.deleteById(eid);
	}
}
