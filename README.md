# Manufacturer Search API

## Overview

The Manufacturer Search API is designed to allow users to search for manufacturers based on various criteria such as scale, location, manufacturing process, and onboarding platform. Users can pass queries in natural language format, and the API will parse these queries using regular expressions to extract relevant filters and return a list of matching manufacturers.

## Features

- **Natural Language Query**: Users can input queries like "give all medium scale manufacturers in Chicago who do molding."
- **Filter Extraction**: The API uses Regex to extract filters from the given query.
- **Custom Exceptions**: Implemented for handling specific error conditions with meaningful responses.
- **General Exception Handling**: Catches unexpected errors and provides a standardized error response.
- **Security Best Practices**: Incorporated to protect sensitive user data and prevent vulnerabilities.

## Project Structure

- **Services**: Contains business logic for processing queries and returning results.
  - `ManufacturerService.java`: Core service that processes the query object and fetches the list of manufacturers.
  - `QueryParserService.java`: Service that parses the string query using Regex and creates a query object.
  
- **Controller**: Manages incoming requests and responses.
  - `ManufacturerController.java`: Handles API endpoints for searching manufacturers and returns results or errors.

- **Exception Handling**: Manages application errors and returns appropriate HTTP status codes.
  - `CustomException.java`: Custom exception class for handling specific application errors.
  - `GlobalExceptionHandler.java`: Centralized exception handler using `@ControllerAdvice`.

- **Test Files**: Contains unit tests for the services and controller to ensure correct functionality.
  - `ManufacturerServiceTest.java`
  - `ManufacturerControllerTest.java`

- **Dummy Dataset**: Generates a list of manufacturers for testing purposes.
  - `ManufacturerDataGenerator.java`: Creates a dummy dataset for the API.

## How It Works

### 1. Query Parsing
The query passed by the user (e.g., "give all medium scale manufacturers in Chicago who do molding") is processed by the `QueryParserService`. The service uses regular expressions to extract filters such as scale, location, and manufacturing process.

### 2. Query Object Creation
The extracted filters are used to create a `QueryObject` that represents the search criteria.

### 3. Manufacturer Retrieval
The `QueryObject` is passed to the `ManufacturerService`'s `getManufacturer` method, which returns a list of manufacturers matching the criteria.

### 4. Exception Handling
- **Custom Exceptions**: Specific errors related to query parsing or data retrieval result in custom exceptions.
- **General Exceptions**: Any unhandled exceptions are caught by the global handler and return a generic error response.

## Security Best Practices

To ensure the security of the API and protect sensitive data, the following practices have been implemented:

- **Input Validation**: All input queries are validated to prevent injection attacks.
- **Exception Handling**: Proper exception handling ensures that sensitive information is not exposed in error messages.
- **Data Encryption**: Sensitive data is encrypted both in transit (using HTTPS) and at rest.
- **Authentication & Authorization**: Implementing JWT tokens for user authentication and role-based access control to restrict access to certain endpoints.
- **Logging & Monitoring**: All API requests and responses are logged for monitoring and auditing purposes. Sensitive data in logs is masked.
- **Rate Limiting**: To prevent abuse, rate limiting is applied to API endpoints.

## Getting Started

### Prerequisites

- Java 11+
- Maven

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/PrakharIITB/Spring-boot-api
  ```bash

