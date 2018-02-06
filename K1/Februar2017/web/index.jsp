<%-- 
    Document   : index
    Created on : Feb 6, 2018, 2:38:45 AM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <jsp:useBean id="indexBean" class="beans.IndexBean" scope="session" />
    <body>
        <h1>Log in</h1>
        <h2 style="color:red">${indexBean.message}</h2>
        <form action="Login" method="POST">
            <table>
                <tr>
                    <td>
                        Username:
                    </td>
                    <td>
                        <input type="text" name="username" value="${indexBean.username}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Password:
                    </td>
                    <td>
                        <input type="password" name="password" value="" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <select name="type">
                            <option>
                                Skier
                            </option>
                            <option>
                                Instructor
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Log in" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
