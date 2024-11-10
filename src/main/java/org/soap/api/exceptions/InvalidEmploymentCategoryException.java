/**
 * A custom exception file for handling invalid employment category-related errors in the DatabaseServer web service.
 */
package org.soap.api.exceptions;

import jakarta.xml.ws.WebFault;

/**
 * A custom exception class for handling invalid employment category-related
 * errors in the DatabaseServer web service. This exception is thrown when
 * employment category-related input is invalid or not found.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@WebFault
public class InvalidEmploymentCategoryException extends Exception {

	/**
	 * Constructs a new `InvalidEmploymentCategoryException` with the specified
	 * error message.
	 *
	 * @param message The error message describing the nature of the employment
	 *                category-related issue.
	 */
	public InvalidEmploymentCategoryException(String message) {
		super("InvalidEmploymentCategoryException: " + message);
	}
}