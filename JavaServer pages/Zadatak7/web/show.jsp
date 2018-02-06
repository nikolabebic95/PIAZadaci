<%-- 
    Document   : show
    Created on : Feb 6, 2018, 1:13:13 AM
    Author     : Nikola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All passed exams</title>
    </head>
    <jsp:useBean id="passedExamsListBean" class="beans.PassedExamsListBean" scope="session" />
    <body>
        <h1>All passed exams</h1>
        <table>
            <c:forEach items="${passedExamsListBean.list}" var="exam" varStatus="loopStatus">
                <c:choose>
                    <c:when test="${loopStatus.index == passedExamsListBean.addedIndex}">
                        <tr style="color:red">
                    </c:when>
                    <c:otherwise>
                        <tr>
                    </c:otherwise>
                </c:choose>
                <td>
                    <c:out value="${exam.name}" />
                </td>
                <td>
                    <c:out value="${exam.grade}" />
                </td>
                <td>
                    <c:out value="${exam.date}" />
                </td>
            </tr>
            </c:forEach>
        </table>
        <a href="index.jsp">Go back to first page</a>
    </body>
</html>
