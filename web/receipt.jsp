<%-- 
    Document   : receipt
    Created on : 29 Nov, 2018, 12:34:28 PM
    Author     : Harleen Kaur 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css" media="all" >
        <title>Receipt</title>
    </head>
    <body>
        <h3>CheckOut</h3>
        <h3>List of Scanned Items</h3>
        <h3>Product List:</h3>
        <table id="product" align="center">
            <tr>

                <th>Name </th>
                <th>Price </th>
                <th>Tax </th>
                <th>Price After Tax </th>
            </tr>
            <c:forEach var="prod" items= "${prodList}"  >
                <tr>
                    <td> ${prod.name}</td>
                    <td> <fmt:formatNumber value='${prod.price}' minFractionDigits='2'></fmt:formatNumber></td>   
                    <c:choose>
                        <c:when test='${prod.taxable}'>
                            <td> <fmt:formatNumber value='${prod.price * 0.13}' minFractionDigits='2'></fmt:formatNumber></td>
                            <td> <fmt:formatNumber value='${prod.price * 1.13}' minFractionDigits='2'></fmt:formatNumber></td>
                        </c:when>
                        <c:otherwise>
                            <td> 0.00</td>
                            <td> ${prod.price} </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
                <tr>
                    <th>Total</th>
                     <td></td>
                      <td></td>
                       <td><fmt:formatNumber value='${total}' minFractionDigits='2'></fmt:formatNumber></td>
                </tr>
        </table>
      
        <a href='<c:url value="Scan.do"></c:url>'>Start Scanning for Next Customer</a>
    </body>
</html>
