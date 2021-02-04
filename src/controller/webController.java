package controller;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.Configuration.ClassList;

public class webController {
	public static void initialiseWebServer() throws Exception {
		/**
		 * Creates a new server object on the specified port, sets the context path and loads the servlets.
		 * 
		 */
		
		Server server = new Server(8080); // Creating the server on port 8080
		System.out.println("Server created on port 8080");
		// Creating the WebAppContext for the created content
		WebAppContext ctx = new WebAppContext();
		// resource base is pointing where the web content (html. jsp, css ect) is
		// stored
		ctx.setResourceBase("webapp");
		// base url
		ctx.setContextPath("/VehicleInventory");
		// setting some attributes (setting up server to use JSTL)
		ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$");
		// more set up (loading classes )
		ClassList classlist = ClassList.setServerDefault(server);
		classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
				"org.eclipse.jetty.annotations.AnnotationConfiguration");
		// add servlet handlers mapped to URLs
		ctx.addServlet("servlets.ServletHome", "/home");
		ctx.addServlet("servlets.ServletDelete", "/delete");
		ctx.addServlet("servlets.ServletLogin", "/login");
		ctx.addServlet("servlets.ServletEdit", "/edit");
		ctx.addServlet("servlets.ServletLogout", "/logout");
		ctx.addServlet("servlets.ServletAdd", "/add");
		// Setting the handler and starting the Server
		server.setHandler(ctx);
		server.start();
		System.out.println("Server started!");
		server.join();
	}

}
