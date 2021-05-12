package com.demo.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.demo.springmvc.bean.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
	
	@Query("select v from Vendor v where v.email = ?1")
    Vendor findVendorByEmail(String email);
	
}
