<%-- 
    Document   : ScanResult
    Created on : 24 Nov, 2018, 11:50:36 PM
    Author     : Harleen Kaur 
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="business.ProductCatalogue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css" media="all" >
        <title>Product List</title>
    </head>
    <body>
        <h3>List of Scanned Items</h3>
        <h3>Product List:</h3>
        <table id="product" align="center">
            <tr>
                <th>Code </th>
                <th>Name </th>
                <th> Price </th>
                <th> Tax </th>
            </tr>
            <c:forEach var="prod" items= "${cart}" >
                <tr>
                    <td> ${prod.code}</td>
                    <td> ${prod.name}</td>
                    <td> <fmt:formatNumber value='${prod.price}' minFractionDigits='2'></fmt:formatNumber></td>   
                    <c:choose>
                        <c:when test='${prod.taxable}'>
                            <td> <fmt:formatNumber value='${prod.price * 0.13}' minFractionDigits='2'></fmt:formatNumber></td>
                        </c:when>
                    <c:otherwise>  <td> <fmt:formatNumber value='0.00' minFractionDigits='2'></fmt:formatNumber></td>
                    </c:otherwise>
                    
                    </c:choose>

                </tr>
            </c:forEach>
        </table>
        <h3>${error}</h3>

        <form method="POST" action='<c:url value="Scan.do"></c:url>'>
                Item Code: <input type="text" name="code" />
                <input type="hidden" name="jsp_file" value="scan_Result.jsp" />
                <input type="submit" value="Scan" />

            </form>

            <form method="POST" action='<c:url value="Checkout.do"></c:url>'>
            <input type="submit" value="CheckOut" />
        </form>

    </body>
</html>
