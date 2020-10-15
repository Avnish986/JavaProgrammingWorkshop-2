package com.hotelmanagement.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HotelList {
	public List<Hotel> hotelList;

	public HotelList() {
		hotelList = new ArrayList<>();
	}

	public void addHotel(String hotel_name, int rateRegularCustWeekday, int rateRegularCustWeekend) {
		Hotel hotel = new Hotel(hotel_name, rateRegularCustWeekday, rateRegularCustWeekend);
		hotelList.add(hotel);
	}

	public void getCheapHotel(String dates) throws ParseException {
		String[] range = dates.split(",");
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Date checkin = (Date) dateFormat.parse(range[0]);
		Date checkout = (Date) dateFormat.parse(range[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int noOfDays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);
		int day = checkin.getDay();
		int min = Integer.MAX_VALUE;
		Map<String, Integer> list = new HashMap<>();
		for (Hotel k : hotelList) {
			int price = 0;
			int tempDay = day;
			for (int i = 0; i < noOfDays; i++) {
				if (tempDay == 0 || tempDay == 6) {
					price += k.getRateWeekend();
				} else {
					price += k.getRateWeekday();
				}
				tempDay = (tempDay + 1) % 7;
			}
			if (min > price) {
				min = price;
			}
			list.put(k.getName(), price);
		}
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getValue() == min) {
				System.out.print(entry.getKey() + ",");
			}
		}
		System.out.print(" with total rates $" + min + "\n");
	}

	@Override
	public String toString() {
		System.out.println(hotelList);
		return "";
	}
}
