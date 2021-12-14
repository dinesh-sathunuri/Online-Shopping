<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<style>
body{
background-image:url("https://static2.bigstockphoto.com/9/1/9/large1500/91906631.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: 100% 100%;
}
");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: 100% 100%;
}
.sub
{
padding: 6px 40px;
    font-size: 15px;
    border-radius: 5px;
    background-color: #4aabff;
}
</style>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br><br>
<script type="text/javascript">
function check()
{
	var pname=document.getElementById("name").value;
	var pprice=document.getElementById("price").value;
	var pphoto=document.getElementById("photo").value;
	var pquantity=document.getElementById("quantity").value;
	if(pname=="")
		{
		alert("Please Enter The Product name");
		return false;
		}
	if(pprice=="")
		{
		alert("Please Enter The Product Price");
		return false;
		}
	if(pphoto=="")
		{
		alert("Please Enter The Product Image Link");
		
		return false;
		}
	if(pphoto.length>500)
		{
		alert("Please Enter The Product Image Link Length Below 500");
		document.getElementById("photo").InnerHTML="";
		return false;
		}
	alert("Added");
}

</script>
<center><form action="addProducts" onsubmit="return check()" method="post">
<center> <h>Product</h></center><br>
ProductName :<input type="text" name="name"  id="name"><br><br>
Price	:   <input type="text" name="price" id="price"><br><br>
ImageLink:<input type="text" name="photo" id="photo"><br><br>
quantity:<input type="number" name="quantity" min=1 value=1 id="quantity">

<br><input type="submit" value="add" class="sub"></center>

</body>
</html>