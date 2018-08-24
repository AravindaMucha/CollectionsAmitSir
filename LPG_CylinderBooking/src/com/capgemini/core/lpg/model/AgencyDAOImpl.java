package com.capgemini.core.lpg.model;

import java.util.List;


import com.capgemini.core.lpg.beans.AgencyBean;
import com.capgemini.core.lpg.exceptions.LPGException;
import com.capgemini.core.lpg.util.DBUtil;

public class AgencyDAOImpl implements AgencyDAO {

	private DBUtil dbUtil = new DBUtil();
	private List<AgencyBean> bean;
	int bookingId = 1000;
	
	public AgencyDAOImpl() {
		bean = dbUtil.getAgencyBean();
	}	
	
	public int generateBookingId() {
	
		return ++bookingId;
	}
	
	@Override
	public List<AgencyBean> getData() throws LPGException {
		// TODO Auto-generated method stub
		return bean;
	}

	@Override
	public int bookLPG(String str, int count) throws LPGException {
		
		int id = generateBookingId();
		int index = bean.indexOf(new AgencyBean(str));
		
		if(index == -1)
			throw new LPGException("Not Valid");
		AgencyBean abs = bean.get(index);
		//int diff = abs.getCylinderCount() - count;
		
		if(count <= (abs.getCylinderCount())) {
			abs.setCylinderCount(abs.getCylinderCount() - count);
		}
		else {
			return 0;
		}
		return bookingId;
		
	}

}
