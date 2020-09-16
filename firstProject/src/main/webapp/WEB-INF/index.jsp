<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The best web page around</title>
</head>
<body>
<form method="POST" action="/processData">
<p>Name: <input type="text" name="name"></p>
<p>Email: <input type="text" name="email"></p>
<p>Favorite Color: <input type="text" name="color"></p>
<button>Submit</button>
</form>
</body>
</html>