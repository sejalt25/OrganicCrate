package com.demo.springmvc.service;

import java.util.List;

import com.demo.springmvc.bean.Patient;
import com.demo.springmvc.bean.User;
import com.demo.springmvc.bean.Vendor;

public interface UserService {

	void save(User user);

	List<User> findAll();

	boolean addAdmin(User newAdmin);

	boolean addPatient(Patient newPatient);

	boolean addVendor(Vendor newVendor);

	boolean addUser(User newUser);

}
