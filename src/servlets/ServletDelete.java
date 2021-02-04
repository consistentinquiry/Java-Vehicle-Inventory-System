package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.VehicleDAO;

public class ServletDelete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		/**
		 * Details which jsp page is served up upon initial load.
		 * 
		 *  @param req, resp
		 */
		VehicleDAO vehicledao = new VehicleDAO();
		int ID =Integer.valueOf(req.getParameter("id"));
		try {
			if(vehicledao.deleteVehicle(ID)==true)
			{
				System.out.println("UPDATE SUCCESSFUL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("home");
		
	}
}
