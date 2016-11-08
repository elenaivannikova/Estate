package ua.nure.ivannikova.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

	public static boolean dateValidation(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date input = null;
		try {
			input = df.parse(date);
			if (input.before(new Date())) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public static boolean timeValidation(String time) {
		return time.matches("^(((09)|(1[0-8])):(3|0)0)$");
	}
}
