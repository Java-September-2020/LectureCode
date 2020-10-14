<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<t:wrapper>
<h1>Owner Details</h1>
<p>Details for ${owner.firstName } ${owner.lastName }</p>
<hr>
<h4>Teams Owned</h4>
<ol>
<c:forEach items="${owner.teams}" var="team">
<li>${team.name} - ${team.city}</li>
</c:forEach>
</ol>
</t:wrapper>

</body>
</html>