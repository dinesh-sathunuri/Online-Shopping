<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
   -->
<style>
body{
  background-image:url("https://www.cidrap.umn.edu/sites/default/files/public/styles/ss_media_popup/public/media/article/white_pills_on_blue-marco_verch.jpg?itok=xaMmTBg7");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: 100% 100%;
}
.navbar {
  overflow: hidden;
    background-color: slateblue;
    border-radius: 15px;
    }

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: right;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}


.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
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
background-color:  dodgerblue;
    color: white;
    padding: 17px 20px 19px 315px;
    border-radius: 15px;
    margin-top: inherit;
}
.cart{
color: aquamarine;
    background-color: black;
    border-radius: 30px;
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
</style>
</head>
<body>
<div class="navbar">
  
 		<strong><center><h1 style="color:white";"font:75px">Online Shopping</h1></center></strong>
  <div class="dropdown">
    <button class="dropbtn">MY ACCOUNT 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="historypage">History</a>
      <% String user1=(String) request.getSession().getAttribute("user");
  if(!(user1.substring(0,5).equals("admin"))){%><a href="checkoutpage">Checkout</a><%} %>
      <a href="logout">logout</a>
    </div>
  </div> 
  <div class="dropdown">
 <%if(!user1.substring(0,5).equals("admin")){%><button class="dropbtn" ><i class="fa fa-shopping-cart"></i><i id="cartnumber">0</i></button><%} %>
  </div>
  </div>
  
   <!-- <div class="container">
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
  
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  
  <div class="carousel-inner">
    <div class="item active">
      <img src="https://i2.wp.com/www.yesmagazine.org/wp-content/uploads/imports/70643c27a9db4c3b9d219591e0473fe4.jpg?fit=1400%2C840&quality=90&ssl=1" 
      alt="Fashion">
      <div class="carousel-caption">
        <h3>Fashion</h3>
      
      </div>
    </div>

    <div class="item">
      <img src="https://images.techhive.com/images/article/2014/12/macbook_air-100538062-large.jpg"
      alt="Electronics">
      <div class="carousel-caption">
        <h3>Electronics</h3>
      
      </div>
    </div>

    <div class="item">
      <img src="https://i1.wp.com/www.yesmagazine.org/wp-content/uploads/2020/06/online-groceries-equity-gap-coronavirus.jpg?fit=1400%2C840&quality=90&ssl=1"
      alt="Grocery">
      <div class="carousel-caption">
        <h3>Grocery</h3>
        
      </div>
    </div>
  </div>

  
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
 </div>  
  -->
  <%if(user1.substring(0,5).equals("admin")) {%>
   <section>
  <table id="showing">
<tr>
<th>Product Id</th>
<th>Product Photo</th>
<th>Product Name</th>
<th>Total Quantity</th>
<th>Product Amount</th>
<th>Edit</th>
</tr><tr>
</tr>
<c:forEach var="pr" items="${product}">
<tr>
<td><center>${pr.id}</center></td>
<td><center><img src=${pr.link} style="width:300px;height:300px;"></center></td>
<td><center>${pr.name}</center></td>
<td><center><input type="number" min=0 value="${pr.quantity}"></center></td>
<td><center>${pr.amount}</center></td>
<td><center><a href="editproduct/${pr.id}">EDIT</center></td>
</c:forEach>    
</table>
<td></td><td></td><td class="cart"><center><button onClick="location.href='addproduct.jsp'">ADD THE PRODUCT</button></center></td><td></td><td></td><td></td>
  </section>
  <%}
  else
  {%>
  <section>
  <table id="showing">
<tr>
<th>Product Photo</th>
<th>Product Name</th>
<th>Product Amount</th>
<th>Add to Cart/Remove from Cart</th>
</tr><tr>
</tr>
<c:forEach var="pr" items="${product}">
<tr>
<c:if test="${pr.quantity>0}">
<td><center><img src=${pr.link} style="width:300px;height:300px;"></center></td>
<td><center>${pr.name}</center></td>
<td><center>${pr.amount}</center></td>
<td><center><button id=${pr.id} class="cart" onclick="cartinto(${pr.id})">Move to Cart</button></center></td>
</c:if>
</tr>
</c:forEach>    
</table>
  </section>
  <%} %>
  <script type="text/javascript">
  var old=JSON.parse(sessionStorage.getItem('id'));
  if(old!=null)
	{
	  document.getElementById("cartnumber").innerHTML=old.length;
old.forEach(myfunction);
	}
function myfunction(i) {
	document.getElementById(i).innerHTML="Remove from Cart";
	}
function cartinto(i)
{	
	if(document.getElementById(i).innerHTML=="Move to Cart")
		{
		document.getElementById(i).innerHTML="Remove from Cart";
		
		if(sessionStorage.getItem("id")==null)
			{
			sessionStorage.setItem("id",'[]');
			}
		var old=JSON.parse(sessionStorage.getItem('id'));
        old.push(i);
        document.getElementById("cartnumber").innerHTML=old.length;
        sessionStorage.setItem('id',JSON.stringify(old));
        alert("Added to Cart");
        document.cookie = i+"=1";
		}
		
	else
		{
		deletevar=JSON.parse(sessionStorage.getItem("id"));
		sessionStorage.removeItem(i);
	document.cookie= i+"=0";
		const index = deletevar.indexOf(i);
	
		if (index > -1) {
			deletevar.splice(index, 1);
		}
		document.getElementById("cartnumber").innerHTML=deletevar.length;
         sessionStorage.setItem('id',JSON.stringify(deletevar));
		document.getElementById(i).innerHTML="Move to Cart";
		alert("Removed from cart");
		}
}

</script>
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>  -->
</body>
<footer>
<Strong><marquee style="color:white";"font:45px">Electronics,Home&Furniture,Food,Grocery,Fashion,Toys,Appliances,Beauty & PersonalCare,Sports,India's Heritage</marquee></Strong>
</footer>
</html>