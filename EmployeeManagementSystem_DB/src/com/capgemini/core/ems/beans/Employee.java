package com.capgemini.core.ems.beans;

import java.util.Date;

public class Employee {
	
		private int id;
		private String name;
		private double salary;
		private String department;
		private Date dateOfBirth;
		private Date dateOfJoining;
		
		public Employee() {
			super();
		}
		
		

		public Employee(int id) {
			super();
			this.id = id;
		}



		public Employee(int id, String name, double salary, String department,
				Date dateOfBirth, Date dateOfJoining) {
			super();
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.department = department;
			this.dateOfBirth = dateOfBirth;
			this.dateOfJoining = dateOfJoining;
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

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Date getDateOfJoining() {
			return dateOfJoining;
		}

		public void setDateOfJoining(Date dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
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
			Employee other = (Employee) obj;
			if (id != other.id)
				return false;
			return true;
		}



		@Override
		public String toString() {
			return "Employee [dateOfBirth=" + dateOfBirth + ", dateOfJoining="
					+ dateOfJoining + ", department=" + department + ", id="
					+ id + ", name=" + name + ", salary=" + salary + "]";
		}
		
		
		
		
		
	
}
