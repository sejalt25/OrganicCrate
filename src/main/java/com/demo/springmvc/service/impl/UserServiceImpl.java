package com.demo.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.springmvc.bean.Patient;
import com.demo.springmvc.bean.Role;
import com.demo.springmvc.bean.RoleName;
import com.demo.springmvc.bean.User;
import com.demo.springmvc.bean.Vendor;
import com.demo.springmvc.repository.PatientRepository;
import com.demo.springmvc.repository.RoleRepository;
import com.demo.springmvc.repository.UserRepository;
import com.demo.springmvc.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEndcoder;

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public boolean addAdmin(User newAdmin) {
		newAdmin.setPassword(passwordEndcoder.encode(newAdmin.getPassword()));
		newAdmin.setEnabled(true);
		List<Role> roles=new ArrayList<>();
		Optional<Role> optRole =roleRepository.findByRoleName(RoleName.ADMIN);
		if(optRole.isEmpty())
		{
			Role role =roleRepository.save(new Role(RoleName.ADMIN));
			roleRepository.save(new Role(RoleName.USER));
			roleRepository.save(new Role(RoleName.VENDOR));
			roleRepository.save(new Role(RoleName.PATIENT));
			roles.add(role);

		}else {
			roles.add(optRole.get());
		}
		newAdmin.setRoles(roles);
		User newUser = userRepository.save(newAdmin);
		return newUser != null;
	}

	/*
	 * @Override public boolean addPatient(Patient newPatient) {
	 * newPatient.setPassword(passwordEndcoder.encode(newPatient.getPassword()));
	 * newPatient.setEnabled(true); List<Role> roles=new ArrayList<>();
	 * Optional<Role> optRole =roleRepository.findByRoleName(RoleName.PATIENT);
	 * roles.add(optRole.get()); newPatient.setRoles(roles); User newUser =
	 * userRepository.save(newPatient); return newUser != null; }
	 */
	
	@Override
	public boolean addPatient(Patient newPatient) {
		newPatient.setPassword(passwordEndcoder.encode(newPatient.getPassword()));
		newPatient.setEnabled(true);
		List<Role> roles=new ArrayList<>();
		Optional<Role> optRole =roleRepository.findByRoleName(RoleName.PATIENT);
		roles.add(optRole.get());
		newPatient.setRoles(roles);
		newPatient = patientRepository.save(newPatient);
		return newPatient != null;
	}


	@Override
	public boolean addVendor(Vendor newVendor) {
		newVendor.setPassword(passwordEndcoder.encode(newVendor.getPassword()));
		newVendor.setEnabled(true);
		List<Role> roles=new ArrayList<>();
		Optional<Role> optRole =roleRepository.findByRoleName(RoleName.VENDOR);
		roles.add(optRole.get());
		newVendor.setRoles(roles);
		User newUser = userRepository.save(newVendor);
		return newUser != null;
	}

	@Override
	public boolean addUser(User newUser) {
		newUser.setPassword(passwordEndcoder.encode(newUser.getPassword()));
		newUser.setEnabled(true);
		List<Role> roles=new ArrayList<>();
		Optional<Role> optRole =roleRepository.findByRoleName(RoleName.USER);
		roles.add(optRole.get());
		newUser.setRoles(roles);
		newUser = userRepository.save(newUser);
		return newUser != null;
	}
}
