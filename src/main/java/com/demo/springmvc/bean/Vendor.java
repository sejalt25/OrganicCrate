package com.demo.springmvc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
@Entity
@Data
@PrimaryKeyJoinColumn(name = "user_id")
public class Vendor extends User {	
	//@Id
	//@GeneratedValue
	//@Column(name = "ven_id")
	//private Long venId;

	@NotNull
	@Column(name="ven_product")
	private String venProduct;

	@NotNull
	@NotBlank(message="please provide your quality assurance certificate")
	@Column(name="ven_certificate")
	private String venCertificate;
}
