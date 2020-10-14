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
<p><a href="/teams/owner/${team.owner.id}"> Owner: ${team.owner.firstName} ${team.owner.lastName }</a></p>
<hr>
<p>Name: ${team.name }</p>
<p>Logo: </p>
<img src="${team.logo}" height="100px" width="100px">
<form method="POST" action="/teams/upload/${team.id}" enctype="multipart/form-data">
<p>Please select a file to upload: <input type="file" name="file"/></p>
<input type="submit" value="Add Logo">
</form>
<c:choose>
<c:when test="${team.mascot != null}">
<p>Mascot: ${team.mascot.color} ${team.mascot.name}</p>
</c:when>
<c:otherwise>
<h3>Add Mascot</h3>
<form:form method="POST" action="/teams/mascot" modelAttribute="mascot">
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
<p>City: ${team.city }</p>
<p># Of Players ${team.players}</p>
<hr>
<h3>Liked By:</h3>
<ol>
<c:forEach items="${team.likers}" var="owner">
<li>${owner.firstName} ${owner.lastName}</li>
</c:forEach>
</ol>
<hr>
<h3>Active Roster</h3>
<table class="table table-dark">
<thead>
<th>Player</th>
<th>Position</th>
<th>Stats</th>
</thead>
<tbody>
<c:forEach items="${team.player}" var="player">
<tr>
<td>${player.name}</td>
<td>${player.position}</td>
<td> ${player.weight} lbs</td>
</tr> 
</c:forEach>
</tbody>
</table>

<hr>
<c:if test="${team.owner.id == ownerId}">
<h3>Edit Team</h3>
<form:form method="POST" action="/teams/${team.id}" modelAttribute="team">

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
<a href="/teams/delete/${team.id }">Delete Team</a>
</c:if>
</div>
</body>
</html>