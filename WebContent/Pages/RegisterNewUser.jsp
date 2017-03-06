<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New User</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
<script type="text/javascript">
	function validate(){
		var custId = document.getElementById("custId").value;
		var pass = document.getElementById("pass").value;
		var firstN = document.getElementById("firstN").value;
		var lastN = document.getElementById("lastN").value;
		var dateOfBirth  = document.getElementById("dateOfBirth").value;
		var addr = document.getElementById("addr").value;
		var contNo = document.getElementById("contNo").value;
		var ccNo = document.getElementById("ccNo").value;
		var cType = document.getElementById("cType").value;
		var ccED = document.getElementById("ccED").value;
		
		if(custId.length==0){
	    	document.getElementById("errorname").innerHTML="Please provide your Customer ID!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname").innerHTML=" ";
   		}
   		
   		if(pass.length==0){
	    	document.getElementById("errorname1").innerHTML="Please provide your Password!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname1").innerHTML=" ";
   		}
   		
   		if(firstN.length==0){
	    	document.getElementById("errorname2").innerHTML="Please provide your First Name!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname2").innerHTML=" ";
   		}
   		
   		if(lastN.length==0){
	    	document.getElementById("errorname3").innerHTML="Please provide your Last Name!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname3").innerHTML=" ";
   		}
   		
   		if(dateOfBirth.length==0){
	    	document.getElementById("errorname4").innerHTML="Please provide your Date of birth!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname4").innerHTML=" ";
   		}
   		
   		if(addr.length==0){
	    	document.getElementById("errorname5").innerHTML="Please provide your Address!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname5").innerHTML=" ";
   		}
   		
   		if(contNo.length==0){
	    	document.getElementById("errorname6").innerHTML="Please provide your Contact number!";
     		returnValue= false;
   		}else if((isNaN(contNo))){
	  	 	document.getElementById("errorzip6").innerHTML="Please provide valid Contact number!";
	   		returnValue= false;
   		}else if(contNo.length !=10){
   			document.getElementById("errorname6").innerHTML="Please provide Valid Contact number!";
     		returnValue= false;
   		}else {
	 		document.getElementById("errorname6").innerHTML=" ";
   		}
   		
   		if(ccNo.length==0){
	    	document.getElementById("errorname7").innerHTML="Please provide your Credit Card Number!";
     		returnValue= false;
   		}else if((isNaN(ccNo ))){
	  	 	document.getElementById("errorzip7").innerHTML="Please provide valid Credit Card number!";
	   		returnValue= false;
   		}else if(ccNo.length !=12){
   			document.getElementById("errorname7").innerHTML="Please provide Valid Credit Card number!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname7").innerHTML=" ";
   		}
   		
   		if(cType.length==0){
	    	document.getElementById("errorname8").innerHTML="Please provide your Card Type!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname8").innerHTML=" ";
   		}
   		
   		if(ccED.length==0){
	    	document.getElementById("errorname9").innerHTML="Please provide your Credit card expiry date!";
     		returnValue= false;
   		}else{
	 		document.getElementById("errorname9").innerHTML=" ";
   		}
		
	}
</script>
</head>
<body>
	<h2 align="center">Enter the Customer Details</h2>
	<form onsubmit="return validate();" action="Search.km" method="post">
		<table align="center">
			
			<%
			String getError = (String) session.getAttribute("errorMsg"); 
			%>
			<tr>
				<td align="left">Customer ID</td>
				<td><input type="text" name="text_custID" id="custId"></td>
				<td><span id="errorname" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Password</td>
				<td><input type="password" name="password_password" id="pass"></td>
				<td><span id="errorname1" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">First Name</td>
				<td><input type="text" name="text_firstName" id="firstN"></td>
				<td><span id="errorname2" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Last Name</td>
				<td><input type="text" name="text_lastName" id="lastN"></td>
				<td><span id="errorname3" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Date of Birth</td>
				<td><input type="text" name="text_dateOfBirth" id="dateOfBirth"></td>
				<td><span id="errorname4" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Address</td>
				<td><input type="text" name="text_address" id="addr"></td>
				<td><span id="errorname5" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Contact Number</td>
				<td><input type="text" name="text_contactNo" id="contNo"></td>
				<td><span id="errorname6" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Credit Card Number</td>
				<td><input type="text" name="text_creditCardNo" id="ccNo"></td>
				<td><span id="errorname7" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Card Type</td>
				<td><input type="text" name="text_cardType" id="cType"></td>
				<td><span id="errorname8" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Credit Card Expiry Date</td>
				<td><input type="text" name="text_creditcardExpiryDate" id="ccED"></td>
				<td><span id="errorname9" style="color: red"></span></td>
			</tr>
			
			<tr>
   				<td align="right"></td>
   				<td><input type="submit" value="Submit" /></td>
 			</tr>
 			
		</table>
	</form>
</body>
</html>