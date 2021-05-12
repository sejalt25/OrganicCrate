package com.demo.springmvc.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springmvc.bean.Disease;
import com.demo.springmvc.bean.Patient;
@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

	Optional<Disease> findByPatient(Patient patient);
	
}
