<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body >

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">OnlieShopping</a>
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
     </ul>
    <ul class="nav navbar-nav navbar-right">
   <li class="divider-vertical"></li>
							   <c:if test="${pageContext.request.userPrincipal.name != null}">
								<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
									<%-- <li><a href="<c:url value="/user/cart" />">Cart</a></li> --%>
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
									 <li><a href="<c:url value="/admin/Product1" />">All Products</a></li>
									<%--  <li><a href="<c:url value="/admin/user" />">View Customer</a></li> --%>
								</c:if>
								<li><a>Hello, ${pageContext.request.userPrincipal.name}</a></li>
									<li><a href="<c:url value="/j_spring_security_logout" />">Sign Out</a></li>
								</c:if>
								 <c:if test="${pageContext.request.userPrincipal.name  == null}">
									<li><a href="<c:url value="/login/" />">Login</a></li>
									<li><a href="<c:url value="/register1" />">Sign Up</a></li>
								</c:if>
     
    </ul>
  </div>
</nav>

<div>
 <!-- <div class="input-group custom-search-form">
                                <input type="text" ng-model="search" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div> -->
<table>
<tr>
<td>
<div  class="container" >
  <h2>Products Categories</h2>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1">Electronics</a>
        </h4>
      </div>
     <div id="collapse1" class="panel-collapse collapse">
      <li><a href="#">Mobile</a></li>
    <li><a href="#">Laptop</a></li>
    </div>
      </div>
      <div class="panel-group">
    <div class="panel panel-default">
 <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse2">Eatables</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
      <li><a href="#">Pizza</a></li>
    <li><a href="#">Chips</a></li>
    </div>
    </div>
    </div>
    
    </div>
    </div>
    </td>
    <td>
<div >
<div class="row">
  <div class="col-md-4">
    <a href="Product?name=1" >
      
      <img src="<c:url value="/resources/images/1.jpg"/>" alt="guitar" style="width:150px;height:150px">
    </a>
  </div>
  <div class="col-md-4">
    <a href="Product?name=2">
     
      <img src="<c:url value="/resources/images/2.jpg"/>" alt="violin" style="width:150px;height:150px">
    </a>
  </div>
  <div class="col-md-4">
    <a href="Product?name=3" >
      
      <img src="<c:url value="/resources/images/3.jpg"/>" alt="piano" style="width:150px;height:150px">
    </a>
  </div>
</div> 
  </div>
 <td>
</table>
<br><br>
</div>
<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
<h1>
 <center><a href="Product?name=all">All Products</a></center>
</c:if>
</h1>
</body>
</html>