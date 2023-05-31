<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page  import="com.tcs.User" %>
    <%@page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Users</h1>
	
	<table border="2">
		<tr>
		<th>User Name</th>
		<th>User password</th>
		<th>User Confirm Password</th>
		<th>User Email</th>
		
		</tr>
		
		 <%
		 List<User> users= (List<User>)request.getAttribute("users");
		 %>
		
		 <c:forEach  items="${users}"  var="user" > 
		  <tr>
		 	<td> ${user.username}</td>
		 	<td> ${user.password}</td>
		 	<td> ${user.cpassword}</td>
		 	<td> ${user.email}</td>
		 
		 </tr>
		 </c:forEach>
		 <a href="/DeleteServlet"><button>delete</button></a>
		
	</table>
</body>
</html>