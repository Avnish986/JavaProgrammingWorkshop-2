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

	public void addHotel(String hotel_name, int rateRegularCustWeekday, int rateRegularCustWeekend, int rating,
			int rateRewardCustWeekday, int rateRewardCustWeekend) {
		Hotel hotel = new Hotel(hotel_name, rateRegularCustWeekday, rateRegularCustWeekend, rating,
				rateRewardCustWeekday, rateRewardCustWeekend);
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
		Map<String, Integer> byRating = new HashMap<>();
		for (Hotel k : hotelList) {
			int price = 0;
			int tempDay = day;
			for (int i = 0; i < noOfDays; i++) {
				if (tempDay == 0 || tempDay == 6) {
					price += k.getRateWeekendRegular();
				} else {
					price += k.getRateWeekdayRegular();
				}
				tempDay = (tempDay + 1) % 7;
			}
			if (min > price) {
				min = price;
			}
			list.put(k.getName(), price);
			byRating.put(k.getName(), k.getRating());

		}
		List<String> finalHotel = new ArrayList<>();
		int minRate = -1;
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getValue() == min) {
				for (Map.Entry<String, Integer> entry1 : byRating.entrySet()) {
					if (entry1.getValue() > minRate && entry1.getKey().equals(entry.getKey())) {
						minRate = entry1.getValue();
						if (finalHotel.size() == 0)
							finalHotel.add(entry1.getKey());
						else
							finalHotel.set(0, entry1.getKey());
					}
				}
			}
		}
		int finalRating = 0, finalPrice = 0;
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getKey().equals(finalHotel.get(0))) {
				finalPrice = entry.getValue();
				for (Map.Entry<String, Integer> entry1 : byRating.entrySet()) {
					if (entry1.getKey().equals(finalHotel.get(0))) {
						finalRating = entry1.getValue();
					}
				}
			}
		}
		System.out.print(finalHotel.get(0) + "," + " Rating: " + finalRating + " Total Rates:$" + finalPrice + "\n");
	}

	@Override
	public String toString() {
		System.out.println(hotelList);
		return "";
	}

	public void getBestHotel(String range2) throws ParseException {
		String[] range = range2.split(",");
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Date checkin = (Date) dateFormat.parse(range[0]);
		Date checkout = (Date) dateFormat.parse(range[1]);
		long difference = checkout.getTime() - checkin.getTime();
		int noOfDays = (int) ((difference / (1000 * 60 * 60 * 24)) + 1);
		int day = checkin.getDay();
		Map<String, Integer> list = new HashMap<>();
		Map<String, Integer> byRating = new HashMap<>();
		for (Hotel k : hotelList) {
			int price = 0;
			int tempDay = day;
			for (int i = 0; i < noOfDays; i++) {
				if (tempDay == 0 || tempDay == 6) {
					price += k.getRateWeekendRegular();
				} else {
					price += k.getRateWeekdayRegular();
				}
				tempDay = (tempDay + 1) % 7;
			}
			list.put(k.getName(), price);
			byRating.put(k.getName(), k.getRating());
		}
		List<String> finalHotel = new ArrayList<>();
		int minRate = -1;
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			for (Map.Entry<String, Integer> entry1 : byRating.entrySet()) {
				if (entry1.getValue() > minRate && entry1.getKey().equals(entry.getKey())) {
					minRate = entry1.getValue();
					if (finalHotel.size() == 0)
						finalHotel.add(entry1.getKey());
					else
						finalHotel.set(0, entry1.getKey());
				}
			}
		}
		int finalRating = 0, finalPrice = 0;
		for (Map.Entry<String, Integer> entry : list.entrySet()) {
			if (entry.getKey().equals(finalHotel.get(0))) {
				finalPrice = entry.getValue();
				for (Map.Entry<String, Integer> entry1 : byRating.entrySet()) {
					if (entry1.getKey().equals(finalHotel.get(0))) {
						finalRating = entry1.getValue();
					}
				}
			}
		}
		System.out.print(finalHotel.get(0) + " & Total Rates $" + finalPrice + "\n");

	}
}
