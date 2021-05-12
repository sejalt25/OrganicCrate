package com.demo.springmvc.service;

import java.util.List;
import java.util.Optional;

import com.demo.springmvc.bean.Disease;
import com.demo.springmvc.bean.Patient;

public interface DiseaseService {
	List<Disease> findAll();

	Optional<Disease> findByPatient(Patient patient);


	
}
