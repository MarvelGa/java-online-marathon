<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>List of Records from Address Book</title>
    <meta charset="UTF-8"/>
</head>

<body>
<%@include file="/WEB-INF/views/top.jsp" %>

<center>
    <table>

        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <td> Sort by:</td>
            <td><a href="/AddressBook_Web_exploded/records/list?sort=asc">ascending</a> |</td>
            <td><a href="/AddressBook_Web_exploded/records/list?sort=desc">descending</a></td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>

    </table>

    <table border="2">
        <tr>
            <th>No.</th>
            <th>First Name</th>
            <th>Last name</th>
            <th>Address</th>
            <th colspan="3">Operation</th>
        </tr>

        <c:forEach var="i" items="${recordList.recordList}">
            <tr>
                <td><c:out value="${i.id}"/></td>
                <td><c:out value="${i.firstName}"/></td>
                <td><c:out value="${i.lastName}"/></td>
                <td><c:out value="${i.address}"/></td>
                <td>
                    <a href="/AddressBook_Web_exploded/records/read?first-name=<c:out value="${i.firstName}"/>&last-name=<c:out value="${i.lastName}"/>">Read</a>
                </td>
                <td>
                    <a href="/AddressBook_Web_exploded/records/update?first-name=<c:out value="${i.firstName}"/>&last-name=<c:out value="${i.lastName}"/>">Update</a>
                </td>
                <td>
                    <a href="/AddressBook_Web_exploded/records/delete?first-name=<c:out value="${i.firstName}"/>&last-name=<c:out value="${i.lastName}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    </form>
</center>

</body>
</html>
