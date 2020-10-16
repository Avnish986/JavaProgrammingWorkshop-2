package com.hotelmanagement.dto;

public class Hotel {
	private String hotel_name;
	private int rateRegularCustWeekday;
	private int rateRegularCustWeekend;
	private int rating;
	private int rateRewardCustWeekday;
	private int rateRewardCustWeekend;

	public Hotel() {

	}

	public Hotel(String hotel_name, int rateRegularCustWeekday, int rateRegularCustWeekend, int rating,
			int rateRewardCustWeekday, int rateRewardCustWeekend) {
		this.hotel_name = hotel_name;
		this.rateRegularCustWeekday = rateRegularCustWeekday;
		this.rateRegularCustWeekend = rateRegularCustWeekend;
		this.rating = rating;
		this.rateRewardCustWeekday = rateRewardCustWeekday;
		this.rateRewardCustWeekend = rateRewardCustWeekend;
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

	public int getRateWeekdayRegular() {
		return rateRegularCustWeekday;
	}

	public int getRateWeekendRegular() {
		return rateRegularCustWeekend;
	}

	public int getRating() {
		return rating;
	}

	public int getRateWeekdayReward() {
		return rateRewardCustWeekday;
	}

	public int getRateWeekendReward() {
		return rateRewardCustWeekend;
	}

	@Override
	public String toString() {
		return ("Hotel " + getName() + " Weekday Rate for regular customer $" + getRateWeekdayRegular()
				+ " Weekend Rate for regular customer  $" + getRateWeekendRegular() + " Rating " + getRating()
				+ " Weekday Rate for reward customer $" + getRateWeekdayReward()
				+ " Weekend Rate for reward customer  $" + getRateWeekendReward() + "\n");
	}
}
