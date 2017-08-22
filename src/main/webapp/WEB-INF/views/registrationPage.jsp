<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Registration Page</title>
	</head>
	<body>
		<form action="registrationPage/registrationForm">
			Name: <input type="text" name="name" placeholder="Enter your name" />
			<br/>
			Surname: <input type="text" name="surname" placeholder="Enter your surname" />
			<br/>
			Document: <input type="text" name="document" placeholder="Enter your document number" />
			<br/>
			Date of Birth: <input type="text" name="dateOfBirth" placeholder="Enter your date of birth DD-MM-YYYY" />
			<br/>
			Login: <input type="text" name="login" placeholder="Enter your unique login" />
			<br/>
			Password: <input type="text" name="password" placeholder="Enter your secret password" />
			<br/>
			<input class="buttonElement" type="submit" value="Register"/>
		</form>
	</body>
</html>