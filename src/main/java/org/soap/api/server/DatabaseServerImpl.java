/**
 * The DatabaseServerImpl file is responsible for the implementation of the DatabaseServer interface, providing methods to access and manipulate database records.
 */
package org.soap.api.server;

import databaseMember.DatabaseMember;
import exceptions.*;
import jakarta.jws.WebService;
import utility.Constants;
import utility.Converters;
import utility.CsvReadWrite;
import utility.Validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Implementation of the DatabaseServer interface, providing methods to access
 * and manipulate database records.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@WebService(endpointInterface = "databaseServer.DatabaseServer")
public class DatabaseServerImpl implements DatabaseServer {

	/**
	 * List to store database records.
	 */
	public static ArrayList<DatabaseMember> databaseMembers = new ArrayList<>();

	/**
	 * Retrieves a DatabaseMember by their staff ID.
	 *
	 * @param staffId The staff ID of the DatabaseMember to retrieve.
	 * @return The DatabaseMember with the specified staff ID.
	 * @throws InvalidStaffIdException If the staff ID is invalid or not found.
	 */
	@Override
	public DatabaseMember getDatabaseByStaffId(String staffId) throws InvalidStaffIdException {
		for (DatabaseMember databaseMember : databaseMembers) {
			if (staffId.equals(databaseMember.getId())) {
				return databaseMember;
			}
		}
		throw new InvalidStaffIdException("Error: Staff ID not found");
	}

	/**
	 * Retrieves a list of DatabaseMembers within a specified age range.
	 *
	 * @param startDateString The start date of the age range.
	 * @param endDateString   The end date of the age range.
	 * @return A list of DatabaseMembers within the specified age range.
	 * @throws InvalidDateException If the date range is invalid or if no records
	 *                              are found within the range.
	 */
	@Override
	public ArrayList<DatabaseMember> getDatabaseWithinAgeRange(String startDateString, String endDateString)
			throws InvalidDateException {
		ArrayList<DatabaseMember> result = new ArrayList<>();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
		LocalDate startDate;
		LocalDate endDate;

		if (Validators.validateRegEx(startDateString, Constants.DOB_REGEX_PATTERN)
				&& Validators.validateRegEx(endDateString, Constants.DOB_REGEX_PATTERN)) {
			startDate = LocalDate.parse(startDateString, dateFormat);
			endDate = LocalDate.parse(endDateString, dateFormat);

			for (DatabaseMember member : databaseMembers) {
				LocalDate birthDate = Converters.stringToLocalDate(member.getDateOfBirth());
				if (birthDate.isAfter(startDate) && birthDate.isBefore(endDate) || birthDate.isEqual(startDate)
						|| birthDate.isEqual(endDate)) {
					result.add(member);
				}
			}

			if (result.isEmpty()) {
				throw new InvalidDateException("Error: Date of birth not found");
			}
		} else {
			throw new InvalidDateException("Error: Date format invalid");
		}
		return result;
	}

	/**
	 * Retrieves a list of DatabaseMembers by their employment category.
	 *
	 * @param category The employment category to filter by.
	 * @return A list of DatabaseMembers in the specified employment category.
	 * @throws InvalidEmploymentCategoryException If the employment category is
	 *                                            invalid or not found.
	 */
	@Override
	public ArrayList<DatabaseMember> getRecordByEmploymentCategory(String category)
			throws InvalidEmploymentCategoryException {
		ArrayList<DatabaseMember> result = new ArrayList<>();

		for (DatabaseMember member : databaseMembers) {
			if (Converters.stringToCategory(category).equals(member.getJobCategory())) {
				result.add(member);
			}
		}
		if (result.isEmpty()) {
			throw new InvalidEmploymentCategoryException("""
					Error: The employment category must be one of the following:

					* Healthcare
					* Engineering & Technology
					* Science & Research
					* Management & Consulting
					* Media & Journalism
					* Legal
					* Psychology & Counseling
					* Finance
					* History & Archaeology
					* Design & Art
					* Education

					Please select a valid employment category.""");
		}
		return result;
	}

	/**
	 * Retrieves a list of DatabaseMembers by their sex/gender.
	 *
	 * @param sex The sex/gender to filter by.
	 * @return A list of DatabaseMembers with the specified sex/gender.
	 * @throws InvalidSexException If the provided sex/gender is invalid or not
	 *                             found.
	 */
	public ArrayList<DatabaseMember> getDatabaseRecordBySex(String sex) throws InvalidSexException {
		ArrayList<DatabaseMember> result = new ArrayList<>();

		for (DatabaseMember member : databaseMembers) {
			if (Converters.stringToSex(sex).equals(member.getSex())) {
				result.add(member);
			}
		}
		if (result.isEmpty()) {
			throw new InvalidSexException("""
					Error: Sex must be either:

					* Male
					* Female

					Please select a valid sex.""");
		}
		return result;
	}

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
	 * @throws InvalidSexException    		If the gender/sex is invalid.
	 * @throws InvalidEmailException   		If the email address is invalid.
	 * @throws InvalidDateException    		If the date of birth is in an invalid format.
	 * @throws InvalidPhoneNumberException 	If the phone number is in an invalid format.
	 */
	@Override
	public String createNewDatabaseRecord(String id, String firstName, String lastName, String sex, String email,
			String phoneNumber, String dateOfBirth, String employmentType)
			throws InvalidStaffIdException, InvalidSexException, InvalidEmailException, InvalidDateException, InvalidPhoneNumberException {
		DatabaseMember dataBaseMember = new DatabaseMember(databaseMembers.size() + 1, id, firstName, lastName, sex,
					email, phoneNumber, dateOfBirth, employmentType);
		CsvReadWrite.writeDataToCSV(Constants.FILE_PATH, dataBaseMember);
		return "Record added successfully";
	}
}
