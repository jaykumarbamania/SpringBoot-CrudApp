package com.neosoft.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name ="project")
public class Project {
	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "proj_name")
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date proj_duration;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="developer_id", nullable=false)
	private Developer developers;


	public Project(@NotNull @Size(max = 65) String name, Date proj_duration) {
		super();
		this.name = name;
		this.proj_duration = proj_duration;
	}
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getProj_duration() {
		return proj_duration;
	}

	public void setProj_duration(Date proj_duration) {
		this.proj_duration = proj_duration;
	}

	public Developer getDevelopers() {
		return developers;
	}

	public void setDevelopers(Developer developers) {
		this.developers = developers;
	}
	

}
