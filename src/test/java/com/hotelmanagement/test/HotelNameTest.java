package com.hotelmanagement.test;

import com.hotelmanagement.validation.*;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class HotelNameTest {
	@Test
	public void givenHotelNameValidReturnTrue() {
		HotelValidation valid = new HotelValidation();
		boolean result = valid.validateHotelName("Lakewood");
		Assert.assertEquals(true,result);

	}

	@Test
	public void givenHotelNameInValidReturnFalse() {
		HotelValidation valid = new HotelValidation();
		boolean result = valid.validateHotelName("lakewood");
		Assert.assertEquals(false,result);

	}
}
