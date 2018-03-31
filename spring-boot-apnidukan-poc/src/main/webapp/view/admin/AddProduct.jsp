<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">   </script>
<script>
	$(document).ready(function(){
		 alert("document is loaded");
		 
		 $.ajax({
	            type: "POST",
	            url: "/apnidukan/category/pullcategory",
	            success: function(data)
	            {
	                helpers.buildDropdown(
	                    jQuery.parseJSON(data),
	                    $('#categoryId'),
	                    'Select an option'
	                );
	               console.log(data);
	            }
	        });
	});	
	
	var helpers =
	{
	    buildDropdown: function(result, categoryId, emptyMessage)
	    {
	        // Remove current options
	        categoryId.html('');
	        // Add the empty option with the empty message
	        categoryId.append('<option value="">' + emptyMessage + '</option>');
	        // Check result isnt empty
	        if(result != '')
	        {
	            // Loop through each of the results and append the option to the dropdown
	            $.each(result, function(k, v) {
	            	categoryId.append('<option value="' + v.categoryId + '">' + v.categoryName + '</option>');
	            });
	        }
	    }
	}
</script>
<title>Add Products</title>
</head>
<body>
<form method="POST" action="/apnidukan/admin/add" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td>
				Name:
			</td>
			
			<td>
				<input type="text" name="productName">
			</td>
			
		</tr>
		
		<tr>
			<td>
				Description:	
			</td>
			
			<td>
				<textarea name="productDescription" rows="6" cols="25">
					
				</textarea>
			</td>			
		</tr>
		
		<tr>
			<td>
				Total number of Items:
			</td>
			
			<td>
				<input type="text" name="productNumItems">
			</td>			
		</tr>
		
		<tr>
			<td>
				Archived:
			</td>			
			<td>
				<select name="productArchived">
 					<option value="false">No</option>
  					<option value="true">Yes</option>
				</select>
			</td>
			
		</tr>
		
		<tr>
			<td>
				Price per Unit:
			</td>				
			<td>
				<input type="text" name="productPrice">
			</td>
			
		</tr>
		
		<tr>
			<td>
				Category:
			</td>			
			<td>				
				<select name="categoryId" id="categoryId"></select>
			</td>
			
		</tr>
		
		<tr>
			<td>
				Type:
			</td>
			
			<td>
			
			</td>
			
		</tr>
		
		<tr>
			<td>
				Add Images of the Product:
			</td>
			
			<td>
				<input type="file" name="productImages" size="30" />
			</td>
			
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Submit the Data" />
			</td>
		</tr>
		
		
	</table>
</form>
</body>
</html>