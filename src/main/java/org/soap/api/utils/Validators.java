package org.soap.api.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This utility class provides methods for data validation using regular
 * expressions and other checks.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
public class Validators {

	/**
	 * Validates a string against a regular expression pattern.
	 *
	 * @param string The string to validate.
	 * @param regEx  The regular expression pattern to use for validation.
	 * @return true if the string matches the regular expression, false otherwise.
	 */
	public static boolean validateRegEx(String string, String regEx) {
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validates the length of an ID string.
	 *
	 * @param id The ID string to validate.
	 * @return true if the ID string has a length of 15 characters, false otherwise.
	 */
	public static boolean validateIdLength(String id) {
		if (id.length() == 15) {
			return true;
		} else {
			return false;
		}
	}
}
