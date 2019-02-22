package com.philips.philipshealthcare.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Examination")
public class Examination {
	@Id
	@Column(name = "eid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long eid;

	@Column(name="examdate")
	@Temporal(TemporalType.DATE)
	private Date examDate;

	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "weight")
	private Double weight;
	
	@Column(name = "height")
	private Integer height;
	
	@ManyToMany(mappedBy="examinations")
	private Patient patient;

	public Examination(long eid, Date examDate, String name, String description, Double weight, Integer height,
			Patient patient) {
		super();
		this.eid = eid;
		this.examDate = examDate;
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.height = height;
		this.patient = patient;
	}

	public Examination() {
		super();
	}

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	

}
