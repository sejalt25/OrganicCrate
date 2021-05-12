
package com.demo.springmvc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;
@Entity
@Data
@Table(name="Myaddress")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;

	@OneToOne
	private User user;
	
	@Column(name="addr_line_one")
	@NotBlank(message = "Please Enter Address Line One!")
	private String addressLineOne;

	@Column(name="city")
	@NotBlank(message = "Please Enter City!")
	private String city;

	@Column(name="state")
	@NotBlank(message = "Please Enter state!")
	private String state;

	@Column(name="country")
	@NotBlank(message = "Please Enter Country!")
	private String country;

	@Column(name="postal_code")
	@NotBlank(message = "Please Enter Postal Code!")
	private String postalCode;

}
