package com.hotelmanagement;

import com.hotelmanagement.dto.*;
import java.util.*;
import com.hotelmanagement.exception.*;
import com.hotelmanagement.validation.*;

public class HotelManagementMain {

	public static void main(String[] args) throws HotelException {
		System.out.println("Welcome to hotel reservation program");
		HotelList hotelList = new HotelList();
		HotelValidation valid = new HotelValidation();
		while (true) {
			System.out.println("Press 1 to Add a Hotel");
			System.out.println("Press 2 to View a Hotel and Rate");
			System.out.println("Press 3 to Quit");
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
				System.out.println("Bye");
				return;

			default:
				System.out.println("Enter valid option");
			}
		}
	}

}
