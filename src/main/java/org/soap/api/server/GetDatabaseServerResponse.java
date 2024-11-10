/**
 * This file represents a response from the DatabaseServer web service, indicating success or failure.
 */
package org.soap.api.server;

import javax.xml.bind.annotation.*;

/**
 * Represents a response from the DatabaseServer web service, indicating success
 * or failure.
 *
 * @author Zac Healy
 *
 * @version 1.0
 * @since 2023-10-11
 */
@XmlRootElement(name = "getDataBaseServerResponse", namespace = "databaseServer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDataBaseServerResponse", namespace = "databaseServer")
public class GetDatabaseServerResponse {

	/**
	 * A boolean value indicating the response status. 'true' indicates success,
	 * while 'false' indicates failure.
	 */
	@XmlElement(name = "return", namespace = "")
	private boolean _return;

	/**
	 * Gets the value indicating the response status.
	 *
	 * @return 'true' if the response indicates success, 'false' if it indicates
	 *         failure.
	 */
	public boolean isReturn() {
		return this._return;
	}

	/**
	 * Sets the value indicating the response status.
	 *
	 * @param _return 'true' to indicate success, 'false' to indicate failure.
	 */
	public void setReturn(boolean _return) {
		this._return = _return;
	}
}
