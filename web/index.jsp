<%-- 
    Document   : selfCheckOut
    Created on : 25 Nov, 2018, 12:35:56 PM
    Author     : Harleen Kaur 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Self check out</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="all" >
    </head>
    <body>
        <h3>Self check out</h3>
        <form method="POST" action='<c:url value="Scan.do"></c:url>'>
                Item Code: <input type="text" name="code" />
                <input type="hidden" name="jsp_file" value="scan_Result.jsp" />
                <input type="submit" value="Scan" />
            </form>
                <br>
            <a href='<c:url value="admin.html"></c:url>'>Admin Page</a>
    </body>
</html>
