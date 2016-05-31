<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Result</title>
</head>
<body>
    <center>
        <h2>${message}</h2>
    </center>
    <div class="col-sm-10">
<a href="<spring:url value="/admin/addProduct" />" class="btn btn-danger margin-left25">Submit to add the product</a>
</div>
    
</body>
</html>