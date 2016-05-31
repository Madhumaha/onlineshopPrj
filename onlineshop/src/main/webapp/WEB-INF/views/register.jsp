<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>REGISTER PAGE</title>
</head>
<body bgcolor="gray">
	<div class="container">
		<div>
			<h1 style="color:red;">Enter Details to Register</h1>
		</div>
		<div>
			<form:form commandName="cs" class="form-horizontal" action="addc" method="post">
  				<div class="form-group">
    				<label for="cusName">NAME: </label>
    				<form:input type="text" class="form-control" path="cusName"/>
    				<span style="color: #ff0000">${usernameMsg}</span>
    				<form:errors path="cusName" cssStyle="color: #ff0000"/>
 	 			</div>
				<div class="form-group">
    				<label for="cusPhone">PHONE NO: </label>
    				<form:input type="text" class="form-control" path="cusPhone"/>
    				
 	 			</div>
				<div class="form-group">
    				<label for="cusAdrs">ADDRESS: </label>
    				<form:input type="text" class="form-control" path="cusAddr"/>
 	 			</div>
				<div class="form-group">
    				<label for="cusEmail">EMAIL ID: </label>
    				
    				<form:input type="text" class="form-control" path="cusEmail"/>
    				<span style="color: #ff0000">${emailMsg}</span>
    				<form:errors path="cusEmail" cssStyle="color: #ff0000"/>
 	 			</div>
 	 			
 	 			 	 			
				
  				<div class="form-group">
    				<label for="cusPwd">PASSWORD:</label>
    				<form:input type="password" class="form-control" path="cusPwd"/>
    				<form:errors path="cusPwd" cssStyle="color: #ff0000"/>
  				</div>
  				<button type="submit" class="btn btn-default">REGISTER</button>
  			</form:form>
    	</div>
	</div>
	<br><br> 
	<br><br>
	
</body>
</html>