package com.hotelmanagement.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HotelList {
	public List<Hotel> hotelList;

	public HotelList() {
		hotelList = new ArrayList<>();
	}

	public void addHotel(String hotel_name, int rateRegularCustWeekday, int rateRegularCustWeekend) {
		Hotel hotel = new Hotel(hotel_name, rateRegularCustWeekday, rateRegularCustWeekday);
		hotelList.add(hotel);
	}

	public void getCheapHotel(String dates) throws ParseException {
		String[] range = dates.split(",");
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Date checkin = (Date) dateFormat.parse(range[0]);
		Date checkout = (Date) dateFormat.parse(range[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int noOfDays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);
		List<Integer> allPrice = new ArrayList<>();
		for (Hotel i : hotelList) {
			allPrice.add((int) (noOfDays * i.getRateWeekday()));
		}

		Collections.sort(allPrice);
		System.out.println("total days: " + noOfDays);
		System.out.println("The Hotel found : " + hotelList.get(0).getName() + ", Total Rate : " + allPrice.get(0));
	}

	@Override
	public String toString() {
		System.out.println(hotelList);
		return "";
	}
}
