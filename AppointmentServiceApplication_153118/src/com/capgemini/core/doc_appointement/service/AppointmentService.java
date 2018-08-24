package com.capgemini.core.doc_appointement.service;

import com.capgemini.core.doc_appointement.bean.AppointmentBean;
import com.capgemini.core.doc_appointement.exception.ASAException;

public interface AppointmentService {
	
	public int addPatient(AppointmentBean appointmentlist) throws ASAException;
	public AppointmentBean getPatientData(int id) throws ASAException;
}
