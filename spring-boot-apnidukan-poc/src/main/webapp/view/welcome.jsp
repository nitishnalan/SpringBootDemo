<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"> </c:set>
<html>
<head>

<title>Welcome</title>
</head>
<body>
<h1>Hello World</h1>
<br/>
<p>	${message} </p>

<p><a href="${path}/users/list"> User List </a></p>
<p><a href="${path}/address/list"> Address List</a></p>
<p><a href="${path}/admin/searchproduct/1?searchfield="> Search Products</a></p>
</body>
</html>