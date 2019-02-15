package com.philips.philipshealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philips.philipshealthcare.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
}
