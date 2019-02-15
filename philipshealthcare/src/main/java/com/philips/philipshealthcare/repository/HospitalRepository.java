package com.philips.philipshealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philips.philipshealthcare.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
