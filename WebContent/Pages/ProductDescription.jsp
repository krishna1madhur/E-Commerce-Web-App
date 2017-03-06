<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="com.ecommerce.domain.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
<script type="text/javascript">
function validate(){
var categId = document.getElementById("categoryId").value;
var prodId = document.getElementById("productId").value;
var returnValue=true;

	if(categId >0 && categId <=6){
	 document.getElementById("errorname").innerHTML=" ";
   
   	}else{
	 document.getElementById("errorname").innerHTML="Please provide valid category Id!";
     returnValue= false;
	 
   	}
   	
   	if((prodId >= 101 && prodId <=104)||(prodId >= 201 && prodId <=203)||(prodId >= 301 && prodId <=302)||(prodId >= 401 && prodId <=403)||(prodId >= 501 && prodId <=503)||(prodId >= 601 && prodId <=603)){
	 document.getElementById("errorname1").innerHTML=" ";
   
   	}else{
	 document.getElementById("errorname1").innerHTML="Please provide valid product Id!";
     returnValue= false;
	 
   	}
  	
}
</script>
</head>
<body>
<form onsubmit="return validate();" action="Items.km" method="post">
	<%! List<Object> categList = null;
		List<Object> prodList = null;
		Category category = null;
		Product product = null;
		Iterator<Object> iterate = null;
	%>
	<h3>Welcome ${sessionScope.userIdN },</h3>
	
	<hr color="black"/>
	
	<h3>Select Category and Description</h3>
	<table align="left" bordercolor="black">
		
		<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		</tr>
		<%categList = (List<Object>) session.getAttribute("categList"); 
		iterate = categList.iterator();
		while (iterate.hasNext()) {
			category = (Category) iterate.next();
		%>		
		<tr>
		<td><%=category.getCategoryId()%></td>
		<td><%=category.getCategoryName()%></td>
		<td><%=category.getCategoryDescription()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<br>
	<br>
	<hr>
	
	<h3>Product details for selected Category</h3>
	<table align="left" bordercolor="black">
		
		<tr>
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Desc</td>
		</tr>
		<%prodList = (List<Object>) session.getAttribute("prodList"); 
		iterate = prodList.iterator();
		while (iterate.hasNext()) {
			product = (Product) iterate.next();
		%>		
		<tr>
		<td><%=product.getProductId()%></td>
		<td><%=product.getProductName()%></td>
		<td><%=product.getProductDescription()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>
	
	<h3>Please provide the Category Id and Product ID</h3>
	<table align="left">
		<tr>
			<td align="left">Caregory ID</td>
			<td><input type="text" name="text_categoryId"></td>
			<td><span id="errorname" style="color: red"></span></td>
			<td><input type="hidden" name="cust_id" value="${sessionScope.userIdN }"></td>
		</tr>
		<tr>
			<td align="left">Product ID</td>
			<td><input type="text" name="text_productId"></td>
			<td><span id="errorname1" style="color: red"></span></td>
		</tr>
		<tr>
   			<td align="right"></td>
   			<td><input type="submit" value="Submit" /></td>
   			
 		</tr>
	</table>
</form>
</body>
</html>