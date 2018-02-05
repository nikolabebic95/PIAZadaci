<%-- 
    Document   : show
    Created on : Feb 5, 2018, 3:15:31 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show</title>
    </head>
    <jsp:useBean id="user" class="beans.User" scope="session" />
    <jsp:setProperty name="user" property="*" />
    <body>
        <h1>Data</h1>
        <table>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    ${user.name}
                </td>
            </tr>
            <tr>
                <td>
                    Surname:
                </td>
                <td>
                    ${user.surname}
                </td>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td>
                    ${user.email}
                </td>
            </tr>
            <tr>
                <td>
                    Phone number:
                </td>
                <td>
                    ${user.phone}
                </td>
            </tr>
            <tr>
                <td>
                    Address:
                </td>
                <td>
                    ${user.address}
                </td>
            </tr>
            <tr>
                <td>
                    Occupation:
                </td>
                <td>
                    ${user.occupation}
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
    </body>
</html>
