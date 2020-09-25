<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Team</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>Add Team</h2>

<form:form method="POST" action="/team" modelAttribute="team">
	<p>
	<form:label path="name">Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</p>
	
	<p>
	<form:label path="city">City:
	<form:errors path="city"/>
	<form:input path="city"/></form:label>
	</p>
	<p>
	<form:label path="players"># Of Players
	<form:errors path="players"/>
	<form:input path="players"/></form:label>
	</p>
	<button>Add Team</button>
</form:form>

</div>
</body>
</html>