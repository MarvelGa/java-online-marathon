<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Create new Record in Address Book</title>
    <meta charset="UTF-8"/>
</head>

<body>
<center>
    <%@include file="/WEB-INF/views/top.jsp" %>

    </br><h3><font color='#ff6347'> ${errorObj.inputError}</font></h3>
    </br><h3><font color='#ff6347'> ${errorObj.errorAlreadyExist}</font></h3>
    </br><h3><font color='#228b22'> ${rightObj.message}</font></h3></br>

    <form id="addRec" action="./create" method="post">
        <table>
            <tr>

                <div class="field">
                    <td><label>First name:</label></td>
                    <td>
                        <div class="input"><input type="text" name="firstName" value="" id="firstName"/></div>
                    </td>
                </div>
            </tr>
            <tr>
                <div class="field">
                    <td><label>Last name:</label></td>
                    <td>
                        <div class="input"><input type="text" name="lastName" value="" id="lastName"/></div>
                    </td>
                </div>
            </tr>
            <tr>

                <div class="field">

                    <div class="input">
                        <td><label>Address:</label></td>
                        <td><textarea rows="5" cols="25" name="address"></textarea></td>
                    </div>
                </div>
            </tr>

            <tr>
                <td>
                    <div class="submit">
                        <button type="submit">Create</button>
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
</center>

</body>
</html>
