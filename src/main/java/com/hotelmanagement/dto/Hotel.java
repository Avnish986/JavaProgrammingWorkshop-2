package com.hotelmanagement.dto;

public class Hotel {
	private String hotel_name;
	private int rateRegularCust;

	public Hotel() {

	}

	public Hotel(String hotel_name, int rateRegularCust) {
		this.hotel_name = hotel_name;
		this.rateRegularCust = rateRegularCust;
	}

	public void setName(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public void setRate(int rateRegularCust) {
		this.rateRegularCust = rateRegularCust;
	}

	public String getName() {
		return hotel_name;
	}

	public int getRate() {
		return rateRegularCust;
	}

	@Override
	public String toString() {
		return ("Hotel " + getName() + " Rate $" + getRate() + "\n");
	}
}
