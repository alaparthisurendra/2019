package com.philips.philipshealthcare.model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hospital")
public class Hospital {
	
	@Id
	@Column(name="hid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long hid;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="hospital_patient",
	joinColumns=@JoinColumn(name="hos_id", referencedColumnName="hid"), 
	inverseJoinColumns=@JoinColumn(name="pat_id", referencedColumnName="pid"))
	private List<Patient> patients;

	public Hospital(Long hid, String name, String description, List<Patient> patients) {
		super();
		this.hid = hid;
		this.name = name;
		this.description = description;
		this.patients = patients;
	}

	public Hospital() {
		super();
	}

	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
	
	
}
