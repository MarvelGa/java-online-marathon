<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Read Record from Address Book</title>
    <meta charset="UTF-8"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/views/top.jsp" %>

    </br><h3><font color='#ff6347'>${errorObj.errorNotFoundPerson}</font></h3>

    <c:choose>
        <c:when test="${errorObj.errorNotFoundPerson==null}">

            <table>
                <tr>
                    <td>First name:</td>
                    <td>
                        <b>${recordOne.firstName}</b>
                    </td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td>
                        <b>${recordOne.lastName}</b>
                    </td>
                </tr>
                <tr>

                    <td>Address:</td>
                    <td>
                        <b>${recordOne.address}</b>
                    </td>
                </tr>
            </table>

        </c:when>
    </c:choose>

</center>

</body>
</html>
