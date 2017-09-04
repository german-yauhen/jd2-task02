<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
		<title>Authentication Menu</title>
	</head>
	<body>
		<form:form action="process-login-form" modelAttribute="loginData" method="POST">
			<table>
				<tr>
					<td>Login</td>
					<td><form:input type="text" path="login" placeholder="Your login"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input type="text" path="password" placeholder="Password" /></td>
				</tr>
			</table>
			<input type="reset" value="Reset" />
			<input type="submit" value="Login" />
		</form:form>
		<div class="error">${error}</div>
		<div class="message">${logoutMessage}</div>
		<form action="to-main-page" method="GET">
			<input type="submit" value="Main Page">
		</form>
	</body>
</html>