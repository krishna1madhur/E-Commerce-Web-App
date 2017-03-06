<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">

<script type="text/javascript">
function validate(){
var uname = document.getElementById("username").value;
var pass = document.getElementById("password").value;
var returnValue=true;

	if(uname.length==0){
	 
     document.getElementById("errorname").innerHTML="Please provide your name!";
     returnValue= false;
   	}else{
	 
	 document.getElementById("errorname").innerHTML=" ";
   	}
   	
   	if(pass.length==0){
	 
     document.getElementById("errorname1").innerHTML="Please provide your password!";
     returnValue= false;
   }else{
	 
	 document.getElementById("errorname1").innerHTML=" ";
   }
   return returnValue ;
}
</script>
</head>
<body>
	<h3 align="center">Enter the Customer ID and Password</h3>
	<form onsubmit="return validate();" action="ValidateUser.km" method="post">
		<table align="center">
			<tr>
				<td align="left">Customer ID</td>
				<td><input type="text" name="text_userName" id="username"></td>
				<td><span id="errorname" style="color: red"></span></td>
			</tr>
			<tr>
				<td align="left">Password</td>
				<td><input type="password" name="password_password" id="password"></td>
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