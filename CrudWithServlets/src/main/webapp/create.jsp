<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATE</title>
<style>
body {
	background-color: aqua;
	color: white;
}

.myform {
	background-color: crimson;
	border: 3px solid white;
	margin: 50px auto;
	width: 400px;
	height: 400px;
}

.myform .form .label {
	font-size: 23px;
	padding: 2px;
	margin: 10px;
}

.myform .form .input {
	font-size: 21px;
	padding: 3px;
	width: 70%;
	margin-left: 30px;
}

.submit {
	font-size: 24px;
	border: 2px solid white;
	background-color: blue;
	border-radius: 5px;
	width: 72%;
	padding: 3px;
	text-align: center;
	margin-top: 30px;
	margin-left: 40px;
	color: white;
}

.submit:hover {
	background-color: red;
	color: white;
	cursor: pointer;
}

.message {
	background-color: crimson;
	color: white;
	padding: 5px;
	font-size: 24px;
}
</style>
</head>
<body>

	<c:if test="${not empty create }">
		<c:if test="${create eq 'success'}">
			<h1 class="message">RECORD ADDED SUCCESSFULLY</h1>
		</c:if>
		<c:if test="${create eq 'failure'}">
			<h1 class="message">FAILED TO ADD THE RECORD</h1>
		</c:if>
		<c:remove var="create"/>
	</c:if>

	<br>
	<div class="myform">
		<center>
			<h1 class="heading">ADD A NEW RECORD</h1>
		</center>
		<hr>

		<form class="form" action="./controller/create" method="post">
			<br> <label class="label">ENTER YOUR NAME</label><br> <input
				type="text" name="username" class="input" /> <br> <br> <label
				class="label">ENTER YOUR DOB</label><br> <input type="date"
				name="userdob" class="input" /> <br> <br> <label
				class="label">ENTER YOUR CITY</label><br> <input type="text"
				name="usercity" class="input" /> <br> <input type="submit"
				value="create" class="submit" />
		</form>

	</div>
</body>
</html>