<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,hht.business.GolfScore" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Scores</title> 
<link rel="stylesheet" type="text/css" href="styles/hht.css">
</head>
<body>
	<h2>Scoring Record:</h2>
	<br>
	<p>NOTE: These scores are adjusted for ESC.</p>
	<table>
		<tr><th>Date</th><th>Course</th><th>Score</th><th>Rating</th><th>Slope</th><th>Differential</th></tr>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:forEach var="golfScore" items="${golfScores}" >
			<c:choose>
				<c:when test="${golfScore.convertIsCountedToString() == '1'}">
					<tr>
						<td class="countedScore">${golfScore.datePlayed}</td>
						<td class="countedScore">${golfScore.course}</td>
						<td class="countedScore">${golfScore.front9Score}-${golfScore.back9Score}-${golfScore.totalScore}</td>
						<td class="countedScore">${golfScore.rating}</td>
						<td class="countedScore">${golfScore.slope}</td>
						<td class="countedScore">${golfScore.differential}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${golfScore.datePlayed}</td>
						<td>${golfScore.course}</td>
						<td>${golfScore.front9Score}-${golfScore.back9Score}-${golfScore.totalScore}</td>
						<td>${golfScore.rating}</td>
						<td>${golfScore.slope}</td>
						<td>${golfScore.differential}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	<br>
	<p>"Humphries' Handicap Index": ${handicap}</p>
	<br>
	<a href="index.jsp">Back To The Home Page</a>
</body>
</html>