/**
 * This utility class provides methods for reading data from a CSV file and writing data to a CSV file.
 */
package org.soap.api.utils;


import org.soap.api.exceptions.*;
import org.soap.api.models.DatabaseMember;
import org.soap.api.server.DatabaseServerImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This utility class provides methods for reading data from a CSV file and
 * writing data to a CSV file.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
public class CsvReadWrite {

	/**
	 * Appends the provided DatabaseMember data to the specified CSV file.
	 *
	 * @param fileName       The name of the CSV file to write data to.
	 * @param dataBaseMember The DatabaseMember object containing data to write to
	 *                       the CSV file.
	 */
	public static void writeDataToCSV(String fileName, DatabaseMember dataBaseMember) {
		try (FileWriter fileWriter = new FileWriter(fileName, true)) {

			fileWriter.append(String.valueOf(dataBaseMember.getIndex())).append(Constants.DELIMITER);
			fileWriter.append(dataBaseMember.getId()).append(Constants.DELIMITER);
			fileWriter.append(dataBaseMember.getFirstName()).append(Constants.DELIMITER);
			fileWriter.append(dataBaseMember.getLastName()).append(Constants.DELIMITER);
			fileWriter.append(Converters.sexToString(dataBaseMember.getSex())).append(Constants.DELIMITER);
			fileWriter.append(dataBaseMember.getEmail()).append(Constants.DELIMITER);
			fileWriter.append(dataBaseMember.getPhoneNumber()).append(Constants.DELIMITER);
			fileWriter.append(dataBaseMember.getDateOfBirth()).append(Constants.DELIMITER);
			fileWriter.append(dataBaseMember.getJobTitle()).append(Constants.DELIMITER);
			fileWriter.append("\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		DatabaseServerImpl.databaseMembers = CsvReadWrite.readDataFromCSV(Constants.FILE_PATH);
	}

	/**
	 * Reads data from the specified CSV file and returns it as a list of
	 * DatabaseMember objects.
	 *
	 * @param fileName The name of the CSV file to read data from.
	 * @return An ArrayList of DatabaseMember objects containing data read from the
	 *         CSV file.
	 * @throws RuntimeException if there are errors in reading and parsing the data
	 *                          from the CSV file.
	 */
	public static ArrayList<DatabaseMember> readDataFromCSV(String fileName) {
		ArrayList<DatabaseMember> databaseMembers = new ArrayList<>();
		File file = new File(fileName);
		try (Scanner fileReader = new Scanner(file)) {

			fileReader.useDelimiter(",");
			fileReader.nextLine();
			while (fileReader.hasNext()) {
				DatabaseMember dataBaseMember = new DatabaseMember(fileReader.nextInt(), fileReader.next(),
						fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),
						fileReader.next(), fileReader.nextLine().replaceFirst(",", ""));
				databaseMembers.add(dataBaseMember);
			}
		} catch (InvalidStaffIdException | FileNotFoundException | InvalidSexException | InvalidEmailException
				 | InvalidDateException | InvalidPhoneNumberException e) {
			throw new RuntimeException(e);
		}
		return databaseMembers;
	}
}
