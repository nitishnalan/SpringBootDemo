<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  
  <script type="text/javascript">
	function validate(productId){
		console.log(productId);
		console.log("/apnidukan/product/summary/"+productId);
		document.getElementById("search").action = "/apnidukan/product/summary/"+productId;
		document.getElementById("search").submit();
	}
	</script>
<title>Apnidukan Page</title>
</head>
<body>
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
<!-- 	</form>
	
	<form id = "displayResults" name="displayResults" action="/apnidukan/product/search/1" method="GET"> -->
	<%
		String flag = "";
		if(session.getAttribute("foundResults") != null){
			flag = (String) session.getAttribute("foundResults");
		}
		System.out.println("flag : " + flag);
	
		if(flag.equals("true")){
			out.print("<h1>Product Search List</h1>");  
			out.print("<table border='2' width='70%' cellpadding='2'>"); 
			out.print("<tr><th>Image Present</th><th>Id</th><th>Name</th><th>Description</th></tr>");  
			
	%>
			<c:forEach var="product" items="${list}">   
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
			
			
			
  				<h2>Cards with Contextual Classes</h2>
  				<div class="container"> 
  				<c:forEach var="product" items="${list}">
  				
  				  <div class="card bg-light text-dark">
  				  	<div class="row" onclick="validate('${product.productId}')">
  				  		<div class="col-lg-3 col-md-3 col-sm-3" >
  				  		<c:choose>
  				  			<c:when test="${product.productImageExists}">
  				  				<img src="<c:url value='/resources/static/images/${product.productId}/${product.productImageName}'/>" class="img-thumbnail" margin-left ="auto"  margin-right= "auto" alt="Product Image">
    						</c:when>
    					
    						<c:otherwise>
  				  				<img src="/apnidukan/resources/static/images/noimage.jpg" class="img-thumbnail" class="center" alt="Product Image">
    						</c:otherwise>
    					</c:choose>
    				</div>
    				
    					<div class="col-lg-8 col-md-8 col-sm-8">
    						 <table class="table table-striped">
    						 	<tr><td>Name : </td><td>${product.productName}</td></tr>
    							<tr><td>Description : </td><td>${product.productDescription}</td></tr>			 	
    							<tr><td>Number of Items : </td><td>${product.productNumItems}</td></tr>
    							<tr><td>Price : </td><td>${product.productPrice}</td></tr>
    						 </table>
    						
    					</div>
  				</div>
  				
  				<br/>
  				
  				</c:forEach> 
  				<br/>
  				</div>
				</div>
		
		<%
			if(session.getAttribute("searchFieldController") != null){
				String searchFieldValue = (String) session.getAttribute("searchFieldController");
				int pageCounter = (int)session.getAttribute("totalPages");
				StringBuilder strBuild = new StringBuilder();
				
				
				int pageNO =  1;
				
				while(pageCounter!=0){
					strBuild.append("<li><a href='/apnidukan/product/search/"+pageNO+"?searchfield="+searchFieldValue+"' class='btn btn-warning'>"+pageNO+"</a></li> &nbsp");
					++pageNO;
					--pageCounter;
				}
				/* out.print("<a href='/apnidukan/admin/searchproduct/1?searchfield="+searchFieldValue+"'>1</a>");   
				out.print("<a href='/apnidukan/admin/searchproduct/2?searchfield="+searchFieldValue+"'>2</a>");  
				out.print("<a href='/apnidukan/admin/searchproduct/3?searchfield="+searchFieldValue+"'>3</a>");  */
				out.print("<br/>");
				out.print("<ul class='pagination'>");
				out.print(strBuild.toString());
				out.print("</ul>");
				
			}
		
			
			else
			{
		%>
			<a href='/apnidukan/product/search/1?searchfield='>1</a>   
			<a href='/apnidukan/product/search/2?searchfield='>2</a>  
			<a href='/apnidukan/product/search/3?searchfield='>3</a> 
	<%
			}
		}
	%>
	
	</form>
	
	
</body>
</html>