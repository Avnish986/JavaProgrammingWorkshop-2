package com.hotelmanagement.dto;

public class Hotel {
	private String hotel_name;
	private int rateRegularCustWeekday;
	private int rateRegularCustWeekend;

	public Hotel() {

	}

	public Hotel(String hotel_name, int rateRegularCustWeekday, int rateRegularCustWeekend) {
		this.hotel_name = hotel_name;
		this.rateRegularCustWeekday = rateRegularCustWeekday;
		this.rateRegularCustWeekend = rateRegularCustWeekend;
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

	@Override
	public String toString() {
		return ("Hotel " + getName() + " Weekday Rate $" + getRateWeekday() + " Weekend Rate $" + getRateWeekend()
				+ "\n");
	}
}
