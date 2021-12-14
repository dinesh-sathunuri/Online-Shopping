
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{
  background-image:url("https://www.cidrap.umn.edu/sites/default/files/public/styles/ss_media_popup/public/media/article/white_pills_on_blue-marco_verch.jpg?itok=xaMmTBg7");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: 100% 100%;
}
.navbar {
  overflow: hidden;
    background-color: dodgerblue;
    border-radius: 15px;
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
</style>
</head>
<body>
<div class="navbar">
 <strong style="color:white;float:center;font-size:35px;padding:2px;margin:2px"><center>Check Out<center></strong></div>
 <button onclick="previous()" style="
    padding: 5px;
    /* position: absolute; */
    /* text-indent: 0px; */
    /* padding: 5px 0 5px 10px; */
    width: 73px;/* modified by label length */
    overflow: auto;
    color: black;
    border-radius: 5px;
    background-color: greenyellow;
">&laquo; Previous</button>
<section>
<form action="intoorderdao" onsubmit="return fun()">
<table id="showing">
<tr>
<th>Product Name</th>
<th>Product Quantity</th>
<th>Product Amount</th>
<th>Total Amount</th>
<th>Delete</th>
</tr>
<%int totalsum=0; %>
<c:forEach var="pr" items="${product}">
<tr>
<td>${pr.name}</td>
<td><input type="number" min="1" max="${pr.quantity}" id="${pr.id }" name="quantity${pr.id}" value="1" onclick='quantity(${pr.id})'></td>
<td id="intial${pr.id}">${pr.amount}</td>
<td><p id="output${pr.id}">${pr.amount}</p></td>
<td><input type="button" onclick='delitem(${pr.id})' style="color:red" value="delete"></td>
</tr>
</c:forEach>
<%-- <tr><td></td><td></td><td><b>Total Amount :</b></td><td id="totalsum">${totalsum}</td><td></td></tr>  --%>
</table>
<center><input type="submit"></center>
</form>
</section>
<script type="text/javascript">
function fun()
{
	sessionStorage.removeItem('id');
}
function quantity(i)
{
	value=document.getElementById(""+i+"").value;
	txt="output"+i;
// 	sum=document.getElementById("totalsum").textContent;
	intialamount=document.getElementById("intial"+i).textContent;
	totalamount=document.getElementById(txt).textContent;
// 	sum=sum-totalamount;
// 	sum=sum+intialamount*value;
	document.getElementById(txt).innerHTML=intialamount*value;
// 	document.getElementById("totalsum").innerHTML=sum;
}
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
function delitem(i)
{
	deletevar=JSON.parse(sessionStorage.getItem("id"));
// 	sum=document.getElementById("totalsum").textContent;
// 	amount=document.getElementById("output"+i).textContent;
document.cookie= i+"=0";
	const index = deletevar.indexOf(i);
	if (index > -1) {
		deletevar.splice(index, 1);
	}
// 	document.getElementById("totalsum").innerHTML=sum-amount;
     sessionStorage.setItem('id',JSON.stringify(deletevar));
     location.replace("checkoutpage");
  
}
</script>
</body>
</html>