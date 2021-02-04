<!DOCTYPE html>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width = device-width, initial-scale=1">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	<title>Login</title>
</head>
<body>
	<div class="page-header">
    <h1> Login </h1>
</div>
<div class="jumbotron">
    <form method="POST" action="/VehicleInventory/login">
        Username:<br>
        <input id="usernameEntry" type="text" name="username"><br>
        Password:<br>
        <input id="passwordEntry" type="text" name="password">
        <input type="submit" value="Submit" class="btn btn-info pull-right" href="http://localhost:8080/VehicleInventory/home">
    </form>
    
    <a href="http://localhost:8080/VehicleInventory/home" class="btn btn-light pull-left" role="button">Cancel</a>
<!--     <a href="" class="btn btn-info pull-left" role="button">Login</a> -->

</div>
</body>
</html>
