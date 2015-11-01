<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Webcrawler Analysis Portal</title>
</head>
<style>
.user-pwd-div
{
width:200px;
margin:auto;    
}

.userMenu
{

border:5px solid lightred;
scroll-y:on;
padding: 15px 0 0 0;
spacing: 15px 0 0 0;
text-align: left;
line-height: 0.2em;
}

.header
{
height:40%%;
width:100%;
text-align:center;
background-color:light yellow;
margin-bottom:500px;

}
</style>
<%
String relPath=request.getContextPath();
System.out.println("The Context path is"+relPath);
%>
<body  >
<div name="Pageheader" class="header" >
<h1>Customer Information Portal </h1>
</div>
<div name="userLayout" align="left" class="userMenu">
<h1><a href="SSNinfo.jsp">User Profile</h1><br>
<h1><a href="Creditcardinfo.jsp">Payment Details</h1><br>
<h1><a href="Phonenumber.jsp">Contact Details</h1><br>



</div>

</body>
</html>