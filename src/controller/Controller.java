package controller;
/**
 * Controls the functionality of the console interface, allowing the user to
 * call the CRUD methods of the DAO. Also provides
 * the means to initialise the Jetty web server for CRUD method usage via a web browser.
 * 
 * @author John Sharkey
 * @version 1.0
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.VehicleDAO;

import models.Vehicle;

public class Controller {
	
	
	public static void main(String[] args) throws Exception
	{
		/**
		 * Calls the main menu
		 * @exception  
		 */
		mainMenu();
	}
	
	public static void mainMenu() throws Exception
	{
		/**
		 * Prints the options for accessing CRUD methods to the console.
		 * Also provides means of selecting desired method via switch statement.
		 */
			Scanner input = new Scanner(System.in);
			VehicleDAO vehicleDAO = new VehicleDAO();
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("         Vehicle - Inventory - System           ");
			System.out.println("                                                ");
			System.out.println("1. Retrieve all vehicles                        ");
			System.out.println("2. Search for vehicle                           ");
			System.out.println("3. Insert new vehicle into database             ");
			System.out.println("4. Update existing vehicle details              ");
			System.out.println("5. Delete vehicle from database                 ");
			System.out.println("6. Exit                                         ");
			System.out.println("7. Start web server                             ");
			System.out.println("                                                ");
			System.out.println("Enter choice:                                   ");
			int choice = input.nextInt();
			switch(choice)
			{
			case 1: choice = 1;
					break;
			case 2: choice = 2;
					break;
			case 3: choice = 3;
					break;
			case 4: choice = 4;
					break;
			case 5: choice = 5;
					break;
			case 6: choice = 6;
					break;
			case 7: choice = 7;
					break;
			}
			if(choice == 1)
			{
				retrieveAllVehicles(vehicleDAO);
			}
			if(choice == 2)
			{
				searchForVehicle(vehicleDAO, input);
			}
			if(choice == 3)
			{
				insertNewVehicle(vehicleDAO, input);
			}
			if(choice == 4)
			{
				updateVehicle(vehicleDAO, input);
			}
			if(choice == 5)
			{
				deleteVehicle(vehicleDAO, input);
			}
			if(choice == 6)
			{
				exit();
			}
			if(choice == 7)
			{
				startWebServer();
			}
	}
	
	public static void retrieveAllVehicles(VehicleDAO vehicleDAO) throws Exception
	{
		/*
		 * Calls the DAO getAllVehicles method and stores the result in 
		 * the allVehicles arrayList object. This is then iterated over
		 * to display the properties of each vehicle.
		 * 
		 * @param vehicleDAO 
		 */
		ArrayList<Vehicle> allVehicles = null;
		allVehicles = vehicleDAO.getAllVehicles();
		for(Vehicle v : allVehicles)
		{
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| ID: "+v.getVehicle_id() + " |Make: "+v.getMake() +" |Model: "+v.getModel() +" |Year: "+v.getYear() +
					           " |Price: "+v.getPrice() +" |License number: "+v.getLicense_number() +" |Colour: "+ v.getColour() +" |Number of doors: "+ v.getNumber_doors() +
					           " |Transmission: "+ v.getTransmission() +" |Mileage: "+ v.getMileage() +" |Fuel type: "+ v.getFuel_type() +
					           " |Engine size: "+v.getEngine_size() + " |Body size: "+v.getBody_style() +" |Condition: "+ v.getCondition() +" |Notes: "+ v.getNotes() + " |");
		}
		mainMenu();
	}
	
	public static void searchForVehicle(VehicleDAO vehicleDAO, Scanner input ) throws Exception
	{
		/**
		 * Calls the DAO searchForVehicle method and stores the result in a vehicle 
		 * instance. The get methods are used to display the vehicle properties in the console.
		 * 
		 * @param vehicleDAO, input
		 */
		System.out.println("Enter vehicle ID: ");
		int IDSearch = input.nextInt();
		System.out.println("Searching...");
		Vehicle AVehicle = new Vehicle();
		AVehicle = vehicleDAO.searchForVehicle(IDSearch);
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| ID: "+AVehicle.getVehicle_id() + " |Make: "+AVehicle.getMake() +" |Model: "+AVehicle.getModel() +" |Year: "+AVehicle.getYear() +
					           " |Price: "+AVehicle.getPrice() +" |License number: "+AVehicle.getLicense_number() +" |Colour: "+ AVehicle.getColour() +" |Number of doors: "+ AVehicle.getNumber_doors() +
					           " |Transmission: "+ AVehicle.getTransmission() +" |Mileage: "+ AVehicle.getMileage() +" |Fuel type: "+ AVehicle.getFuel_type() +
					           " |Engine size: "+AVehicle.getEngine_size() + " |Body size: "+AVehicle.getBody_style() +" |Condition: "+ AVehicle.getCondition() +" |Notes: "+ AVehicle.getNotes() + " |");
		
		mainMenu();
		
	}
	
	public static void insertNewVehicle(VehicleDAO vehicleDAO, Scanner input) throws Exception
	{
		/**
		 * Takes the inputs supplied by the user and uses them to create a new vehicle instance. 
		 * This object is used as a parameter when calling the DAO insertNewVehicle method
		 * 
		 * @param vehicleDAO, input
		 */
		System.out.println("Enter car details...");
		System.out.println("Enter make: ");
		String make = input.nextLine();
		
		System.out.println("Enter model: ");
		String model = input.nextLine();
		
		System.out.println("Enter year: ");
		int year = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter price: ");
		int price = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter license number: ");
		String license_number = input.nextLine();
		
		System.out.println("Enter colour: ");
		String colour = input.nextLine();
		
		System.out.println("Enter number of doors: ");
		int number_doors = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter transmission (Manual / Automatic ): ");
		String transmission = input.nextLine();
		
		System.out.println("Enter mileage: ");
		int mileage = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter fuel type(Petrol or Diesel ): ");
		String fuel_type = input.nextLine();
		
		System.out.println("Enter engine size: ");
		int engine_size = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter body style: ");
		String body_style = input.nextLine();
		
		System.out.println("Enter condition: ");
		String condition = input.nextLine();
		
		System.out.println("Enter notes: ");
		String Notes = input.nextLine();
		
		Vehicle vehicleObj = new Vehicle(make, model, year, price, license_number, 
										colour, number_doors, transmission, mileage, 
										fuel_type, engine_size, body_style, condition , Notes);
		
		if(vehicleDAO.insertNewVehicle(vehicleObj))      //if DAO insertNewVehicle method returns true...
		{
			System.out.println("Vehicle successfully inserted!");
		}
		mainMenu();
		
	}
	
	public static void deleteVehicle(VehicleDAO vehicleDAO, Scanner input) throws Exception
	{
		/**
		 * Gathers an ID based on user input and uses said ID as a parameter to the DAO delete vehicle method
		 * 
		 *  @param vehicleDAO, input
		 */
		System.out.println("Enter vehicle id to delete:");
		int vehicle_id = input.nextInt();
		if(vehicleDAO.deleteVehicle(vehicle_id) == true)
		{
			System.out.println("Vehicle deleted successfully!");
		}
		mainMenu();
		
	}
	
	public static void updateVehicle(VehicleDAO vehicleDAO, Scanner input) throws Exception
	{
		/**
		 * A search returns and prints the desired vehicle details to console. 
		 * The updated details are assigned to the relevant variables which are then 
		 * used to create a vehicle instance. This instance is passed to the DAO updateVehicle method. 
		 * 
		 * @parm vehicleDAO, input
		 */
		System.out.println("Enter vehicle id to modify record: ");
		int vehicle_id = input.nextInt();
		System.out.println("Searching...");
		Vehicle AVehicle = new Vehicle();
		AVehicle = vehicleDAO.searchForVehicle(vehicle_id);
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| ID: "+AVehicle.getVehicle_id() + " |Make: "+AVehicle.getMake() +" |Model: "+AVehicle.getModel() +" |Year: "+AVehicle.getYear() +
					           " |Price: "+AVehicle.getPrice() +" |License number: "+AVehicle.getLicense_number() +" |Colour: "+ AVehicle.getColour() +" |Number of doors: "+ AVehicle.getNumber_doors() +
					           " |Transmission: "+ AVehicle.getTransmission() +" |Mileage: "+ AVehicle.getMileage() +" |Fuel type: "+ AVehicle.getFuel_type() +
					           " |Engine size: "+AVehicle.getEngine_size() + " |Body size: "+AVehicle.getBody_style() +" |Condition: "+ AVehicle.getCondition() +" |Notes: "+ AVehicle.getNotes() + " |");
		
			System.out.println("Enter updated car details...");
			System.out.println("Enter updated make: ");
			String make = input.nextLine();
			make = input.nextLine();
			
			System.out.println("Enter updated model: ");
			String model = input.nextLine();
			
			System.out.println("Enter updated year: ");
			int year = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter updated price: ");
			int price = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter updated license number: ");
			String license_number = input.nextLine();
			
			System.out.println("Enter updated colour: ");
			String colour = input.nextLine();
			
			System.out.println("Enter updated number of doors: ");
			int number_doors = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter updated transmission (Manual / Automatic ): ");
			String transmission = input.nextLine();
			
			System.out.println("Enter updated mileage: ");
			int mileage = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter updated fuel type(Petrol or Diesel ): ");
			String fuel_type = input.nextLine();
			
			System.out.println("Enter updated engine size: ");
			int engine_size = input.nextInt();
			input.nextLine();
			
			System.out.println("Enter updated body style: ");
			String body_style = input.nextLine();
			
			System.out.println("Enter updated condition: ");
			String condition = input.nextLine();
			
			System.out.println("Enter updated notes: ");
			String Notes = input.nextLine();
			
			Vehicle vehicleObj = new Vehicle(vehicle_id, make, model, year, price, license_number, 
											colour, number_doors, transmission, mileage, 
											fuel_type, engine_size, body_style, condition , Notes);
			
			if(vehicleDAO.updateVehicle(vehicleObj, vehicle_id)==true)
			{
				System.out.println("Vehicle updated successfully!");
			}
			mainMenu();
			
		}
	
	public static void startWebServer() throws Exception
	{
		/**
		 * Provides the means of starting the web server
		 */
		System.out.println("Starting web server...");
		webController.initialiseWebServer();
	}
		

		
	
	public static void exit()
	{
		/**
		 * Exits the application
		 */
		System.out.println("Goodbye!");
		System.exit(0);
	}
	


}

