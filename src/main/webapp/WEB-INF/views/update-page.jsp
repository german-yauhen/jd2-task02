<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
		<title>Update Menu</title>
	</head>
	<body>
		<form action="process-update-form" method="POST">
			<table>
				<tr>
					<td><input type="hidden" name="userId" value="${userForUpdate.getId()}" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${userForUpdate.getName()}" /></td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><input type="text" name="surname" value="${userForUpdate.getSurname()}" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>
						<jstl:forEach items="${userForUpdate.getGenderTypes()}" var="gender">
							${gender}<input type="radio" name="gender" value="${gender}" />
						</jstl:forEach>
					</td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="text" name="dateOfBirth" value="${userForUpdate.getDateOfBirth()}" /></td>
				</tr>
				<tr>
					<td>Document</td>
					<td><input type="text" name="document" value="${userForUpdate.getDocument()}" /></td>
				</tr>
				<tr>
					<td>Country of Issue</td>
					<td>
						<select name="country">
							<jstl:forEach var="country" items="${countries}">
								<option value="${country.countryName}">${country.countryName}</option>
							</jstl:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" value="${userForUpdate.getLogin()}" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" value="" /></td>
				</tr>
			</table>
			<input type="reset" value="Reset" />
			<input type="submit" value="Update" />
		</form>
	</body>
</html>