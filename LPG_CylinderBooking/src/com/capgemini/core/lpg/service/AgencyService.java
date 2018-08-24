package com.capgemini.core.lpg.service;

import java.util.List;

import com.capgemini.core.lpg.beans.AgencyBean;
import com.capgemini.core.lpg.exceptions.LPGException;

public interface AgencyService {
	public List<AgencyBean> getData() throws LPGException;
	public int bookLPG(String AgencyName, int CylinderCount) throws LPGException;
}