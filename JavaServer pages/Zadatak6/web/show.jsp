<%-- 
    Document   : show
    Created on : Feb 5, 2018, 7:42:59 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <jsp:useBean id="user" class="beans.UserBean" scope="session" />
    <body>
        <h1>Profile</h1>
        <table>
            <tr>
                <td>
                    Username:
                </td>
                <td>
                    ${user.username}
                </td>
            </tr>
            <tr>
                <td>
                    First name:
                </td>
                <td>
                    ${user.firstName}
                </td>
            </tr>
            <tr>
                <td>
                    Last name:
                </td>
                <td>
                    ${user.lastName}
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
        </table>
        <a href="change.jsp">Change data</a>
        <a href="Logout">Log out</a>
    </body>
</html>
