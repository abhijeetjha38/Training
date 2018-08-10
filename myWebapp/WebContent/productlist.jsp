<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.*,com.visa.training.domain.*"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Products </title>
</head>
<body>
	<% 
		List<Product>all =( List<Product> ) request.getAttribute("productlist");
	%>
	<table border = 3 >
		<tr>
			<th>
				Id
			</th>
			
			<th>
				Name
			</th>
			
			<th>
				Price
			</th>
			
			<th>
				Qoh
			</th>
			</tr>
			<%
			for(Product p:all)
			{
			%>
				<tr>
					<td> <%= p.getInd() %> </td>
					<td> <%= p.getName() %> </td>
					<td> <%= p.getPrice() %> </td>
					<td> <%= p.getQoh() %> </td>
					<td> <input type="checkbox" name="send" value="<%= p.getInd() %>"> </td>
				</tr>
			<%
			}
			%>
			
	</table>
</body>
</html>