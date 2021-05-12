package com.demo.springmvc.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.springmvc.bean.User;
import com.demo.springmvc.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optUser =userRepository.findByEmail(username);
		if(!optUser.isPresent())
			throw new UsernameNotFoundException("Email Not Valid");
		return optUser.map(MyUserDetails::new).orElse(null);
	}

}
