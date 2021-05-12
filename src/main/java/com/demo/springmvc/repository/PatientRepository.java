package com.demo.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.springmvc.bean.Patient;

@Repository
public interface PatientRepository  extends JpaRepository<Patient, Long> {

	Patient findByEmail(String userName);

	//Patient findByEmail(String userName);
}
