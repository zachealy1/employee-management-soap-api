/**
 * A custom exception file for handling invalid phone number related errors in the DatabaseServer web service.
 */
package org.soap.api.exceptions;

import jakarta.xml.ws.WebFault;

/**
 * A custom exception class for handling invalid phone number related errors in the
 * DatabaseServer web service. This exception is thrown when phone number
 * input is invalid or not found.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@WebFault
public class InvalidPhoneNumberException extends Exception {

	/**
	 * Constructs a new `InvalidPhoneNumberException` with the specified error message.
	 *
	 * @param message The error message describing the nature of the phone number related issue.
	 */
	public InvalidPhoneNumberException(String message) {
		super("InvalidPhoneNumberException: " + message);
	}
}
