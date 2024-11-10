/**
 * This file contains constants used for various validation patterns and file paths.
 */
package org.soap.api.utils;

/**
 * This class contains constants used for various validation patterns and file
 * paths.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
public class Constants {

	/**
	 * Regular expression pattern for validating ID strings.
	 */
	public static final String ID_REGEX_PATTERN = "^[0-9A-Fa-f]+$";

	/**
	 * Regular expression pattern for validating email addresses.
	 */
	public static final String EMAIL_REGEX_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

	/**
	 * Regular expression pattern for validating date of birth strings in
	 * "yyyy-MM-dd" format.
	 */
	public static final String DOB_REGEX_PATTERN = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";

	/**
	 * Regular expression pattern for validating phone numbers.
	 */
	public static final String PHONE_NUMBER_REGEX_PATTERN = "^[0-9\\-\\+\\(\\)Xx.]+$";

	/**
	 * Date format string for parsing and formatting dates in "yyyy-MM-dd" format.
	 */
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * File path to the CSV file containing data.
	 */
	public static final String FILE_PATH = "/Users/zachealy/git/CSF205_Demonstrations/CW1/people-100.csv";

	/**
	 * Delimiter used in the CSV file for separating values.
	 */
	public static final String DELIMITER = ",";
}
