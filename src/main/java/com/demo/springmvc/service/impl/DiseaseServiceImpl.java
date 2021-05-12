package com.demo.springmvc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.bean.Disease;
import com.demo.springmvc.bean.Patient;
import com.demo.springmvc.repository.DiseaseRepository;
import com.demo.springmvc.service.DiseaseService;

@Service
public class DiseaseServiceImpl implements DiseaseService{
	@Autowired 
	private DiseaseRepository diseaseRepository;
	
	@Override
	public List<Disease> findAll() {
		return diseaseRepository.findAll();
	}

	@Override
	public Optional<Disease> findByPatient(Patient patient) {
		return diseaseRepository.findByPatient(patient);
	}

	

}

