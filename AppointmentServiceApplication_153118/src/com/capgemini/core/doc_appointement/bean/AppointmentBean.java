package com.capgemini.core.doc_appointement.bean;

import java.util.Date;

public class AppointmentBean {
	
	private int id;
	private String name;
	private long phone;
	private String mail;
	private int age;
	private String gender;
	private String problem;
	private Date dateOfappointment;
	
	public AppointmentBean() {
		super();
	}

	

	public AppointmentBean(int id, String name, long phone, String mail, int age, String gender, String problem,
			Date dateOfappointment) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.age = age;
		this.gender = gender;
		this.problem = problem;
		this.dateOfappointment = dateOfappointment;
	}
	
	



	public AppointmentBean(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Date getDateOfappointment() {
		return dateOfappointment;
	}

	public void setDateOfappointment(Date dateOfappointment) {
		this.dateOfappointment = dateOfappointment;
	}



	@Override
	public String toString() {
		return "AppointmentBean [id=" + id + ", name=" + name + ", phone=" + phone + ", mail=" + mail + ", age=" + age
				+ ", gender=" + gender + ", problem=" + problem + ", dateOfappointment=" + dateOfappointment + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentBean other = (AppointmentBean) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
}
