package com.capgemini.core.doc_appointement.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.core.doc_appointement.bean.AppointmentBean;

public class DBUtil {
	private List<AppointmentBean> appointmentList = new ArrayList<AppointmentBean>();{
		appointmentList.add(new AppointmentBean(101, "Jhon", 9652160279l, "jhon@gmail.com",45, "M", "Heart", null));		
	}
	
	public List<AppointmentBean> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<AppointmentBean> appointmentList) {
		this.appointmentList = appointmentList;
	}
	
	
}
