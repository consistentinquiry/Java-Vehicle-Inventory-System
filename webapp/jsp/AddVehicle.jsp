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
	<title>Add Vehicle</title>
</head>
<body>
	<div class="page-header">
    	<h1> Add Vehicle </h1>
	</div>
	<div class="container">
		<form method="POST" action="./add">
		Make:<br>
		<input id="makeEntry" type="text" name="make"><br>
		Model:<br>
		<input id="modelEntry" type="text" name="model"><br>
		Year:<br>
		<input id="yearEntry" type="text" name="year"><br>
		Price:<br>
		<input id="priceEntry" type="text" name="price"><br>
		Licence:<br>
		<input id="licenceEntry" type="text" name="license_number"><br>
		Colour:<br>
		<input id="colourEntry" type="text" name="colour"><br>
		Number of doors:<br>
		<input id="doorsEntry" type="text" name="number_doors"><br>
		Transmission:<br>
		<input id="transmissionEntry" type="text" name="transmission"><br>
		Mileage:<br>
		<input id="mileageEntry" type="text" name="mileage"><br>
		Fuel type:<br>
		<input id="fuelEntry" type="text" name="fuel_type"><br>
		Engine type:<br>
		<input id="engineEntry" type="text" name="engine_size"><br>
		Body style:<br>
		<input id="bodyEntry" type="text" name="body_style"><br>
		Condition:<br>
		<input id="conditionEntry" type="text" name="condition"><br>
		Notes:<br>
		<input id="notesEntry" type="text" name="notes"><br>
		<input type="submit" value="Add Vehicle" class="btn btn-info pull-left">
		 </form>
	</div>
<div class="container">
    	<a href="http://localhost:8080/VehicleInventory/home" class="btn btn-light pull-left" role="button">Cancel</a>
</div>
</body>
</html>
