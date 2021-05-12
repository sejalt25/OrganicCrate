package com.demo.springmvc.bean;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Disease {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long diseaseId;
	
	@NotNull
	private String diseaseName;
	
	@OneToMany(mappedBy="disease",fetch=FetchType.LAZY)
	private List<Product >products = new ArrayList<>() ;
	
	@OneToMany(mappedBy = "disease",fetch = FetchType.LAZY)
	private List<Patient> patient;
	
	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + "]";
	}
	
	
	
}
