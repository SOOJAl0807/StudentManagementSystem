<%@page import="studentmanagementsystem.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<%List<Student> list=(List)request.getAttribute("list"); %>
<tr>
<th>id</th>
<th>name</th>
<th>address</th>
<th>email</th>
<th>password</th>
<th>phone</th>
<th>delete</th>
<th>update</th>

</tr>
<%for(Student student:list){%>
<tr>
<td><%=student.getId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getAddress() %></td>
<td><%=student.getEmail() %></td>
<td><%=student.getPassword()%></td>
<td><%=student.getPhone() %></td>
<td><a href="delete?id=<%=student.getId()%>">delete</a>
<td><a href="update?id=<%=student.getId()%>">update</a>

</tr>
<%} %>



</table>
</body>
</html>