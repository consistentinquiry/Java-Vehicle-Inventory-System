package servlets;
import java.util.ArrayList;
import models.Vehicle;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.VehicleDAO;

public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		/**
		 * Details which jsp page is served up upon initial load.
		 * 
		 *  @param req, resp
		 */
		HttpSession session = req.getSession();
		RequestDispatcher view = req.getRequestDispatcher("jsp/index.jsp");
		VehicleDAO vehicleDAO = new VehicleDAO();
		ArrayList<Vehicle> allVehicles=null;
		try {
			allVehicles = vehicleDAO.getAllVehicles();
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		req.setAttribute("allVehicles", allVehicles);
		view.forward(req, resp);
	}	
}