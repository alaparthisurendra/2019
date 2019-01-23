package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	
}
