<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"> </c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address List</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Country</th>
				<th>State </th>
				<th>City</th>
				<th>User </th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${address}" var="addr">
				<tr>
					<td>${addr.country}</td>
					<td>${addr.state} </td>
					<td>${addr.city} </td>
					<td>${addr.users.username} </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>