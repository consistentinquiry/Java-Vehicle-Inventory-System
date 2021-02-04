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

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		/**
		 * Details which jsp page is served up upon initial load.
		 * 
		 *  @param req, resp
		 */
		RequestDispatcher view = req.getRequestDispatcher("jsp/Login.jsp");
		view.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		/**
		 * Processes the data sent to the servlet. 
		 * Parameters are taken from the jsp page and assigned to variables.
		 * A message digest object is created and the password is supplied to it
		 * yieldng and md5 hash of the password. This is then supplied to DAO loginVerification method
		 * with the hash string and username as parameters which returns either true or false
		 * depending on the validity of the credentials. If correct then the session attribute is set to true.
		 * 
		 */
		VehicleDAO vehicledao = new VehicleDAO();
		HttpSession session = req.getSession();
		
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
						
		MessageDigest md = null;
		try 
		{
			md = MessageDigest.getInstance("MD5");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes)
        {
            sb.append(String.format("%02x", b));
        }
        try 
        {
			if(vehicledao.loginVarification(username, sb.toString())== true)
				{
					System.out.println("credentials are correct!");
					session.setAttribute("loggedin", true); //if correct this is set to true and persists until end of session
					resp.sendRedirect("home");
				}
			else
			{
				System.out.print("Credentials didnt match");
				session.setAttribute("loggedin", false);
				resp.sendRedirect("home");           //take the user back home 
				sb.toString();
			}
		} 
        catch(SQLException e) 
        {
			e.printStackTrace();
		}
	}
	
}