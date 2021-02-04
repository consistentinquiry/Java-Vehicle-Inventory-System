<!DOCTYPE html>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page	import="java.util.ArrayList"%>
<%@page	import="models.Vehicle"%>
<%@page	import="controller.VehicleDAO"%>

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width = device-width, initial-scale=1">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	<title>Edit Vehicle</title>
</head>
<body>
	<div class="page-header">
    	<h1> Edit Vehicle </h1>
	</div>
	<div class="container">
		<form method="POST" action="./edit">
		<input type="hidden" name="ID" value="${vehicle.getVehicle_id()}">
		Make:<br>
		<input id="makeEntry" type="text" name="make" value="${vehicle.getMake()}"><br>
		Model:<br>
		<input id="modelEntry" type="text" name="model" value="${vehicle.getModel()}"><br>
		Year:<br>
		<input id="yearEntry" type="text" name="year" value="${vehicle.getYear()}"><br>
		Price:<br>
		<input id="priceEntry" type="text" name="price" value="${vehicle.getPrice()}"><br>
		Licence:<br>
		<input id="licenceEntry" type="text" name="license_number" value="${vehicle.getLicense_number()}"><br>
		Colour:<br>
		<input id="colourEntry" type="text" name="colour" value="${vehicle.getColour()}"><br>
		Number of doors:<br>
		<input id="doorsEntry" type="text" name="number_doors" value="${vehicle.getNumber_doors()}"><br>
		Transmission:<br>
		<input id="transmissionEntry" type="text" name="transmission" value="${vehicle.getTransmission()}"><br>
		Mileage:<br>
		<input id="mileageEntry" type="text" name="mileage" value="${vehicle.getMileage()}"><br>
		Fuel type:<br>
		<input id="fuelEntry" type="text" name="fuel_type" value="${vehicle.getFuel_type()}"><br>
		Engine type:<br>
		<input id="engineEntry" type="text" name="engine_size" value="${vehicle.getEngine_size()}"><br>
		Body style:<br>
		<input id="bodyEntry" type="text" name="body_style" value="${vehicle.getBody_style()}"><br>
		Condition:<br>
		<input id="conditionEntry" type="text" name="condition" value="${vehicle.getCondition()}"><br>
		Notes:<br>
		<input id="notesEntry" type="text" name="notes" value="${vehicle.getNotes()}"><br>
		<input type="submit" value="Edit Vehicle" class="btn btn-info pull-left">
		 </form>
	</div>
<div class="container">
    	<a href="http://localhost:8080/VehicleInventory/home" class="btn btn-light pull-left" role="button">Cancel</a>
</div>
</body>
</html>
