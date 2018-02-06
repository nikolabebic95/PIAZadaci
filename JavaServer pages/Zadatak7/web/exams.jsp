<%-- 
    Document   : exams
    Created on : Feb 5, 2018, 11:04:53 PM
    Author     : Nikola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exams</title>
    </head>
    <jsp:useBean id="examsListBean" class="beans.ExamsListBean" scope="session" />
    <body>
        <c:choose>
            <c:when test="${examsListBean.list.size() == 0}">
                <h1 style="color:red">There are no such exams</h1>
            </c:when>
            <c:otherwise>
                <table>
                    <c:forEach items="${examsListBean.list}" var="item">
                        <tr>
                            <td>
                                <c:out value="${item.studentId}" />
                            </td>
                            <td>
                                <c:out value="${item.firstName}" />
                            </td>
                            <td>
                                <c:out value="${item.lastName}" />
                            </td>
                            <td>
                                <c:out value="${item.year}" />
                            </td>
                            <td>
                                <c:out value="${item.examName}" />
                            </td>
                            <td>
                                <c:out value="${item.grade}" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
        <a href="index.jsp">Go back to first page</a>
    </body>
</html>
