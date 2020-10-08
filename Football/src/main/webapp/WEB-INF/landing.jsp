<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Football dot Com</title>
</head>
<body>
<form method="post" action="login">
<select name="owners">
<c:forEach items="${owners}" var="owner">
<option value="${owner.id}">${owner.firstName} ${owner.lastName}</option>
</c:forEach>
</select>
<button>Login</button>
</form>
</body>
</html>