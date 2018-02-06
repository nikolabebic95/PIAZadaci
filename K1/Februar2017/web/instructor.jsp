<%-- 
    Document   : instructor
    Created on : Feb 6, 2018, 3:46:59 AM
    Author     : Nikola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructor</title>
    </head>
    <jsp:useBean id="instructorBean" class="beans.InstructorBean" scope="session" />
    <body>
        <h1>Instructor profile</h1>
        <form action="GroupA" method="GET">
            <input type="submit" value="Group A" />            
        </form>
        <br />
        <form action="GroupB" method="GET">
            <input type="submit" value="Group B" />            
        </form>
        <br />
        <form action="GroupC" method="GET">
            <input type="submit" value="Group C" />            
        </form>
        <br />
        <br />
        <br />
        <table>
            <c:forEach items="${instructorBean.list}" var="item">
                <tr>
                    <td>
                        ${item.username}
                    </td>
                    <td>
                        ${item.firstName}
                    </td>
                    <td>
                        ${item.lastName}
                    </td>
                    <td>
                        ${item.experience}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
