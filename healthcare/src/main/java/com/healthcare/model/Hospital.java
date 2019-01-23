package com.healthcare.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hospital_tbl")
public class Hospital {
	@Id
	@Column(name = "hospital_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
	//@OneToMany(mappedBy = "hospital", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	// @OnDelete(action = OnDeleteAction.CASCADE)
	private List<Patient> patient;
	

	public Hospital() {
		super();
	}

	public Hospital(Long id, String name, String description, List<Patient> patient) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.patient = patient;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

}
