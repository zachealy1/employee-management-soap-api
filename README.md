# Employee Management SOAP API

This project is a **SOAP API** designed to manage and interact with a database of members, providing functionalities to handle user information, employment categories, and related validations. The application follows the Maven project structure and organises code into distinct packages for better maintainability and readability.

## Table of Contents
- [Project Overview](#project-overview)
- [Installation](#installation)
- [Usage](#usage)
- [Packages](#packages)

## Project Overview

This SOAP API project facilitates operations on a member database. It includes modules for:
- Managing user information and employment categories.
- Implementing SOAP-based requests and responses.
- Handling custom exceptions and validation processes.

The API can be deployed on a web service and is suitable for applications that require secure data transactions and robust member management functionalities.

### Key Files

- `DatabaseServer.java`: Main interface for the SOAP API service.
- `DatabaseServerImpl.java`: Implementation of the SOAP API.
- `DatabaseMember.java`: Model for member entities.
- `Constants.java`, `Validators.java`, `Converters.java`: Utility classes for data management.

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/yourrepository.git
    ``` 

2. Navigate to the project directory:

    ```bash
    cd yourrepository
    ```

3. Compile the project using Maven:

    ```bash
    mvn clean install
    ```

4. Deploy the SOAP API to a web server (e.g., Apache Tomcat) to make the service available for client applications.

## Usage

After deploying the API, you can access the WSDL (Web Services Description Language) for the SOAP API, which describes the available endpoints and operations.

**Example Endpoints:**

- **addMember:** Adds a new member to the database.
- **updateMember:** Updates member details.
- **getMember:** Retrieves member information based on criteria.


Use any SOAP client (like SOAP UI) to test API requests and responses according to the WSDL.

## Packages

- **exceptions:** Custom exceptions to handle invalid inputs and error scenarios.
- **main:** Main application class to run the SOAP API service.
- **models:** Entity classes representing various data types (e.g., DatabaseMember, EmploymentCategory).
- **server:** Classes implementing the SOAP API server and handling SOAP requests.
- **utils:** Utility classes for data conversion, validation, and file handling.

