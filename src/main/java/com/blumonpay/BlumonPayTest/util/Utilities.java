package com.blumonpay.BlumonPayTest.util;

import java.time.LocalDate;

import com.blumonpay.BlumonPayTest.exceptions.ErrorWritingInformationException;

public class Utilities {
	
	public static LocalDate parseStrToLocalDate(String date) {
		if(date == null || date.isBlank()) throw new ErrorWritingInformationException("Date has not a valid format");
		return LocalDate.parse(date);
	}
	
}
