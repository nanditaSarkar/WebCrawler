<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web crawler</title>
</head>
<body >

<div style="background-color:white;">
<h1><center><font face="verdana" color="Red">Application Crawler</font></center></h1>
</div>
<BR>
<BR>
<div style="background-color:#7D854A;">

<form name="crawlSubmit" action="crawlAction.jsp">
<table>
<tr>
<td>
<CENTER><h2><font face="verdana">URL </font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      &nbsp;&nbsp;&nbsp;&nbsp;        &nbsp;&nbsp;&nbsp;&nbsp;        <input type="text" name="crawlUrl" size="100"></h2></CENTER>
<BR>
</td>
</tr>
<tr>
<td>
<LEFT><h2><font face="verdana">CRAWL WORD </font>  <input type="text" name="crawlWord"></font></h2></LEFT><br>
<br>
</td>
</tr>
<tr>
<td>
<center> <input type="submit" value="Crawl" size="100"><font face="verdana"> </center>
 <br>
 </td>
</tr>
 </table>
</form>



</div>
<BR>
<BR>
<BR>


</div>
	
	
</body>
</html>