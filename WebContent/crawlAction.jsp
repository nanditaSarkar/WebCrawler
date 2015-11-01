<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
 <%@ page import="com.verizon.crawler.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard view </title>
</head>
<%

String url=request.getParameter("crawlUrl");
String searchWord=request.getParameter("crawlWord");

ArrayList result=null;
CrawlerTest obj=new CrawlerTest();
result=obj.crawl(url, searchWord);
%>
<body style="background-color:lightgrey">
<div name="UrlBody" align="center" style="margin-top:10%;border:1px solid lightred;margin-left:10%;margin-right:10%;">
<div><h1>Crawl Audited  Pages details</h1></div>
<%
if(result!=null)
{
%>
<table border=1 cellpadding="20" style="width:70%">
<thead> 
<th> PAGES </th>
<th>WORD</th>
<th>COUNT</th>

</thead>
<tbody>
<%
/*for (int i=0;i<result.size();i++)
{
ArrayList individualResult= (ArrayList)result.get(i);
if(individualResult!=null)
{*/

for (int j=0;j<result.size();j++)
{
	CrawlerBean m =(CrawlerBean)result.get(j);
	

%>
<tr>
<td> <%=m.getUrl() %> </td>
<td> <%=m.getWord() %> </td>
<td> <%=m.getCount() %> </td>
</tr>
<%
}
}
//}
//}
%>
</tbody>
</table>

</div>
</body>
</html>