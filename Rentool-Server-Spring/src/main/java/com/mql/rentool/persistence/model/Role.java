package com.mql.rentool.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue
	Long id;
	String type;

	public Role() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
