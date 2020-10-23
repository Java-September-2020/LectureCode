<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>Profile Page</title>
</head>
<body>
<div class="container">
<h3>Profile For <c:out value="${user.userName}"/></h3>

<p>Pictures Users have Uploaded</p>
<c:forEach items="${pictures}" var="pic">
<img src="${pic.image_url }" height="150" width="200">
<p>${pic.description}</p>
</c:forEach>


</div>

</body>
</html>