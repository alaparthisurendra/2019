package com.philips.philipshealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philips.philipshealthcare.model.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}
