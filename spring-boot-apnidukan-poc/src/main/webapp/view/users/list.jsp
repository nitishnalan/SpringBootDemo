<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"> </c:set>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Lists</title>
</head>
<body>
		<table>
		<thead>
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>Email Id</th>
				<th>Name</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td> ${user.userId}</td>
					<td> ${user.username} </td>
					<td> ${user.name}</td>
					<td> ${user.email} </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>