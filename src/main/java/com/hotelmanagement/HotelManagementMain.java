package com.hotelmanagement;

import com.hotelmanagement.dto.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.hotelmanagement.exception.*;
import com.hotelmanagement.validation.*;

public class HotelManagementMain {

	public static void main(String[] args) throws HotelException, ParseException {
		System.out.println("Welcome to hotel reservation program");
		HotelList hotelList = new HotelList();
		HotelValidation valid = new HotelValidation();
		while (true) {
			System.out.println("Press 1 to Add a Hotel");
			System.out.println("Press 2 to View a Hotel and Rate");
			System.out.println("Press 3 to Get cheapest hotel");
			System.out.println("Press 4 to Quit");
			Scanner sc = new Scanner(System.in);
			int op = sc.nextInt();
			switch (op) {
			case 1:
					System.out.println("Enter hotel name");
					String name = sc.next();
					boolean isValid = valid.validateHotelName(name);
					while (!isValid) {
						System.out.println("Invalid hotel name");
						name = sc.next();
						isValid = valid.validateHotelName(name);
					}			
					System.out.println("Enter regular customer rate");
					int rate = sc.nextInt();
					hotelList.addHotel(name, rate);
					break; 
			case 2:
				System.out.println(hotelList);
				break;
			case 3:
				System.out.println("Enter the date range(ddMMMyyyy)");
				String range = sc.next();
				hotelList.getCheapHotel(range);
				
				break;
			case 4:
				System.out.println("Bye");
				return;

			default:
				System.out.println("Enter valid option");
			}
		}
	}

}
