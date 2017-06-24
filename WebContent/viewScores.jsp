<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,hht.business.GolfScore" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Scores</title>
</head>
<body>
	<h2>Scoring Record:</h2>
	<br>
	<p>NOTE: These scores are adjusted for ESC.</p>
	<table>
		<tr><th>Date</th><th>Course</th><th>Score</th><th>Rating</th><th>Slope</th><th>Differential</th></tr>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:forEach var="golfScore" items="${golfScores}" >
		<tr>
		<td>${golfScore.datePlayed}</td>
		<td>${golfScore.course}</td>
		<td>${golfScore.front9Score}-${golfScore.back9Score}-${golfScore.totalScore}</td>
		<td>${golfScore.rating}</td>
		<td>${golfScore.slope}</td>
		<td>${golfScore.differential}</td>
		</c:forEach>
	</table>
	<br>
	<p>"Humphries' Handicap Index": ${handicap}</p>
</body>
</html>