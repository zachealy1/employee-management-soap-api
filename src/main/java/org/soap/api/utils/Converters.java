/**
 * This utility file provides methods for converting data types and performing data-related tasks.
 */
package org.soap.api.utils;

import databaseMember.EmploymentCategory;
import databaseMember.Sex;
import exceptions.InvalidDateException;
import exceptions.InvalidEmploymentCategoryException;
import exceptions.InvalidSexException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This utility class provides methods for converting data types and performing
 * data-related tasks.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
public class Converters {

	/**
	 * Converts a Sex enumeration value to a string.
	 *
	 * @param sex The Sex enumeration value to convert.
	 * @return The corresponding string representation of the sex.
	 */
	public static String sexToString(Sex sex) {
		if (sex.equals(Sex.MALE)) {
			return "Male";
		} else {
			return "Female";
		}
	}

	/**
	 * Converts a string to a Sex enumeration value.
	 *
	 * @param sex The string representing the sex.
	 * @return The corresponding Sex enumeration value.
	 * @throws InvalidSexException If the provided string is not a valid sex value.
	 */
	public static Sex stringToSex(String sex) throws InvalidSexException {
		if (sex.equalsIgnoreCase("Male")) {
			return Sex.MALE;
		} else if (sex.equalsIgnoreCase("Female")) {
			return Sex.FEMALE;
		} else {
			throw new InvalidSexException("""
					Error: Sex must be either:

					* Male
					* Female

					Please select a valid sex.""");
		}
	}

	/**
	 * Converts a string to a LocalDate object.
	 *
	 * @param dateOfBirth The string representing a date of birth in "yyyy-MM-dd"
	 *                    format.
	 * @return The corresponding LocalDate object.
	 * @throws InvalidDateException If the provided date of birth is not in a valid
	 *                              format.
	 */
	public static LocalDate stringToLocalDate(String dateOfBirth) throws InvalidDateException {
		if (Validators.validateRegEx(dateOfBirth, Constants.DOB_REGEX_PATTERN)) {
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
			LocalDate returnDate = LocalDate.parse(dateOfBirth, dateFormat);
			return returnDate;
		} else {
			throw new InvalidDateException("Error: Date of birth format invalid");
		}
	}

	/**
	 * Converts a string to an EmploymentCategory enumeration value.
	 *
	 * @param category The string representing the employment category.
	 * @return The corresponding EmploymentCategory enumeration value.
	 * @throws InvalidEmploymentCategoryException If the provided string is not a
	 *                                            valid employment category.
	 */
	public static EmploymentCategory stringToCategory(String category) throws InvalidEmploymentCategoryException {
		if (category.equalsIgnoreCase("Healthcare")) {
			return EmploymentCategory.HEALTHCARE;
		} else if (category.equalsIgnoreCase("Engineering & Technology")) {
			return EmploymentCategory.ENGINEERING_TECHNOLOGY;
		} else if (category.equalsIgnoreCase("Science & Research")) {
			return EmploymentCategory.SCIENCE_RESEARCH;
		} else if (category.equalsIgnoreCase("Management & Consulting")) {
			return EmploymentCategory.MANAGEMENT_CONSULTING;
		} else if (category.equalsIgnoreCase("Media & Journalism")) {
			return EmploymentCategory.MEDIA_JOURNALISM;
		} else if (category.equalsIgnoreCase("Legal")) {
			return EmploymentCategory.LEGAL;
		} else if (category.equalsIgnoreCase("Psychology & Counseling")) {
			return EmploymentCategory.PSYCHOLOGY_COUNSELING;
		} else if (category.equalsIgnoreCase("Finance")) {
			return EmploymentCategory.FINANCE;
		} else if (category.equalsIgnoreCase("History & Archaeology")) {
			return EmploymentCategory.HISTORY_ARCHEOLOGY;
		} else if (category.equalsIgnoreCase("Design & Art")) {
			return EmploymentCategory.DESIGN_ART;
		} else if (category.equalsIgnoreCase("Education")) {
			return EmploymentCategory.EDUCATION;
		} else if (category.equalsIgnoreCase("Other")) {
			return EmploymentCategory.OTHER;
		} else {
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
	}

	/**
	 * Determines the EmploymentCategory based on the provided occupation string.
	 *
	 * @param occupation The occupation string used to determine the employment
	 *                   category.
	 * @return The corresponding EmploymentCategory based on the occupation.
	 */
	public static EmploymentCategory determineCategory(String occupation) {
		occupation = occupation.toLowerCase();

		if (occupation.contains("nurse") || occupation.contains("pharmacist") || occupation.contains("phytotherapist")
				|| occupation.contains("surgeon") || occupation.contains("clinical")) {
			return EmploymentCategory.HEALTHCARE;
		} else if (occupation.contains("engineer") || occupation.contains("technician")
				|| occupation.contains("developer")) {
			return EmploymentCategory.ENGINEERING_TECHNOLOGY;
		} else if (occupation.contains("scientist") || occupation.contains("researcher")
				|| occupation.contains("hydrogeologist") || occupation.contains("Biochemist")) {
			return EmploymentCategory.SCIENCE_RESEARCH;
		} else if (occupation.contains("manager") || occupation.contains("consultant")
				|| occupation.contains("officer")) {
			return EmploymentCategory.MANAGEMENT_CONSULTING;
		} else if (occupation.contains("journalist") || occupation.contains("editor")) {
			return EmploymentCategory.MEDIA_JOURNALISM;
		} else if (occupation.contains("lawyer") || occupation.contains("barrister")
				|| occupation.contains("attorney")) {
			return EmploymentCategory.LEGAL;
		} else if (occupation.contains("psychologist") || occupation.contains("counsellor")) {
			return EmploymentCategory.PSYCHOLOGY_COUNSELING;
		} else if (occupation.contains("banker") || occupation.contains("financial")
				|| occupation.contains("accountant")) {
			return EmploymentCategory.FINANCE;
		} else if (occupation.contains("archaeologist") || occupation.contains("historian")) {
			return EmploymentCategory.HISTORY_ARCHEOLOGY;
		} else if (occupation.contains("designer") || occupation.contains("artist")) {
			return EmploymentCategory.DESIGN_ART;
		} else if (occupation.contains("teacher") || occupation.contains("lecturer")) {
			return EmploymentCategory.EDUCATION;
		} else {
			return EmploymentCategory.OTHER;
		}
	}
}
