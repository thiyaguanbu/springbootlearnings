package com.example.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="playerdetails")
public class Playerdetails {
	
	@Id
	private Integer id;
	
	private String firstName;
	
	private String country;
	
	private String lastName;
	
	private int age;
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Playerdetails(Integer id, String firstName, String country, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.country = country;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Playerdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
