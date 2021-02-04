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

public class ServletEdit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		/**
		 * Details which jsp page is served up upon initial load.
		 * 
		 *  @param req, resp
		 */
		VehicleDAO vehicledao = new VehicleDAO();
		Vehicle vehicle = new Vehicle();
		int ID;
		try {
			vehicle = vehicledao.searchForVehicle(Integer.valueOf(req.getParameter("id")));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		//Vehicle vehicle = new Vehicle();
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/EditVehicle.jsp");
		req.setAttribute("vehicle", vehicle);
		view.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		/**
		 * Processes the data sent to the servlet. 
		 * Parameters are taken from the jsp page and assigned to variables.
		 * These are then used to create a new vehicle object which  is passed
		 * to DAO updateVehicle as a parameter, along with the ID. 
		 */
		System.out.println("Editing vehicle...");
		VehicleDAO vehicledao = new VehicleDAO();
		int ID = Integer.valueOf(req.getParameter("ID"));
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
		try
		{
			Vehicle updatedVehicle = new Vehicle(make, model, year, price, license_number, colour, 
					number_doors, transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
			
			if(vehicledao.updateVehicle(updatedVehicle, ID)==true)
			{
				System.out.println("Vehicle updated!");
				resp.sendRedirect("home");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
