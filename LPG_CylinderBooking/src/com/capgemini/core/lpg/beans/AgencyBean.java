package com.capgemini.core.lpg.beans;

public class AgencyBean {
	

	private String name;
	public AgencyBean(String name) {
		super();
		this.name = name;
	}



	private String location;
	private int CylinderCount;
	
	public AgencyBean() {
		super();
	}



	public AgencyBean(String name, String location, int cylinderCount) {
		super();
		this.name = name;
		this.location = location;
		CylinderCount = cylinderCount;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCylinderCount() {
		return CylinderCount;
	}

	public void setCylinderCount(int cylinderCount) {
		CylinderCount = cylinderCount;
	}



	@Override
	public String toString() {
		return "AgencyBean [name=" + name + ", location=" + location + ", CylinderCount=" + CylinderCount + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AgencyBean other = (AgencyBean) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	
	
}
