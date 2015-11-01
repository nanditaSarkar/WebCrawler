<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data page</title>
</head>
<body>
<%
String userRole=request.getParameter("userRole");
%>

<div name="tableContent" style="background-color:red" align="center">
<table border=1 style="font-size:50px" >
<thead>
<th>Customer Name</th>
<th>SSN</th>
<th>Insurance number</th>
</thead>
<tbody>
<tr>
<td>Sangeetha </td>
<td>9962954789 </td>
<td>5489679765342 </td>
</tr>
<tr>
<td>Arumugam </td>
<td>95555678907 </td>
<td>54896797000345 </td>
</tr>
<td>Nandita </td>
<td>9555578907 </td>
<td>5489679890767 </td>
</tr>

</tbody>
</table>


</div>
</body>
</html>