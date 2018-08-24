package com.capgemini.core.lpg.model;

import java.util.List;

import com.capgemini.core.lpg.beans.AgencyBean;
import com.capgemini.core.lpg.exceptions.LPGException;

public interface AgencyDAO {
	
	public List<AgencyBean> getData() throws LPGException;
	public int bookLPG(String str, int count) throws LPGException;

	
}
