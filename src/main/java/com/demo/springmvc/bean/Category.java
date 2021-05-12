package com.demo.springmvc.bean;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue
	@NotNull
	private Long cid;

	@NotNull
	@UniqueElements
	private String cname;

	@NotNull
	private String cdesc;

	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private List<Product >products;

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", cdesc=" + cdesc+ "]";
	}
}