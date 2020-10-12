<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Image</title>
</head>
<body>
<p>${message}</p>
<form method="POST" action="/upload/13"
    enctype="multipart/form-data">


    Please select a file to upload : <input type="file" name="file" />
    <input type="submit" value="upload" />

</form>
</body>
</html>