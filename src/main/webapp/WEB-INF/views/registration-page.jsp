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
		<title>Registration Page</title>
	</head>
	<body>
		<form:form action="process-registration-form" modelAttribute="registrData" method="POST">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input type="text" path="name" placeholder="Your name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><form:input type="text" path="surname" placeholder="Your surname" /></td>
					<td><form:errors path="surname" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><form:radiobuttons items="${registrData.genderTypes}" path="sex" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><form:input type="text" path="dateOfBirth" placeholder="DD-MM-YYYY" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Document</td>
					<td><form:input type="text" path="document" placeholder="Document number" /></td>
				</tr>
				<tr>
					<td>Country of Issue</td>
					<td>
						<form:select path="country">
							<jstl:forEach var="country" items="${countries}">
								<form:option value="${country.countryName}" />
							</jstl:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Login</td>
					<td><form:input type="text" path="login" placeholder="Unique login" /></td>
					<td><form:errors path="login" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input type="text" path="password" placeholder="Secret password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
			</table>
			<input type="reset" value="Reset" />
			<input type="submit" value="Register" />
		</form:form>
	</body>
</html>