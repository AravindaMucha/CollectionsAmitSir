package com.capgemini.core.doc_appointement.model;

import java.util.List;

import com.capgemini.core.doc_appointement.bean.AppointmentBean;
import com.capgemini.core.doc_appointement.exception.ASAException;
import com.capgemini.core.doc_appointement.util.DBUtil;


public class AppointmentDAOImpl implements AppointmentDAO {
	
	private List<AppointmentBean> appointmentlists;
	private DBUtil dbUtil = new DBUtil();
	
	private int patientID = 1000;
	
	public AppointmentDAOImpl() {
		super();
		appointmentlists = dbUtil.getAppointmentList();	
	}
	
	public int generatePatientId() {
		return ++patientID;
	}
	
	
	@Override
	public int addPatient(AppointmentBean appointmentlist) throws ASAException {
		
		int patId = generatePatientId();
		
		appointmentlist.setId(patId);
		
		appointmentlists.add(appointmentlist);
		
		return patId;
	}

	@Override
	public AppointmentBean getPatientData(int id) throws ASAException {
		
		int index = appointmentlists.indexOf(new AppointmentBean(id));
		
		if(index == -1) {
			throw new ASAException("Patient ID not registered with " + id);

		}
		
		return appointmentlists.get(index);
	}

}
