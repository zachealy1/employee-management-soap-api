/**
 * This file is responsible for publishing the DatabaseServer as a web service using JAX-WS Endpoint.
 */
package org.soap.api.server;

import jakarta.xml.ws.Endpoint;
import utility.Constants;
import utility.CsvReadWrite;

/**
 * This class is responsible for publishing the DatabaseServer as a web service
 * using JAX-WS Endpoint.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
public class DatabaseServerPublisher {

	/**
	 * The main method that initialises the database members, creates and publishes
	 * the web service endpoint.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		// Initialise the database members by reading data from a CSV file.
		DatabaseServerImpl.databaseMembers = CsvReadWrite.readDataFromCSV(Constants.FILE_PATH);

		// Create a new web service endpoint using the DatabaseServerImpl
		// implementation.
		Endpoint ep = Endpoint.create(new DatabaseServerImpl());

		// Publish the web service at the specified URL.
		ep.publish("http://localhost:7777/190931/people");
	}
}
