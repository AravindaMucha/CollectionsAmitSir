package com.capgemini.core.lpg.view;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import com.capgemini.core.lpg.beans.AgencyBean;
import com.capgemini.core.lpg.exceptions.LPGException;
import com.capgemini.core.lpg.service.AgencyService;
import com.capgemini.core.lpg.service.AgencyServiceImpl;

public class AgencyClient {
	private AgencyService agencyService;

	public AgencyClient() {
		agencyService = new AgencyServiceImpl();
	}
public static void main(String[] args) {
		
		AgencyClient client = new AgencyClient();
		
		//---makes sure application runs forever unless you close it---
		while(true)
			client.menu();
	}

private void menu() {
	
	System.out.println("1)View Availability");
	System.out.println("2)Booking");
	System.out.println("0)Exit Application");
	
	Scanner console = new Scanner(System.in);
	
	System.out.println("\nPlease select an option");
	int choice = console.nextInt();
	switch (choice) {
	case 1:
		 
		try {
			List<AgencyBean> agencybeans = agencyService.getData();
	
			Iterator<AgencyBean> it = agencybeans.iterator();
			System.out.println("Agency Name /t Location /t CylinderCount");
			
			
			while(it.hasNext()) {
				AgencyBean bean1 = it.next();
				System.out.println( bean1.getName()+ "\t" + 
					    bean1.getLocation() + "\t" +
					    bean1.getCylinderCount());
			}
			
		}
		catch(LPGException e) { 
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		break;

	case 2:
		System.out.println("Enter Agency Name");
		String str = console.next();
		
		System.out.println("Enter the no of cylinders required");		
		int c = console.nextInt();
		try {
			int id = agencyService.bookLPG(str,c);
			
			if(id == 0)
				System.out.println("Sorry!, no cylinders available");
			else
				System.out.println("Your booking id is: " + id);
		} catch (LPGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		break;
	case 0:
		System.out.println("Goodbye");
		System.exit(0);
		break;
	default:
		System.out.println("Invalid");
		break;
	}
	
}
}

