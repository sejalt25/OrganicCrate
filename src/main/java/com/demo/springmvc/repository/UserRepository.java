package com.demo.springmvc.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.springmvc.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//@Query("select u from User u where u.email = ?1")
	Optional<User> findByEmail(String email);
		}
