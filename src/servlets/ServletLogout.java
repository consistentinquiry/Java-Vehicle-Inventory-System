package servlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.VehicleDAO;

public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		/**
		 * Details which jsp page is served up upon initial load.
		 * 
		 *  @param req, resp
		 */
		VehicleDAO vehicledao = new VehicleDAO();
		HttpSession session = req.getSession();
		session.setAttribute("loggedin", false);
		System.out.println("Logging out...");
		resp.sendRedirect("home");
	}
}