package com.demo.springmvc.bean;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="roles") 
public class Role {
	@Id
	@GeneratedValue
	private int roleId;
	
	@Enumerated(EnumType.STRING)
    private RoleName roleName;
	
	@ManyToMany(mappedBy = "roles")
	
	private List <User> users;
	
	public Role(RoleName roleName) {
		this.roleName = roleName;
	}
}
