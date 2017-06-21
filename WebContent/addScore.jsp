<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Score</title>
<script src="jquery.js" type="text/javascript"></script>
<script src="main.js" type="text/javascript"></script>
</head>
<body>
	<h2>Add A Score</h2>
	<form action="addScore" method="post">
		Date: 
		<input type="date" name="datePlayed" id="datePicker">
		<br>
		Course: <input type="text" name="course">
		<br>
		Front 9 Score: <input type="text" name="front9Score">
		<br>
		Back 9 Score: <input type="text" name="back9Score">
		<br>
		Total Score: <input type="text" name="totalScore">
		<br>
		Rating: <input type="text" name="rating">
		<br>
		Slope: <input type="text" name="slope">
		<br>
		<button type="submit">Add Score</button>
	</form>
</body>
</html>