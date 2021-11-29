package com.neosoft.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="users_profile")
public class UserProfile {
	
	@Id
	@Column(name="user_profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max= 15)
	@NotNull
	@Column(name="phoneNo",unique = true)
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Size(max = 100)
	private String city;
	
	@Size(max = 100)
	private String state;
	
	@Size(max = 100)
	private String country;
	
	@Size(max = 10)
	@Column(name="zip_code")
	private String zipCode;
	
	//mapping
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	private Users users;
	
	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	public UserProfile(@Size(max = 12) @NotNull String phoneNumber, Gender gender, Date dateOfBirth,
			@Size(max = 100) String city, @Size(max = 100) String state, @Size(max = 100) String country,
			@Size(max = 10) String zipCode) {
		super();
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	

}
