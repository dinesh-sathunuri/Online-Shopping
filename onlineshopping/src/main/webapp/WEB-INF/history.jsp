<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
section
{
background-color: ghostwhite;
    padding: 35px 35px 401px 36px;
    margin-top: inherit;
    border-radius: 18px;
    box-sizing: border-box;
}
footer
{
background-color:  darkgrey;
    color: white;
    padding: 17px 20px 19px 315px;
    border-radius: 15px;
    margin-top: inherit;
}
#showing {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  boarder-radius:5px
}

#showing td, #showing th {
  border: 1px solid #ddd;
  padding: 8px;
}

#showing tr:nth-child(even){background-color: #f2f2f2;}

#showing tr:hover {background-color: #ddd;}

#showing th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
body{
background-image:url("https://www.cidrap.umn.edu/sites/default/files/public/styles/ss_media_popup/public/media/article/white_pills_on_blue-marco_verch.jpg?itok=xaMmTBg7");
 background-size: 100% 100%;
}
.navbar {
  overflow: hidden;
    background-color: dodgerblue;
    border-radius: 15px;
    }
</style>
</head>
<body>
<div class="navbar">
 <strong style="color:white;float:center;font-size:35px;padding:2px;margin:2px"><center>Orders History<center></strong></div>
 <button onclick="previous()" style="
    padding: 5px;
    overflow: auto;
    color: black;
    border-radius: 5px;
    background-color: greenyellow;
">&laquo; Home </button>
<%String user=(String) request.getSession().getAttribute("user");
if(user.substring(0,5).equals("admin")){
%>
<section>
<table id="showing">
<tr>
		<th>orderId</th>
		<th>productId</th>
		<th>Quantity</th>
		<th>TotalAmount</th>
		<th>UserName</th>
		<th>Purchased Dated</th>
		<th>Status</th>
</tr>
<c:forEach var="ord" items="${order}">
<c:if test="${ord.status==0}">
<tr>
<td>${ord.orderid}</td>
<td>${ord.productid}</td>
<td>${ord.quatity}</td>
<td>${ord.amount}</td> 
<td>${ord.username}</td>
<td>${ord.datecreated}</td>
<td><button><a href="approve/${ord.orderid}">Approve</a></button>
<button><a href="reject/${ord.orderid}">Reject</a></button>
</td>
</tr>
</c:if>
</c:forEach>
<c:forEach var="ord" items="${order}">
<c:if test="${ord.status!=0}">
<tr>
<td>${ord.orderid}</td>
<td>${ord.productid}</td>
<td>${ord.quatity}</td>
<td>${ord.amount}</td> 
<td>${ord.username}</td>
<td>${ord.datecreated}
<td><c:if test="${ord.status==1}">
Approved
</c:if>
<c:if test="${ord.status==2}">
Rejected
</c:if>
</td>
</tr>
</c:if>
</c:forEach>
</table>
</section>
<%}
else
{%>
<section>
<table id="showing">
<tr>
		<th>productId</th>
		<th>Quantity</th>
		<th>TotalAmount</th>
		<th>UserName</th>
		<th>Purchased Dated</th>
		<th>Status</th>
</tr>
<c:forEach var="ord" items="${order}">
<tr>
<td>${ord.productid}</td>
<td>${ord.quatity}</td>
<td>${ord.amount}</td>
<td>${ord.username}</td>
<td>${ord.datecreated}
<td><c:if test="${ord.status==1}">
Approved
</c:if>
<c:if test="${ord.status==2}">
Rejected
</c:if>
<c:if test="${ord.status==0}">
Pending
</c:if>
</td>
</tr>
</c:forEach>
</table>
</section>
<%} %>
<script>
function previous()
{
// 	deletevar=JSON.parse(sessionStorage.getItem("id"));
// 	if(deletevar!=null)
// 		{
// 	for(i=0;i<deletevar.length;i++)
// 		{
// 		document.cookie= deletevar[i]+"=0";
// 		}
// 		}
// 	sessionStorage.removeItem('id');
	location.replace("homepage");
	
	
	
}
</script>
</section>
<footer></footer>
</body>
</html>