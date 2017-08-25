<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration Page</title>
	</head>
	<body>
		<form:form action="registration-page/process-registration-form" modelAttribute="registrData">
			<table>
				<tr>
					<td>Name</td>
					<td><form:input type="text" path="name" placeholder="Your name" /></td>
					<td><form:errors path="name" /></td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><form:input type="text" path="surname" placeholder="Your surname" /></td>
					<td><form:errors path="surname" /></td>
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
							<form:options items="${countryOptions}" />
						</form:select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Login</td>
					<td><form:input type="text" path="login" placeholder="Unique login" /></td>
					<td><form:errors path="login" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input type="text" path="password" placeholder="Secret password" /></td>
					<td></td>
				</tr>
			</table>
			<input type="reset" value="Reset" />
			<input type="submit" value="Register" />
		</form:form>
	</body>
</html>