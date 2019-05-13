<%-- 
    Document   : addProduct
    Created on : 1 Dec, 2018, 9:10:16 PM
    Author     : Harleen Kaur 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css" media="all" >
        <title>Add product result</title>
    </head>
    <body>
        <h1>Product add result</h1>
        <h3>${resultAddProd}</h3>
        <a href='<c:url value="admin.html"></c:url>'>Add more products</a>
        <a href='<c:url value="index.jsp"></c:url>'>Back to home page</a>
    </body>
</html>
