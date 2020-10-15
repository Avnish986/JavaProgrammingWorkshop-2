package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class HotelList {
	public List<Hotel> hotelList;
	
	public HotelList() {
		hotelList = new ArrayList<>();
	}
	public void addHotel(String hotel_name, int rateRegularCust) {
		Hotel hotel=new Hotel(hotel_name,rateRegularCust);
		hotelList.add(hotel);
	}

	
	@Override
	public String toString() {
		System.out.println(hotelList);
		return "";
	}
}
