<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER DETAIL</title>
<style>
 body {
   background-color:aqua;
   color:white;
 }


</style>
</head>
<body>


<table align='center' border='2'>
<tr>
   <th>ID</th>
   <td><c:out value="${person.id }"/></td>
</tr>
<tr>
   <th>NAME</th>
   <td><c:out value="${person.name }"/></td>
</tr>
<tr>
   <th>DOB</th>
   <td><c:out value="${person.dob }"/></td>
</tr>
<tr>
   <th>CITY</th>
   <td><c:out value="${person.city }"/></td>
</tr>
</table>
</body>
</html>