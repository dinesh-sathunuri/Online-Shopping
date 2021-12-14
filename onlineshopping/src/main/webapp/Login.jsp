<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
body{
  background-image:url("https://www.cidrap.umn.edu/sites/default/files/public/styles/ss_media_popup/public/media/article/white_pills_on_blue-marco_verch.jpg?itok=xaMmTBg7");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: 100% 100%;
}
.nam{
	padding: 10px 10px;
    font-size: 15px;
    line-height: 15px;
    border-radius: 4px;
    border-width: 1px;
    border-top-width: 1px;
    border-right-width: 1px;
    border-bottom-width:1px;
    border-left-width: 1px;
}
.sub
{
padding: 6px 80px;
    font-size: 15px;
    border-radius: 5px;
    background-color: #4aabff;
}
</style>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br><br>
<script type="text/javascript">
function myFunction() {
	  var x = document.getElementById("pass");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
function fun()
{
	

	
var user=document.getElementById("name").value;
var pass=document.getElementById("pass").value;
if(user!="admin12345")
	{
	deletevar=JSON.parse(sessionStorage.getItem("id"));
	if(deletevar!=null)
		{
	for(i=0;i<deletevar.length;i++)
		{
		document.cookie= deletevar[i]+"=0";
		}
		}
	sessionStorage.removeItem('id');
	}
if(user.length==0)
{
alert("Invalid Login");
return false;
}
if(pass.length==0)
{
alert("Enter the Password");
return false;
}

	}
</script>
<form action="login" onsubmit="return fun()" method="get">	
<center>LOGIN</center><br>
<center><input type=text name="name" placeholder="User name" class="nam" id="name"></center><br>
<center><input type=password  name="password" placeholder="Password" class="nam" id="pass"></center>
<center><input type="checkbox" onclick="myFunction()">Show Password</center><br>
<center><button type=submit  class="sub">LOGIN</center>	
</form>
<center><p>Does not have account ?
<a href="register">Sign Up</a></p></center>
</body>
</html>