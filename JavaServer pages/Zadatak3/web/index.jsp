<%-- 
    Document   : index
    Created on : Feb 5, 2018, 3:09:52 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Input data</h1>
        <form action="show.jsp" method="POST">
            <table>
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <input type="text" name="name" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Surname:
                    </td>
                    <td>
                        <input type="text" name="surname" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Phone number:
                    </td>
                    <td>
                        <input type="text" name="phone" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td>
                    <td>
                        <input type="text" name="address" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Occupation:
                    </td>
                    <td>
                        <input type="text" name="occupation" value="" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
