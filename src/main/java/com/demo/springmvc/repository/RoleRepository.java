package com.demo.springmvc.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.springmvc.bean.Role;
import com.demo.springmvc.bean.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRoleName(RoleName roleName);
}
