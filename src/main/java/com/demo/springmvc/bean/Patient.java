package com.demo.springmvc.bean;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
@Entity
@Data
@PrimaryKeyJoinColumn(name="user_id")
public class Patient extends User{
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long patientId;
	
	@OneToOne
	@JoinColumn
	private Disease disease;
}
