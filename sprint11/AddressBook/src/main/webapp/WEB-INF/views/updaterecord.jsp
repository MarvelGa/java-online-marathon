<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Update existing Record in Address Book</title>
    <meta charset="UTF-8"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/views/top.jsp" %>
    </br><h3><font color='#ff6347'>${errorObj.errorNotFoundPerson}</font></h3>
    </br><h3><font color='#228b22'> ${recordUpdate.messageUpdate} </font></h3>


    <c:choose>
        <c:when test="${errorObj.errorNotFoundPerson==null}">

            <form id="addRec" action="./update" method="">
                <table>
                    <tr>

                        <div class="field">
                            <td><label>First name:</label></td>
                            <td>
                                <div class="input"><input type="text" name="firstNameUpdate"
                                                          value="${recordOne.firstName}" id="firstNameUpdate"/></div>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="field">
                            <td><label>Last name:</label></td>
                            <td>
                                <div class="input"><input type="text" name="lastNameUpdate"
                                                          value="${recordOne.lastName}" id="lastNameUpdate"/></div>
                            </td>
                        </div>
                    </tr>
                    <tr>

                        <div class="field">

                            <div class="input">
                                <td><label>Address:</label></td>
                                <td><textarea rows="5" cols="25" name="addressUpdate">${recordOne.address}</textarea>
                                </td>
                            </div>
                        </div>
                    </tr>

                    <tr>
                        <td>
                            <div class="submit">
                                <button type="submit">Update</button>
                            </div>
                        </td>
                        <td>
                            <div class="submit">
                                <button type="submit">Clear</button>
                            </div>
                        </td>
                    </tr>


                </table>
            </form>


        </c:when>
    </c:choose>


</center>

</body>
</html>
