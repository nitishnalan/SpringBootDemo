<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Product Summary</title>
</head>
<body>

Hello from product summary
<div class="container-fluid">
	<div class="container">
		<form name= "search" id="search" action="/apnidukan/product/search/1" method="GET">
		<%
			
			out.print("<p>Enter ID of the Product OR Name of the Product you would like to Search: </p>");
			if(session.getAttribute("searchFieldController") != null){
				String searchFieldValue = (String) session.getAttribute("searchFieldController");
				out.print("<input type ='text' name='searchfield' value="+searchFieldValue+">");
			}else
			{
				out.print("<input type ='text' name='searchfield'/>");
			}
			out.print("<button type ='submit'>Search Items!</button>");
			out.print("<br/>");
			
		 %>
		</form>
	</div>
	<br/><br/><br/><br/>
<div class="row">
<c:set var = "productSummaryModal" value = "${productSummary}"/>
<div class="col-lg-4 col-md-4 col-sm-12">
<!-- <div class="col-lg-3 col-md-3 col-sm-12">
</div> -->
<!-- <div class="col-lg-9 col-md-9 col-sm-12">
 -->
<c:choose>
  	<c:when test="${productSummaryModal.productImageExists}">
  		<img src="<c:url value='/resources/static/images/${productSummaryModal.productId}/${productSummaryModal.productImageName}'/>" class="rounded mx-auto d-block" margin-left ="auto"  margin-right= "auto" alt="Product Image">
    </c:when>
    					
    <c:otherwise>
  		<img src="/apnidukan/resources/static/images/noimage.jpg" class="rounded mx-auto d-block" class="center" alt="Product Image">
    </c:otherwise>
</c:choose>
<!-- </div> -->
</div>
<div class="col-lg-6 col-md-6 col-sm-12">
 <table class="table table-striped">
    <tr><td>Name : </td><td>${productSummaryModal.productName}</td></tr>
    <tr><td>Description : </td><td>${productSummaryModal.productDescription}</td></tr>			 	
    <tr><td>Number of Items : </td><td>${productSummaryModal.productNumItems}</td></tr>
    <tr><td>Price : </td><td>${productSummaryModal.productPrice}</td></tr>
    </table>
</div>

<div class="col-lg-2 col-md-2 col-sm-12">

</div>

</div>
</body>
</html>