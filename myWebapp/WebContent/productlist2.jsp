<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Products</title>
</head>
<body>

	<table border=3>
		<tr>
			<th>Id</th>

			<th>Name</th>

			<th>Price</th>

			<th>Qoh</th>
		</tr>
		<c:forEach var="p" items="${productlist}">
			<tr>
				<td>${p.ind}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td>${p.qoh}</td>
				<td><input type="checkbox" name="send" value="${p.ind}">
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>