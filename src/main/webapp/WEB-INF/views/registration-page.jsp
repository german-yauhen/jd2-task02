<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration Page</title>
	</head>
	<body>
		<form action="registration-page/process-registration-form" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" placeholder="Your name" /></td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><input type="text" name="surname" placeholder="Your surname" /></td>
				</tr>
				<tr>
					<td>Document</td>
					<td><input type="text" name="document" placeholder="Document number" /></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="text" name="dateOfBirth" placeholder="DD-MM-YYYY" /></td>
				</tr>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" placeholder="Unique login" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" placeholder="Secret password" /></td>
				</tr>
				<tr>
					
				</tr>
			</table>
			<input type="reset" value="Reset" />
			<input type="submit" value="Register" />
		</form>
	</body>
</html>