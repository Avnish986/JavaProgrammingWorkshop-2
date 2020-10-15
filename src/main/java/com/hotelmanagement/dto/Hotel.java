package com.hotelmanagement.dto;

public class Hotel {
	private String hotel_name;
	private int rateRegularCustWeekday;
	private int rateRegularCustWeekend;
	private int rating;

	public Hotel() {

	}

	public Hotel(String hotel_name, int rateRegularCustWeekday, int rateRegularCustWeekend, int rating) {
		this.hotel_name = hotel_name;
		this.rateRegularCustWeekday = rateRegularCustWeekday;
		this.rateRegularCustWeekend = rateRegularCustWeekend;
		this.rating = rating;
	}

	public void setName(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public void setRate(int rateRegularCustWeekday, int rateRegularCustWeekend) {
		this.rateRegularCustWeekday = rateRegularCustWeekday;
		this.rateRegularCustWeekend = rateRegularCustWeekend;
	}

	public String getName() {
		return hotel_name;
	}

	public int getRateWeekday() {
		return rateRegularCustWeekday;
	}

	public int getRateWeekend() {
		return rateRegularCustWeekend;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return ("Hotel " + getName() + " Weekday Rate $" + getRateWeekday() + " Weekend Rate $" + getRateWeekend()
				+ " Rating " + getRating() + "\n");
	}
}
