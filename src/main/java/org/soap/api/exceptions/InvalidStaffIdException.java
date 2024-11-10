/**
 * A custom exception file for handling invalid staff ID-related errors in the DatabaseServer web service.
 */
package org.soap.api.exceptions;

import jakarta.xml.ws.WebFault;

/**
 * A custom exception class for handling invalid staff ID-related errors in the
 * DatabaseServer web service. This exception is thrown when staff ID-related
 * input is invalid or not found.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@WebFault
public class InvalidStaffIdException extends Exception {

	/**
	 * Constructs a new `InvalidStaffIdException` with the specified error message.
	 *
	 * @param message The error message describing the nature of the staff
	 *                ID-related issue.
	 */
	public InvalidStaffIdException(String message) {
		super("InvalidStaffIdException: " + message);
	}
}
