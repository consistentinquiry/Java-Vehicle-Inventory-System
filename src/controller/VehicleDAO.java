package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

import models.Vehicle;

public class VehicleDAO {

	private static Connection getDBConnection() {
		/**
		 * Makes and returns a connection to the vehicle database.
		 * 
		 * @return Instance of the Connection class for vehicle database
		 */
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String dbURL = "jdbc:sqlite:vehicles.sqlite";
			System.out.println("Connecting to database...");
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	public ArrayList<Vehicle> getAllVehicles() throws SQLException {
		/**
		 * Makes and returns an arrayList containing vehicle objects (all vehicles in
		 * 'vehicles' table)
		 * 
		 * @param None
		 * @return ArrayList
		 **/
		System.out.println("Retrieving all vehicles ...");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM vehicles";
		Vehicle temp = null;
		ArrayList<Vehicle> vehicleList = new ArrayList<>();

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query);
			result = statement.executeQuery(query); // Execute SQL query and record response to string
			while (result.next()) {

				int vehicle_id = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");
				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");
				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");

				vehicleList.add(new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes));
				
			}
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return vehicleList;		
	}

	public Vehicle searchForVehicle(int IDSearch) throws SQLException {
		/**
		 * Makes and returns an arrayList containing vehicle objects
		 * 
		 * @param IDSearch
		 * @return Vehicle
		 **/
		System.out.println("Searching vehicles table ...");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM vehicles WHERE vehicle_id = " + IDSearch;
		Vehicle RetrievedVehicle = new Vehicle();
		

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query);
			result = statement.executeQuery(query); // Execute SQL query and record response to string
			
			while (result.next()) {

				int vehicle_id = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");
				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");
				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");

				RetrievedVehicle.setVehicle_id(vehicle_id);
				RetrievedVehicle.setMake(make);
				RetrievedVehicle.setModel(model);
				RetrievedVehicle.setYear(year);
				RetrievedVehicle.setPrice(price);
				RetrievedVehicle.setLicense_number(license_number);
				RetrievedVehicle.setColour(colour);
				RetrievedVehicle.setNumber_doors(number_doors);
				RetrievedVehicle.setTransmission(transmission);
				RetrievedVehicle.setMileage(mileage);
				RetrievedVehicle.setFuel_type(fuel_type);
				RetrievedVehicle.setEngine_size(engine_size);
				RetrievedVehicle.setBody_style(body_style);
				RetrievedVehicle.setCondition(condition);
				RetrievedVehicle.setNotes(notes);
				
				
			}
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				System.out.println("Closing connection...");
				dbConnection.close();
			}
		}
		return RetrievedVehicle;
	}

	public boolean insertNewVehicle(Vehicle vehicleObj) throws SQLException {
		/**
		 * Makes a connection to the database and retrieves the properties of the vehicle object 
		 * which are stored in variables. These variables are used to format a string which is used as the query.
		 * Connection is then closed.
		 * 
		 * @param vehicleObj
		 * @return insertionSuccess
		 */

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		
		boolean insertionSuccess = false;
		
		// declare and assign variables by using the vehicle instance get methods
		String make = vehicleObj.getMake();
		String model = vehicleObj.getModel();
		int year = vehicleObj.getYear();
		int price = vehicleObj.getPrice();
		String license_number = vehicleObj.getLicense_number();
		String colour = vehicleObj.getColour();
		int number_doors = vehicleObj.getNumber_doors();
		String transmission = vehicleObj.getTransmission();
		int mileage = vehicleObj.getMileage();
		String fuel_type = vehicleObj.getFuel_type();
		int engine_size = vehicleObj.getEngine_size();
		String body_style = vehicleObj.getBody_style();
		String condition = vehicleObj.getCondition();
		String Notes = vehicleObj.getNotes();

		// create and format the string which will be used as SQL query
		String query = "INSERT INTO vehicles (make, model, year, price, license_number, colour, "
				+ "number_doors, transmission, mileage, fuel_type, engine_size, body_style, condition, Notes)"
				+ "VALUES (" + "'" + make + "'" + "," + "'" + model + "'" + "," + year + "," + price + "," + "'"
				+ license_number + "'" + "," + "'" + colour + "'" + "," + number_doors + "," + "'" + transmission + "'"
				+ "," + mileage + "," + "'" + fuel_type + "'" + "," + engine_size + "," + "'" + body_style + "'" + ","
				+ "'" + condition + "'" + "," + "'" + Notes + "'" + ");";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query);
			statement.executeUpdate(query); // Execute SQL query and record response to string
			insertionSuccess = true;

		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return insertionSuccess;
	}

	public boolean deleteVehicle(int vehicle_id) throws SQLException {
		/**
		 *  Makes a connection to the database and uses the id supplied as a parameter 
		 *  to format the string used as the query.
		 *  
		 *  @param vehicle_id
		 *  @return deletionSuccess
		 */

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		
		boolean deletionSuccess = false;
		
		// create and format the string which will be used as SQL DELETE query
		String query = "DELETE FROM vehicles WHERE vehicle_id =  +" + vehicle_id;
		;
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query);
			statement.executeUpdate(query); // Execute SQL query and record response to string
			deletionSuccess = true;

		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return deletionSuccess;
	}

	public boolean updateVehicle(Vehicle vehicleObj, int vehicleID) throws SQLException {
		/**
		 *  Makes a connection to the database and retrieves the properties of the vehicle
		 *  instance supplied as a parameter. These properties are used to update the rows in the record.
		 *  The correct record is found by using the WHERE part of the sql query which is formatted using 
		 *  the ID provided by the second parameter. 
		 *  
		 *  @param vehicleObj, vehicleID
		 *  @return updateSuccess
		 */
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		
		boolean updateSuccess = false;
		
		String query = "UPDATE vehicles" + " SET " + "make = " + "'" + vehicleObj.getMake() + "'" + ", " + "model = "
				+ "'" + vehicleObj.getModel() + "'" + ", " + "year = " + vehicleObj.getYear() + ", " + "price = "
				+ vehicleObj.getPrice() + ", " + "license_number = " + "'" + vehicleObj.getLicense_number() + "'" + ", "
				+ "colour = " + "'" + vehicleObj.getColour() + "'" + ", " + "number_doors = "
				+ vehicleObj.getNumber_doors() + ", " + "transmission = " + "'" + vehicleObj.getTransmission() + "'"
				+ ", " + "mileage = " + vehicleObj.getMileage() + ", " + "fuel_type = " + "'"
				+ vehicleObj.getFuel_type() + "'" + ", " + "engine_size = " + vehicleObj.getEngine_size() + ", "
				+ "body_style =" + "'" + vehicleObj.getBody_style() + "'" + ", " + "condition =" + "'"
				+ vehicleObj.getCondition() + "'" + ", " + "Notes =" + "'" + vehicleObj.getNotes() + "'"
				+ " WHERE vehicle_id = " + vehicleID;
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query);
			statement.executeUpdate(query); // Execute SQL query and record response to string
			System.out.println("Record successfully updated!");
			updateSuccess = true;

		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return updateSuccess;
	}

	public boolean loginVarification(String username, String passwordHash) throws SQLException {
		/**
		 * Verifies user credentials by using the username parameter to retrieve the corrisponding 
		 * stored password hash. This retrieved hash is compared against the one that is supplied.
		 *  
		 * 
		 * @param username, passwordHash
		 * @return loginVerfied 
		 **/
		System.out.println("Checking login credentials...");
		boolean loginVerified = false;
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT password FROM users WHERE username = "+ "'"+ username+"'";
		Vehicle temp = null;
		
		try {
			String retreivedPassword = null;
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query);
			result = statement.executeQuery(query); // Execute SQL query and record response to string
			while (result.next()) 
			{
				retreivedPassword = result.getString("password");
			}
			if (Objects.equals(retreivedPassword, passwordHash)==true) //comparision of the supplied hash against the one retrieved from the database.
			{
				loginVerified = true;
			}
		}
		finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				System.out.println("Closing connection...");
				dbConnection.close();
			}
		}
		return loginVerified;
	}
}
