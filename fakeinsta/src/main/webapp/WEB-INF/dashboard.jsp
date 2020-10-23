<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fake Insta</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
Let's get ready to rock
<div class="container">
<a href="/logout">Logout</a>
<h3 align="center">Welcome <c:out value="${currentUser.userName}"/></h3> 
<p>Following: <c:out value="${currentUser.getFollowing().size()}"/> | Followers: <c:out value="${currentUser.getFollowers().size()}"/></p>

<h3>Upload Picture</h3>
<form method="POST" action="/dashboard/upload" enctype="multipart/form-data">
<div class="form-data">Select file: <input type="file" name="pic"></div>
<div class="form-data"><textarea name="description">Please Enter a Description</textarea></div>
<button>Upload Pic!</button>

</form>

</div>

<h3>Users To Follow</h3>
<c:forEach items="${users}" var="user">
<a href="/dashboard/${user.id}">Follow</a> - ${user.userName }
</c:forEach>


</div>

</body>
</html>