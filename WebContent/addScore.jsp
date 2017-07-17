<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Score</title>
	<script src="jquery.js" type="text/javascript"></script>
	<script src="main.js" type="text/javascript"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"></head>
</head>
<body>
	<div class="container">
		<h2>Add A Score</h2>
		<form class="form-horizontal" action="addScore" method="post">
				<div class="form-group">
				    <label for="datePicker">Date: </label>
				    <input type="date" class="form-control" id="datePicker" name="datePlayed">
					<label for="course">Course: </label>
					<input type="text" class="form-control" id="course" name="course">
					<label for="front9Score">Front 9 Score: </label>
					<input type="text" class="form-control" id="front9Score" name="front9Score">
					<label for="back9Score">Back 9 Score: </label>
					<input type="text" class="form-control" id="back9Score" name="back9Score">
					<label for="totalScore">Total Score: </label>
					<input type="text" class="form-control" id="totalScore" name="totalScore">
					<label for="rating">Rating: </label>
					<input type="text" class="form-control" id="rating" name="rating">
					<label for="slope">Slope: </label>
					<input type="text" class="form-control" id="slope" name="slope">
					<button type="submit" class="btn btn-default">Add Score</button>
				</div>
		</form>
	</div>
</body>
</html>