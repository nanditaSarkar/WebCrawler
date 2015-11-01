<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.verizon.crawler.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="background-color:lightgrey">
<div name="sample" align="center">
<%String maskableValue=request.getParameter("maskText");
MaskAlgorithm obj=new MaskAlgorithm();
String maskedValue=obj.encrypt(maskableValue);
%>
<div><h1>Result of Crawling Algorithm</h1></div>
<table border=1 cellpadding="20" style="width:70%">
<tr>
<td>
Enter the value
</td>
<td>
<input type="text" name="maskableText" value="<%=maskableValue %>">
</td>
</tr>

<tr>
<td>
Masked Value
</td>
<td>
<input type="text" name="maskedText" value="<%=maskedValue %>">
</td>
</tr>

</table>
</div>
</body>
</html>