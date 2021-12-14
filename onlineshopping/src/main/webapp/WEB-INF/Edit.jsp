<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{
background-image:url("https://static2.bigstockphoto.com/9/1/9/large1500/91906631.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: 100% 100%;
}
</style>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<center>
<form:form action="/onlineshopping/editform" modelAttribute="pd"  method="post">  
		<form:hidden path="id"/>
        Quantity:<form:input type="number" path="Quantity"/>
        <br><br>
        <input type="submit" value="save">  
</form:form>
</center>
</body>
</html>