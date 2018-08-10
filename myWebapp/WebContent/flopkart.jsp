<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import= "java.util.*,com.visa.training.domain.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 1px solid #555;
    outline: none;
    border-radius : 10px ;
   
}

input[type=text]:focus {
    background-color: lightblue;
}
.button{
align : center ;
border: 2px solid red;
    border-radius: 25px;
    margin : 50px ;
}
.flex-container {
  margin : 20px ;
  padding : 20px ;
  display: flex;
  width : 80 % ;
  align : center ;
  opacity : 30%;
  border: 2px solid red;
  border-radius: 25px;
}
.product {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

.product  td, .product  th {
    border: 1px solid #ddd;
    padding: 8px;
}

.product  tr:nth-child(even){background-color: #f2f2f2;}

.product tr:hover {background-color: #ddd;}

.product th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flopkart</title>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<% 
		List<Product>all =( List<Product> ) request.getAttribute("productlist");
		ArrayList<Product>cart =(ArrayList<Product>)request.getAttribute("cartlist");
	
	%>

	<div class = "flex-container">
	<table class  = "product" border = 3 >
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
			
			<form method = "post" action = "InsertToCart">
			<%
			for(Product p:all)
			{
			%>
				<tr>
					<td> <%= p.getInd() %> </td>
					<td> <%= p.getName() %> </td>
					<td> <%= p.getPrice() %> </td>
					<td> <%= p.getQoh() %> </td>
					<td> <input type="checkbox" name="send" value="<%= p.getInd() %>">select </td>
				</tr>
			<%
			}
			%>
	</table>
	</div>
	<input class = "button" type="submit" value="add to cart" >
	</form>
	
	<br>
	Cart table :
	<div class= "flex-container" >
	<table class = "product" border = 3 >
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
			for(Product p:cart)
			{
			%>
				<tr>
					<td> <%= p.getInd() %> </td>
					<td> <%= p.getName() %> </td>
					<td> <%= p.getPrice() %> </td>
					<td> <%= p.getQoh() %> </td>
				</tr>
			<%
			}
			%>
			
	</table>

	</div>
	<div class ="flex-container" >
	<center>Add product</center> 
	<form method="post" action = "AddNew" onsubmit="return doit1()" class = "">
			name  ::<input id="name" type ="text" name = "name"  > <br><br><br>   
			qoh :: <input id="qoh" type ="text" name = "qoh" >   <br><br><br>
			price :: <input id="price" type ="text" name = "price" >  <br><br><br>
			<input type ="submit"  value ="Add it" > 	
		
	</form>
	</div>
</body>
</html>