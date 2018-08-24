package com.capgemini.core.lpg.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.core.lpg.beans.AgencyBean;

public class DBUtil {
	
	private List<AgencyBean> agencyBean = new ArrayList<AgencyBean>();
	{
		agencyBean.add(new AgencyBean("Jyothi", "Mumbai", 45));
		agencyBean.add(new AgencyBean("HP", "Pune", 46));
		agencyBean.add(new AgencyBean("Indane", "Hyderabad", 56));
		agencyBean.add(new AgencyBean("Bharat", "chennai", 5));
	}
	public List<AgencyBean> getAgencyBean() {
		return agencyBean;
	}
	public void setAgencyBean(List<AgencyBean> agencyBean) {
		this.agencyBean = agencyBean;
	}
	
	
	
	
}
