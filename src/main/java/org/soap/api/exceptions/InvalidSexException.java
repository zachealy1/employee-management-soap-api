/**
 * A custom exception file for handling invalid sex-related errors in the DatabaseServer web service.
 */
package org.soap.api.exceptions;

import jakarta.xml.ws.WebFault;

/**
 * A custom exception class for handling invalid sex-related errors in the
 * DatabaseServer web service. This exception is thrown when sex-related input
 * is invalid or not found.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@WebFault
public class InvalidSexException extends Exception {

	/**
	 * Constructs a new `InvalidSexException` with the specified error message.
	 *
	 * @param message The error message describing the nature of the sex-related
	 *                issue.
	 */
	public InvalidSexException(String message) {
		super("InvalidSexException: " + message);
	}
}

