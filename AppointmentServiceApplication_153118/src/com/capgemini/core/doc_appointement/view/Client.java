package com.capgemini.core.doc_appointement.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.capgemini.core.doc_appointement.bean.AppointmentBean;
import com.capgemini.core.doc_appointement.exception.ASAException;
import com.capgemini.core.doc_appointement.service.AppointmentService;
import com.capgemini.core.doc_appointement.service.AppointmentServiceImpl;

public class Client {
	private AppointmentService appointmentService;

	public Client() {
		appointmentService = new AppointmentServiceImpl();		
	}

	
	
	private void menu() {
		System.out.println("1)Book Doctor Appointment");
		System.out.println("2)View Doctor Appointment");
		System.out.println("Exit Application");

		Scanner console = new Scanner(System.in);

		System.out.println("\nPlease select an option");
		int choice = console.nextInt();

		switch (choice) {
		case 1:
			System.out.print("Enter Patient Name : ");
			String name = console.next();


			System.out.print("Enter Phone number : ");
			long phone = console.nextLong();


			System.out.print("Enter Mail ID : ");
			String mail = console.next();


			System.out.print("Enter Age : ");
			int age = console.nextInt();			


			System.out.print("Enter Gender : ");
			String gender = console.next();


			System.out.print("Enter Problem Name : ");
			String problem = console.next();


			System.out.print("Enter Appointment Date in the format dd-MM-yyyy: ");
			String dateOfappointment = console.next();
			
			AppointmentBean appointmentBean = new AppointmentBean();

			appointmentBean.setName(name);
			appointmentBean.setPhone(phone);
			appointmentBean.setMail(mail);
			appointmentBean.setAge(age);
			appointmentBean.setGender(gender);;
			appointmentBean.setProblem(problem);
			appointmentBean.setDateOfappointment(convertToDate(dateOfappointment));
			

			try {
				int patId = appointmentService.addPatient(appointmentBean);
				Date date = new Date();
				Date date1 = convertToDate(dateOfappointment);
				
				if(!date1.after(date)) {
					System.out.println("Enter a valid date");
				}else {
					System.out.println("Thank You!..Your Doctor Appointment has been Successfully registered, Your Appintment ID is : " + patId);
				}
			} catch (ASAException e) {
				System.out.println("Something went wrong. Reason: " + e.getMessage() );
			} catch(Exception e) {
				System.out.println("Something went wrong. Reason: " + e.getMessage() );
			}

			break;
			
		case 2:
			System.out.println("Enter Appointment ID : ");
			int patId = console.nextInt();
			
			
			try {
				appointmentBean = appointmentService.getPatientData(patId);
				
				System.out.print("Patient Name : " + appointmentBean.getName());
				System.out.println();
				if(appointmentBean.getProblem().equalsIgnoreCase("Heart")){
					System.out.println("Account Status : APPROVED");
					System.out.println("Doctor Name : Dr.Brijesh Kumar");
					System.out.println("Date of Appointment : " + appointmentBean.getDateOfappointment());
				 }
				
				else if(appointmentBean.getProblem().equalsIgnoreCase("Gynacology")) {
					System.out.println("Account Status : APPROVED");
					System.out.println("Doctor Name : Dr. Sharda Singh");
					System.out.println("Date of Appointment : " + appointmentBean.getDateOfappointment());
				}
				else if(appointmentBean.getProblem().equalsIgnoreCase("Diabetics")) {
					System.out.println("Account Status : APPROVED");
					System.out.println("Doctor Name : Dr.Heena Khan");
					System.out.println("Date of Appointment : " + appointmentBean.getDateOfappointment());
				}
				else if(appointmentBean.getProblem().equalsIgnoreCase("ENT")){
					System.out.println("Account Status : APPROVED");
					System.out.println("Doctor Name : Dr.paras mal");
					System.out.println("Date of Appointment : " + appointmentBean.getDateOfappointment());
				}
				
				else if(appointmentBean.getProblem().equalsIgnoreCase("Bone")){
					System.out.println("Account Status : APPROVED");
					System.out.println("Doctor Name : Dr.Renuka Kher");
					System.out.println("Date of Appointment : " + appointmentBean.getDateOfappointment());
				}
				else if(appointmentBean.getProblem().equalsIgnoreCase("Dermatology")){
					System.out.println("Account Status : APPROVED");
					System.out.println("Doctor Name : Dr.Kanika Kapoor");
					System.out.println("Date of Appointment : " + appointmentBean.getDateOfappointment());
				}
				
				else {
					System.out.println("Account Status : DISAPPROVED");
					System.out.println("Doctor Name :");
					System.out.println("Date of Appointment:");
				}
					
				
				
			} catch (ASAException e) {
				// TODO Auto-generated catch block
				System.out.println("Something went wrong. Reason: " + e.getMessage() );
			}
			break;

		case 0:
			System.out.println("Thank you");
			System.exit(0);
			break;
			
		default:
			System.out.println("Invalid option.");
			break;
		}
	}


	public Date convertToDate(String dateInString) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(dateInString, formatter);
		java.util.Date date = java.sql.Date.valueOf(localDate);	
		return date;
	}

	public static void main(String[] args) {
		Client client = new Client();

		while(true) 
			client.menu();
	}





}
