<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Summary</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
</head>
<body>
	<h3>Welcome ${sessionScope.cust},</h3>
	<hr color="black"/>
	<table>
		<tr>
				<td>Order ID</td>
				<td><%=session.getAttribute("orderid1") %></td>
			</tr>
			<tr>
				<td>Item Name</td>
				<td><%=session.getAttribute("itemName1") %></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><%=session.getAttribute("itemPrice1") %></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><%=session.getAttribute("quantity1") %></td>
			</tr>
			<tr>
				<td>Total Price</td>
				<td><%=session.getAttribute("totalPrice1") %></td>
				
			</tr>
			
	</table>
	<h3>Thanks for choosing us.</h3>
</body>
</html>