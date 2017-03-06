<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="com.ecommerce.domain.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Page</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
</head>
<body>
<%!
List<Object> itemList = null;
Iterator<Object> iterate = null;
Item itemObj = null;
%>
	<h3>Welcome ${sessionScope.cust_id1},</h3>
	<hr color="black"/>
	
		<h3>Order Summary</h3>
		<table align="left" border="1" bordercolor="black">
			<tr>
				<td>Order ID</td>
				<td><%=session.getAttribute("orderid") %></td>
			</tr>
			<tr>
				<td>Item Name</td>
				<td><%=session.getAttribute("itemName") %></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><%=session.getAttribute("itemPrice") %></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><%=session.getAttribute("quantity") %></td>
			</tr>
			<tr>
				<td>Total Price</td>
				<td><%=session.getAttribute("totalPrice") %></td>
				
			</tr>

			
			
		</table>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>	
	
	<h3>Please select the mode of payment</h3>
	<form action="Success.jsp">
		
		<table align="left">
			<tr>
   				<td align="right"></td>
   				<td><input type="submit" value="Cash on Delivery" /></td>
   				
 			</tr>
		</table>
	</form>
	<form action="ErrorPage.jsp" >
		
		<table align="left">
			<tr>
   				<td align="right"></td>
   				<td><input type="submit" value="E-Payment" /></td>
 			</tr>
		</table>
	</form>
</body>
</html>