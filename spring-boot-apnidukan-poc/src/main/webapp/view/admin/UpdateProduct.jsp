<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">   </script>
<script>
	$(document).ready(function(){
		
		//$("#displayResults").hide();
	
	});
</script>
<title>Search Product</title>
</head>
<body>
	<form name= "search" action="/apnidukan/admin/searchproduct/1" method="GET">
		<%
			
			out.print("<p>Enter ID of the Product OR Name of the Product you would like to Search: </p>");
			
			if(session.getAttribute("searchFieldController") != null){
				String searchFieldValue = (String) session.getAttribute("searchFieldController");
				out.print("<input type ='text' name='searchfield' value="+searchFieldValue+">");
				System.out.println("searchFieldController 1 : " + searchFieldValue);
			}else
			{
				out.print("<input type ='text' name='searchfield'/>");
			}
			out.print("<button type ='submit'>Click Me!</button>");
			out.print("<br/>");
			
		 %>
	</form>
	
	<form id = "displayResults" name="displayResults" action="/apnidukan/admin/searchproduct/1" method="GET">
	<%
		String flag = (String) session.getAttribute("foundResults");
		System.out.println("flag : " + flag);
	
		if(flag.equals("true")){
			out.print("<h1>Product Search List</h1>");  
			out.print("<table border='2' width='70%' cellpadding='2'>"); 
			out.print("<tr><th>Image Present</th><th>Id</th><th>Name</th><th>Description</th></tr>");  
			
	%>
	<%-- 
			<c:forEach var="product" items="${list}">   
				<tr><td>${product.productId}</td><td>${product.productName}</td><td>${product.productDescription}</td></tr> 
			</c:forEach> 
		</table> 
		<br/>   --%>
		
	<%-- 	<c:forEach var="product" items="${list}">   
			<c:if test="${product.productImageExists}">
			</c:if>
			<c:choose>
				<c:when test="${product.productId} =false">
				<tr><td></td><td>${product.productId}</td><td>${product.productName}</td><td>${product.productDescription}</td></tr>
				</c:when>
		
			<c:otherwise>
				<tr><td>${product.productImageExists}</td><td>${product.productId}</td><td>${product.productName}</td><td>${product.productDescription}</td></tr>
			</c:otherwise>
			 </c:choose>
			
			</c:forEach> 
		</table> 
		<br/> --%>
		
		<c:forEach var="product" items="${list}">   
<%-- 			<c:if test="${product.productImageExist}">
				<tr><td><img src="/apnidukan/resources/noimage.jpg" alt="Smiley face" width="50" height="50"></td><td>${product.productId}</td><td>${product.productName}</td><td>${product.productDescription}</td></tr>
			</c:if>	
			
			<c:if test="${product.productImageExists}">
				<tr><td>true</td><td>${product.productId}</td><td>${product.productName}</td><td>${product.productDescription}</td></tr>
			</c:if>	 --%>
				<c:choose>
					<c:when test="${product.productImageExists}">
						<tr><td><img src="<c:url value='/resources/static/images/${product.productId}/download.jpg'/>" alt="Smiley face" width="50" height="50"></td><td>${product.productImageExists}</td><td>${product.productId}</td><td>${product.productName}</td><td>${product.productDescription}</td></tr>
					</c:when> 
		
				<c:otherwise>					
					<tr><td><img src="/apnidukan/resources/static/images/noimage.jpg" alt="Smiley face" width="50" height="50"></td><td>${product.productImageExists}</td><td>${product.productId}</td><td>${product.productName}</td><td>${product.productDescription}</td></tr>
				</c:otherwise>
			 
				</c:choose>		
			</c:forEach> 
		</table> 
		<br/>
		
		<%
			if(session.getAttribute("searchFieldController") != null){
				String searchFieldValue = (String) session.getAttribute("searchFieldController");
				int pageCounter = (int)session.getAttribute("totalPages");
				StringBuilder strBuild = new StringBuilder();
				
				
				int pageNO =  1;
				
				while(pageCounter!=0){
					strBuild.append("<a href='/apnidukan/admin/searchproduct/"+pageNO+"?searchfield="+searchFieldValue+"'>"+pageNO+"</a>");
					++pageNO;
					--pageCounter;
				}
				out.print(strBuild.toString());
			}
		
			
			else
			{
		%>
			<a href='/apnidukan/admin/searchproduct/1?searchfield='>1</a>   
			<a href='/apnidukan/admin/searchproduct/2?searchfield='>2</a>  
			<a href='/apnidukan/admin/searchproduct/3?searchfield='>3</a> 
	<%
			}
		}
	%>
		
	</form>
</body>
</html>