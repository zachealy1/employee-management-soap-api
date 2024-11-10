/**
 * The DatabaseServer file defines the interface and methods that can be called on the database.
 */
package org.soap.api.server;


import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import org.soap.api.exceptions.*;
import org.soap.api.models.DatabaseMember;

import java.util.ArrayList;

/**
 * The DatabaseServer interface defines the methods that can be called on the
 * database.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface DatabaseServer {

	/**
	 * Retrieves a DatabaseMember by their staff ID.
	 *
	 * @param staffId The staff ID of the DatabaseMember to retrieve.
	 * @return The DatabaseMember with the specified staff ID.
	 * @throws InvalidStaffIdException If the staff ID is invalid or not found.
	 */
	@WebMethod
	DatabaseMember getDatabaseByStaffId(@WebParam(name = "staffId") String staffId) throws InvalidStaffIdException;

	/**
	 * Retrieves a list of DatabaseMembers within a specified age range.
	 *
	 * @param startDate The start date of the age range.
	 * @param endDate   The end date of the age range.
	 * @return A list of DatabaseMembers within the specified age range.
	 * @throws InvalidDateException If the date range is invalid or if no records
	 *                              are found within the range.
	 */
	@WebMethod
	ArrayList<DatabaseMember> getDatabaseWithinAgeRange(@WebParam(name = "startDate") String startDate,
			@WebParam(name = "endDate") String endDate) throws InvalidDateException;

	/**
	 * Retrieves a list of DatabaseMembers by their employment category.
	 *
	 * @param category The employment category to filter by.
	 * @return A list of DatabaseMembers in the specified employment category.
	 * @throws InvalidEmploymentCategoryException If the employment category is
	 *                                            invalid or not found.
	 */
	@WebMethod
	ArrayList<DatabaseMember> getRecordByEmploymentCategory(@WebParam(name = "category") String category)
			throws InvalidEmploymentCategoryException;

	/**
	 * Retrieves a list of DatabaseMembers by their sex/gender.
	 *
	 * @param sex The sex/gender to filter by.
	 * @return A list of DatabaseMembers with the specified sex/gender.
	 * @throws InvalidSexException If the provided sex/gender is invalid or not
	 *                             found.
	 */
	@WebMethod
	ArrayList<DatabaseMember> getDatabaseRecordBySex(@WebParam(name = "sex") String sex) throws InvalidSexException;

	/**
	 * Creates a new DatabaseMember record with the provided information.
	 *
	 * @param id             The staff ID of the new DatabaseMember.
	 * @param firstName      The first name of the new DatabaseMember.
	 * @param lastName       The last name of the new DatabaseMember.
	 * @param sex            The gender/sex of the new DatabaseMember.
	 * @param email          The email address of the new DatabaseMember.
	 * @param phoneNumber    The phone number of the new DatabaseMember.
	 * @param dateOfBirth    The date of birth of the new DatabaseMember.
	 * @param employmentType The job title or employment type of the new
	 *                       DatabaseMember.
	 * @throws InvalidStaffIdException 		If the staff ID is invalid.
	 * @throws InvalidSexException     		If the gender/sex is invalid.
	 * @throws InvalidEmailException   		If the email address is invalid.
	 * @throws InvalidDateException    		If the date of birth is in an invalid format.
	 * @throws InvalidPhoneNumberException  If the phone number is in an invalid format.
	 */
	@WebMethod
	String createNewDatabaseRecord(@WebParam(name = "id") String id, @WebParam(name = "firstName") String firstName,
			@WebParam(name = "lastName") String lastName, @WebParam(name = "sex") String sex,
			@WebParam(name = "email") String email, @WebParam(name = "phoneNumber") String phoneNumber,
			@WebParam(name = "dateOfBirth") String dateOfBirth,
			@WebParam(name = "employmentType") String employmentType)
			throws InvalidStaffIdException, InvalidSexException, InvalidEmailException, InvalidDateException, InvalidPhoneNumberException;

}
