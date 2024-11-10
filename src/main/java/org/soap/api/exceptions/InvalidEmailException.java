/**
 * A custom exception file for handling invalid email-related errors in the DatabaseServer web service.
 */
package org.soap.api.exceptions;

import jakarta.xml.ws.WebFault;

/**
 * A custom exception class for handling invalid email-related errors in the
 * DatabaseServer web service. This exception is thrown when email-related input
 * is invalid or not found.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@WebFault
public class InvalidEmailException extends Exception {

	/**
	 * Constructs a new `InvalidEmailException` with the specified error message.
	 *
	 * @param message The error message describing the nature of the email-related
	 *                issue.
	 */
	public InvalidEmailException(String message) {
		super("InvalidEmailException: " + message);
	}
}
