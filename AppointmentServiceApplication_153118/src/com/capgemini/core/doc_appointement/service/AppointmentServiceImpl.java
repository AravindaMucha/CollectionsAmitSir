package com.capgemini.core.doc_appointement.service;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.capgemini.core.doc_appointement.bean.AppointmentBean;
import com.capgemini.core.doc_appointement.exception.ASAException;
import com.capgemini.core.doc_appointement.model.AppointmentDAO;
import com.capgemini.core.doc_appointement.model.AppointmentDAOImpl;

public class AppointmentServiceImpl implements AppointmentService{

	private AppointmentDAO AppDAO;
		
	public AppointmentServiceImpl() {
		AppDAO = new AppointmentDAOImpl();
	}
	
	
	@Override
	public int addPatient(AppointmentBean appointmentlist) throws ASAException {
		int patID = 0;
		if(isValid(appointmentlist))
			patID = AppDAO.addPatient(appointmentlist);
			
		return patID;
	}

	public boolean isValid(AppointmentBean appointment) throws ASAException 
	{
		if( appointment == null)
			throw new ASAException( "Appointment instance cannot be null" );
		
		if( appointment.getName() == null || appointment.getName().trim().isEmpty() )
			throw new ASAException( "Patient Name Cannot be Empty" );
		
		if( appointment.getPhone() == 0 ||  isPhoneNumberInvalid( appointment.getPhone() ) )
			throw new ASAException( "Phone Number is invalid" );
		
		if( appointment.getMail() == null || isEmailInvalid( appointment.getMail() ) )
			throw new ASAException( "Email has to be a valid email" );
		
		if( !(appointment.getAge() > 1 && appointment.getAge() <= 120) )
			throw new ASAException( "Age has to be between 1 to 120" );
		
		if( appointment.getGender() == null || isGenderInvalid( appointment.getGender() ) ) 
			throw new ASAException( "Gender can only be Male or Female" );
		
		if( appointment.getProblem() == null ||  appointment.getProblem().trim().isEmpty() )
			throw new ASAException( "Problem cannot be blank" );
		
		if( appointment.getDateOfappointment() == null ||  isDateInvalid( appointment.getDateOfappointment()) )
			throw new ASAException( "AppointmentRequest date has to be greater then current date" );
		
		return true;
	}
	
	public boolean isDateInvalid(Date date) 
	{
		if( date.compareTo( new Date() ) <= 0)
			return true;
		else
			return false;
	}

	public static boolean isGenderInvalid(String gender) 
	{
		gender = gender.toLowerCase();
		
		if( !gender.matches("^male$|^female$"))
			return true;	
		else
			return false;
	}
	
	public boolean isEmailInvalid( String email ) {
		
		if( email.matches(".+\\@.+\\..+") ) 
		{
			return false;
		}		
		else 
			return true;
	}

	public static boolean isPhoneNumberInvalid( long phoneNumber )
	{
		if(String.valueOf(phoneNumber).matches("[1-9][0-9]{9}")) 
		{
			return false;
		}		
		else 
			return true;
	}
	
	public Date getDateFromString( String dateInString )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate localDate = LocalDate.parse(dateInString , formatter);

		java.util.Date date = java.sql.Date.valueOf( localDate );

		return date;
	}


	@Override
	public AppointmentBean getPatientData(int id) throws ASAException {
		AppointmentBean appointment = null;
		appointment = AppDAO.getPatientData(id);
				
		return appointment;
	}
	
	

}
