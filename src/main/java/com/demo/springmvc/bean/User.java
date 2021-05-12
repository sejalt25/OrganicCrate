package com.demo.springmvc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	private int userId;

	@Column(nullable = false,unique = true, length = 40)
	private String email;

	@Column(nullable = false,length = 60)
	private String password;

	@Column(name="first_name",nullable = false,length = 20)
	private String firstName;

	@Column(name="last_name",nullable = false,length = 20)
	private String lastName;

	private boolean enabled;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;

	@Column(nullable = false)
	private String gender;

	//@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
			//message="{invalid.Mobile Number}")
	@Column(name = "mobile")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String userMobile;

	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinTable(
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles = new ArrayList<>();

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
}
