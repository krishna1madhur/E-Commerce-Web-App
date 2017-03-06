<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="com.ecommerce.domain.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Display Categories</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">

<script type="text/javascript">
function validate(){
var categId = document.getElementById("categoryId").value;
var returnValue=true;

	if(categId >0 && categId <=6){
	 document.getElementById("errorname").innerHTML=" ";
   
   	}else{
	 document.getElementById("errorname").innerHTML="Please provide valid category Id!";
     returnValue= false;
	 
   	}
  	
}
</script>
</head>
<body>

<form onsubmit="return validate();" action="ProductDescription.km" method="post">
	<%! List<Object> list = null;
		Category category = null;	
		Iterator<Object> iterate = null;
	%>
	<h3>Welcome ${sessionScope.custid},</h3>
	<hr color="black"/>
	
	<h3>Categories and Description</h3>
	<table align="center" bordercolor="black">
		
		<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		</tr>
		<%list = (List<Object>) session.getAttribute("categList"); 
		iterate = list.iterator();
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
	<h3>Please Select the Category Id</h3>
	<table align="left">
		<tr>
			<td align="left">Caregory ID</td>
			<td><input type="text" name="text_categoryId" id="categoryId"></td>
			<td><span id="errorname" style="color: red"></span></td>
			<td><input type="hidden" name="user_name" value="${sessionScope.custid}"></td>
		</tr>
		<tr>
   			<td align="right"></td>
   			<td><input type="submit" value="Submit" /></td>
 		</tr>
	</table>
</form>
</body>
</html>