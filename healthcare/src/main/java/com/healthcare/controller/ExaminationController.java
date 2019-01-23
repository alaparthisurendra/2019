package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.model.Examination;
import com.healthcare.service.ExaminationSerivce;

@RestController
/*@RequestMapping("/philips")*/
@RequestMapping("/philips")
public class ExaminationController {
	
	@Autowired
	ExaminationSerivce examinationService;
	
	@GetMapping("/examinations")
	public ResponseEntity<List<Examination>> getAllExaminations(){
		List<Examination> allExaminations=examinationService.getAllExaminations();
		if(allExaminations==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allExaminations);
		
	}
	
	@GetMapping("/examinations/{id}")
	public ResponseEntity<Examination> getExaminationById(@PathVariable(value = "id") final Long id) {
		Examination exa=examinationService.findByExaminationId(id);
		if (exa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(exa);

	}
	

}
