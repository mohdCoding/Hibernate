<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE</title>
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
	height: 300px;
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
</style>
</head>
<body>

<c:if test="${not empty delete }">
   <c:if test="${delete eq 'success' }">
     <h1 class="message">SUCCESSFULLY DELETED THE RECORD</h1>
   </c:if>
    <c:if test="${delete eq 'failure' }">
        <h1 class="message">OOPS! NO RECORD FOUND BY THIS ID</h1>
   </c:if>
   <c:remove var="delete"/>
</c:if>
	<div class="myform">
		<center>
			<h1 class="heading">DELETE THE RECORD</h1>
		</center>
		<hr>

		<form class="form" action="./controller/delete" method="post">
			<br> <label class="label">ENTER THE ID OF THE RECORD</label><br>
			<input type="number" name="deleteid" class="input" /> <input
				type="submit" value="DELETE" class="submit" />
		</form>

	</div>
</body>
</html>