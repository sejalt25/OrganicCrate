package com.demo.springmvc.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	@NotNull
	private String pname;
	
	@NotNull
	private double price;
	
	private int qty;
	
	private String imgUrl;
	
	private String weight;
	
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name="cid")
	private Category category;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	private Disease disease;
}
