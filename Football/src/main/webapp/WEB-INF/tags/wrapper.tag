<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Football dot Com</title>
</head>
<body>
	<div class="container">
	<h1>Welcome to Football dot Com</h1>
	<nav>
		<a href="/teams/add">Teams</a> |
		<a href="/players/new">Add Player</a> |
		<a href="/logout">Logout</a>
	</nav>
	<hr />
	<jsp:doBody/>
	</div>
