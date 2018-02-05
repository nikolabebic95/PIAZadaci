<%-- 
    Document   : change
    Created on : Feb 5, 2018, 7:55:27 PM
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
        <h1>Change profile</h1>
        <form action="ChangeData" method="POST" >
            <table>
                <tr>
                    <td>
                        Username:
                    </td>
                    <td>
                        <input type="text" name="username" value="${user.username}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Password:
                    </td>
                    <td>
                        <input type="password" name="password" value="${user.password}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        First name:
                    </td>
                    <td>
                        <input type="text" name="firstName" value="${user.firstName}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Last name:
                    </td>
                    <td>
                        <input type="text" name="lastName" value="${user.lastName}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email" value="${user.email}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Phone number:
                    </td>
                    <td>
                        <input type="text" name="phone" value="${user.phone}" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" />
                    </td>
                </tr>
            </table>
        </form>
        <a href="show.jsp">Back to profile</a>
        <a href="Logout">Log out</a>
    </body>
</html>
