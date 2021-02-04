package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.VehicleDAO;

import models.Vehicle;

public class ServletAdd extends HttpServlet {
	/**
	 * Servlet for processing the get and post methods relating to adding new vehicles
	 * to the database.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		/**
		 * Details which jsp page is served up upon initial load.
		 * 
		 *  @param req, resp
		 */
		RequestDispatcher view = req.getRequestDispatcher("jsp/AddVehicle.jsp");
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		/**
		 * Processes the data sent to the servlet. 
		 * Parameters are taken from the jsp page and assigned to variables.
		 * These are then used to create a new vehicle object which  is passed
		 * to DAO insertNewVehicle as a parameter. 
		 */
		System.out.println("Editing vehicle...");
		VehicleDAO vehicledao = new VehicleDAO();
		String make = req.getParameter("make");
		String model =req.getParameter("model");
		int year = Integer.valueOf(req.getParameter("year"));
		int price = Integer.valueOf(req.getParameter("price")); 
		String license_number = req.getParameter("license_number");
		String colour = req.getParameter("colour");
		int number_doors = Integer.valueOf(req.getParameter("number_doors"));
		String transmission = req.getParameter("transmission"); 
		int mileage = Integer.valueOf(req.getParameter("mileage"));
		String fuel_type = req.getParameter("fuel_type");
		int engine_size = Integer.valueOf(req.getParameter("engine_size"));
		String body_style = req.getParameter("body_style");
		String condition = req.getParameter("conditioin");
		String notes = req.getParameter("notes"); 
		
		Vehicle vehicleObj = new Vehicle(make, model, year, price, license_number, 
				colour, number_doors, transmission, mileage, 
				fuel_type, engine_size, body_style, condition ,notes);
		
		try
		{
			if(vehicledao.insertNewVehicle(vehicleObj)==true)  //if the vehicle insertion returns true...
			{
				System.out.println("Vehicle added!");
			}
			else
			{
				System.out.println("Vehicle not added :(");
			}
		}
		catch(SQLException e) 
        {
			e.printStackTrace();
		}
		resp.sendRedirect("home");
		
	}

}
