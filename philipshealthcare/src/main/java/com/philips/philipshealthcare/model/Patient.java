package com.philips.philipshealthcare.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="patient")
public class Patient {
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pid;
	@Column(name="name")
	private String name;
	@Column(name="dateofbirth")
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	@Column(name="gender")
	private String gender;
	
	@ManyToMany(mappedBy="patients")
	private Hospital hospital;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="patient_examination",
	joinColumns=@JoinColumn(name="pos_id", referencedColumnName="pid"),
	inverseJoinColumns=@JoinColumn(name="exam_id", referencedColumnName="eid"))
	private Set<Examination> examinations;

	public Patient(Long pid, String name, Date dateofbirth, String gender, Hospital hospital,
			Set<Examination> examinations) {
		super();
		this.pid = pid;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.hospital = hospital;
		this.examinations = examinations;
	}

	public Patient() {
		super();
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Set<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}
	
	

}
