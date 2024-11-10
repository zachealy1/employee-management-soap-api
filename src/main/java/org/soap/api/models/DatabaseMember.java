/**
 * The databaseMember file is responsible for representing a person stored in the database.
 */

package org.soap.api.models;

import jakarta.xml.bind.annotation.*;
import org.soap.api.exceptions.*;
import org.soap.api.utils.Constants;
import org.soap.api.utils.Converters;
import org.soap.api.utils.Validators;


/**
 * The databaseMember class is responsible for representing a person stored in
 * the database.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@XmlRootElement(name = "DataBaseMember", namespace = "http://databaseServer/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataBaseMember", namespace = "http://databaseServer/")
public class DatabaseMember {
	
	private int index; // Index: The position or identifier of the DatabaseMember within a data
						// collection.

	@XmlAttribute(name = "ID")
	private String id; // ID: A unique identifier for the DatabaseMember.

	@XmlElement(name = "FIRSTNAME")
	private String firstName; // FIRSTNAME: The first name of the DatabaseMember.

	@XmlElement(name = "LASTNAME")
	private String lastName; // LASTNAME: The last name of the DatabaseMember.

	@XmlElement(name = "SEX")
	private Sex sex; // SEX: The gender or sex of the DatabaseMember.

	@XmlElement(name = "EMAIL")
	private String email; // EMAIL: The email address of the DatabaseMember.

	@XmlElement(name = "PHONE NUMBER")
	private String phoneNumber; // PHONE NUMBER: The phone number of the DatabaseMember.

	@XmlElement(name = "DATE OF BIRTH")
	private String dateOfBirth; // DATE OF BIRTH: The birthdate of the DatabaseMember.

	@XmlElement(name = "JOB TITLE")
	private String jobTitle; // JOB TITLE: The job title or employment type of the DatabaseMember.

	@XmlElement(name = "JOB CATEGORY")
	private EmploymentCategory jobCategory; // JOB CATEGORY: The category or type of employment or job of the
											// DatabaseMember.

	/**
	 * Default constructor for the DatabaseMember class.
	 */
	public DatabaseMember() {

	}

	/**
	 * Constructor for the DatabaseMember class that initializes its attributes with
	 * the provided values.
	 *
	 * @param index          The index of the member.
	 * @param id             The unique identifier of the member.
	 * @param firstName      The first name of the member.
	 * @param lastName       The last name of the member.
	 * @param sex            The gender of the member.
	 * @param email          The email address of the member.
	 * @param phoneNumber    The phone number of the member.
	 * @param dateOfBirth    The date of birth of the member.
	 * @param employmentType The job title or employment type of the member.
	 * @throws InvalidStaffIdException 		If the staff ID is invalid.
	 * @throws InvalidSexException     		If the gender is invalid.
	 * @throws InvalidEmailException   		If the email address is invalid.
	 * @throws InvalidDateException    		If the date of birth is in an invalid format.
	 * @throws InvalidPhoneNumberException	If the phone number is in an invalid format.
	 */
	public DatabaseMember(int index, String id, String firstName, String lastName, String sex, String email,
			String phoneNumber, String dateOfBirth, String employmentType)
			throws InvalidStaffIdException, InvalidSexException, InvalidEmailException, InvalidDateException, InvalidPhoneNumberException {
		this.setIndex(index);
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSex(Converters.stringToSex(sex));
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setDateOfBirth(dateOfBirth);
		this.setJobTitle(employmentType);
		this.setJobCategory(Converters.determineCategory(employmentType));
	}

	/**
	 * Gets the index of the DatabaseMember.
	 *
	 * @return The index of the DatabaseMember.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index of the DatabaseMember.
	 *
	 * @param index The new index to be set.
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Gets the unique identifier (ID) of the DatabaseMember.
	 *
	 * @return The unique identifier of the DatabaseMember.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the unique identifier (ID) of the DatabaseMember.
	 *
	 * @param id The new unique identifier to be set.
	 * @throws InvalidStaffIdException If the provided staff ID is invalid.
	 */
	public void setId(String id) throws InvalidStaffIdException {
		if (Validators.validateIdLength(id) && Validators.validateRegEx(id, Constants.ID_REGEX_PATTERN)) {
			this.id = id;
		} else {
			throw new InvalidStaffIdException("Error: Staff ID invalid. Staff ID must be 15 characters long.");
		}
	}

	/**
	 * Gets the first name of the DatabaseMember.
	 *
	 * @return The first name of the DatabaseMember.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the DatabaseMember.
	 *
	 * @param firstName The new first name to be set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the DatabaseMember.
	 *
	 * @return The last name of the DatabaseMember.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the DatabaseMember.
	 *
	 * @param lastName The new last name to be set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the gender (sex) of the DatabaseMember.
	 *
	 * @return The gender of the DatabaseMember.
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * Sets the gender (sex) of the DatabaseMember.
	 *
	 * @param sex The new gender (sex) to be set.
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * Gets the email address of the DatabaseMember.
	 *
	 * @return The email address of the DatabaseMember.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the DatabaseMember. Checks if the email provided is
	 * in a valid format.
	 *
	 * @param email The new email address to be set.
	 * @throws InvalidEmailException If the provided email address is invalid.
	 */
	public void setEmail(String email) throws InvalidEmailException {
		if (Validators.validateRegEx(email, Constants.EMAIL_REGEX_PATTERN)) {
			this.email = email;
		} else {
			throw new InvalidEmailException("Error: Email format invalid");
		}
	}

	/**
	 * Gets the phone number of the DatabaseMember.
	 *
	 * @return The phone number of the DatabaseMember.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number of the DatabaseMember.
	 *
	 * @param phoneNumber The new phone number to be set.
	 * @throws InvalidPhoneNumberException If the phone number is in an invalid format.
	 */
	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if (Validators.validateRegEx(phoneNumber, Constants.PHONE_NUMBER_REGEX_PATTERN)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new InvalidPhoneNumberException("Error: Phone number format invalid");
		}
	}

	/**
	 * Gets the date of birth of the DatabaseMember.
	 *
	 * @return The date of birth of the DatabaseMember.
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth of the DatabaseMember. Checks if the date of birth
	 * provided is in a valid format.
	 *
	 * @param dateOfBirth The new date of birth to be set.
	 * @throws InvalidDateException If the provided date of birth is in an invalid
	 *                              format.
	 */
	public void setDateOfBirth(String dateOfBirth) throws InvalidDateException {
		if (Validators.validateRegEx(dateOfBirth, Constants.DOB_REGEX_PATTERN)) {
			this.dateOfBirth = dateOfBirth;
		} else {
			throw new InvalidDateException("Error: Date format invalid");
		}
	}

	/**
	 * Gets the job title or employment type of the DatabaseMember.
	 *
	 * @return The job title or employment type of the DatabaseMember.
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * Sets the job title or employment type of the DatabaseMember.
	 *
	 * @param jobTitle The new job title or employment type to be set.
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * Gets the job category of the DatabaseMember.
	 *
	 * @return The job category of the DatabaseMember.
	 */
	public EmploymentCategory getJobCategory() {
		return jobCategory;
	}

	/**
	 * Sets the job category of the DatabaseMember.
	 *
	 * @param jobCategory The new job category to be set.
	 */
	public void setJobCategory(EmploymentCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	/**
	 * Generates a string representation of the DatabaseMember object.
	 *
	 * @return A string containing the attributes of the DatabaseMember object.
	 */
	@Override
	public String toString() {
		return "DatabaseMember{" + "index=" + index + ", id='" + id + '\'' + ", firstName='" + firstName + '\''
				+ ", lastName='" + lastName + '\'' + ", sex='" + sex + '\'' + ", email='" + email + '\''
				+ ", phoneNumber='" + phoneNumber + '\'' + ", dateOfBirth='" + dateOfBirth + '\'' + ", jobTitle='"
				+ jobTitle + '\'' + '}';
	}
}
