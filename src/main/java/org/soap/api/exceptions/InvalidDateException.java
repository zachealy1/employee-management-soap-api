/**
 * A custom exception file for handling invalid date-related errors in the DatabaseServer web service.
 */
package org.soap.api.exceptions;

import jakarta.xml.ws.WebFault;

/**
 * A custom exception class for handling invalid date-related errors in the
 * DatabaseServer web service. This exception is thrown when date-related input
 * is invalid or not found.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@WebFault
public class InvalidDateException extends Exception {

	/**
	 * Constructs a new `InvalidDateException` with the specified error message.
	 *
	 * @param message The error message describing the nature of the date-related
	 *                issue.
	 */
	public InvalidDateException(String message) {
		super("InvalidDateException: " + message);
	}
}
