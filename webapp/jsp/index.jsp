<html>
<head>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Vehicle"%>
<%@page import="controller.VehicleDAO"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width = device-width, initial-scale=1">
<meta><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%></meta>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<title>Vehicles Web View</title>
</head>
<body>
	<div class="page-header">
		
		<c:if test="${loggedin}">
				<h1>Vehicle view (Admin)</h1>
				<a href='http://localhost:8080/VehicleInventory/logout'
				class='btn btn-info pull-right' role='button'>LogOut</a>
			</c:if>
			
		<c:if test="${!loggedin}">
				
				<h1>Vehicle view (Standard)</h1> 
				<a href='http://localhost:8080/VehicleInventory/login' class='btn btn-info pull-right' role='button'>LogIn</a>
			</c:if>
	</div>

	<div class="container" id="vehicleView">
		<table class="table table-sm" style="width: 100%">
			<tr>
				<th>ID</th>
				<th>Make</th>
				<th>Model</th>
				<th>Year</th>
				<th>Price</th>
				<th>Licence</th>
				<th>Colour</th>
				<th>Doors</th>
				<th>Transmission</th>
				<th>Mileage</th>
				<th>Fuel</th>
				<th>Engine_size</th>
				<th>Body_style</th>
				<th>Condition</th>
				<th>Notes</th>
				<c:if test="${loggedin}">
				<th><a href="./add" class="btn btn-info" role='button'>Add vehicle</a></th>>
				</c:if>
			</tr>
			
			<c:forEach items="${allVehicles}" var="c">
		        <tr>
						<td>${c.getVehicle_id()}</td>
						<td>${c.getMake()}</td>
						<td>${c.getModel()}</td>
						<td>${c.getYear()}</td>
						<td>${c.getPrice()}</td>
						<td>${c.getLicense_number()}</td>
						<td>${c.getColour()}</td> 
						<td>${c.getNumber_doors()}</td>
						<td>${c.getTransmission()}</td>
						<td>${c.getMileage()}</td>
						<td>${c.getFuel_type()}</td>
						<td>${c.getEngine_size()}</td>
						<td>${c.getBody_style()}</td>
						<td>${c.getCondition()}</td>
						<td>${c.getNotes()}</td>
					<c:if test="${loggedin}"> 
						<form method="GET" action="/VehicleInventory/edit" >	
						<td> 
							<a href='./edit?id=${c.getVehicle_id()}' class='btn btn-warning pull-left' role='button'>Edit</a>
						</td>
						</form>
						<form method="GET" action="http://localhost:8080/VehicleInventory/delete" >
							<td> 
								<a href='./delete?id=${c.getVehicle_id()}'class='btn btn-danger pull-left' role='button'>Delete</a>
		            		</td>>
						</form>	
							
					</c:if>	
		       </tr>
		        </c:forEach>
			</table>
	</div>
</body>
</html>
