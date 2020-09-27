<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3>Details For <c:out value="${team.name}"/></h3>
<hr>
<p>Name: ${team.name }</p>
<p>City: ${team.city }</p>
<p># Of Players ${team.players}</p>

<c:choose>
<c:when test="${team.mascot != null}">
<p>Mascot: ${team.mascot.color} ${team.mascot.name}</p>
</c:when>
<c:otherwise>
<h3>Add Mascot</h3>
<form:form method="POST" action="/mascot" modelAttribute="mascot">
	<form:hidden path="team" value="${team.id}"/>
	<p>
	<form:label path="name">Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</p>
	
	<p>
	<form:label path="color">Color:
	<form:errors path="color"/>
	<form:input path="color"/></form:label>
	</p>
	<button>Add Mascot</button>
</form:form>
</c:otherwise>
</c:choose>
<hr>
<h3>Edit Team</h3>
<form:form method="POST" action="/${team.id}" modelAttribute="team">
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
	<button>Update Team</button>
</form:form>
<a href="/delete/${team.id }">Delete Team</a>
</div>
</body>
</html>