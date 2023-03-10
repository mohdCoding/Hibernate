<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
body {
	background-color: aqua;
}

.heading {
  color:white;
}

.fea {
 margin:50px auto;
  width:400px;
  height:350px;
  background-color:crimson;
  border:3px solid white;
}

.fea .fea-lists .f-list {
list-style-type:none;
background-color:blue;
margin-top:10px;
font-size:25px;
padding:7px;
margin-right:13px;
border-radius:5px;
border:3px solid white;
text-align:center;
}

.f-link {
   color:white;
   text-decoration:none;
   font-style:bold;
   
}

.fea .fea-lists .f-list:hover {
 cursor:pointer;
 background-color:red;
}
</style>
</head>
<body>
	<br>
	<center>
		<h1 class="heading">WELCOME TO OUR APPLICATION</h1>
	</center>

	<br>
	<hr>


	<div class="fea">
	    <center>
	      <h1 class="heading">CHOOSE YOUR OPTION</h1>
	    </center>
	    
	    <hr>
	    
		<ul class="fea-lists">
			<li  class="f-list"><a href="./create.jsp" class="f-link link1">CREATE</a></li>
			<li class="f-list"><a href="./read.jsp"   class="f-link link2">READ</a></li>
			<li class="f-list"><a href="./update.jsp" class="f-link link3">UPDATE</a></li>
			<li class="f-list"><a href="./delete.jsp" class="f-link link4">DELETE</a></li>
		</ul>
		
	</div>
</body>
</html>