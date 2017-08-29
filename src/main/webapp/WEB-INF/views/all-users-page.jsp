<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
		<title>All Users Menu</title>
	</head>
	<body>
		<h1>Welcome to all users page!</h1>
		<table>
			<th>Login</th>
			<th>Full name</th>
			<th>Date of Birth</th>
			<th>Country</th>
			<th></th>
			<th></th>
			<c:forEach items="${usersList}" var="user">
				<tr>
					<td>${user.getLogin()}</td>
					<td>${user.getFullName()}</td>
					<td>${user.getDateOfBirth()}</td>
					<td>${user.getCountry()}</td>
					<td>
						<form action="update-context/update" method="GET">
						    <input type="hidden" name="userId" value="${user.getId()}">
						    <button type="submit">Update</button>
						</form>
					<td>
						<form action="delete-context/delete" method="GET">
						    <input type="hidden" name="userId" value="${user.getId()}">
						    <button type="submit">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>