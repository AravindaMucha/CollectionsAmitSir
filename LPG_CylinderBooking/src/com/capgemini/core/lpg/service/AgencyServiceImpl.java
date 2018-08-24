package com.capgemini.core.lpg.service;

import java.util.List;

import com.capgemini.core.lpg.beans.AgencyBean;
import com.capgemini.core.lpg.exceptions.LPGException;
import com.capgemini.core.lpg.model.AgencyDAO;
import com.capgemini.core.lpg.model.AgencyDAOImpl;

public class AgencyServiceImpl implements AgencyService {

	private AgencyDAO agenDAO;
	
	public AgencyServiceImpl() {
		agenDAO = new AgencyDAOImpl();
	}
	@Override
	public List<AgencyBean> getData() throws LPGException {
		
		List<AgencyBean> agencybean = null;
		agencybean = agenDAO.getData();
		return agencybean;
	}

	@Override
	public int bookLPG(String AgencyName, int CylinderCount) throws LPGException {
		
		int bookingId = 0;
		if(isValid(AgencyName, CylinderCount))
			bookingId = agenDAO.bookLPG(AgencyName, CylinderCount);
		return bookingId;
	}
	
	private boolean isValid(String agencyName, int cylindercount) {
		return true;
	}

}
