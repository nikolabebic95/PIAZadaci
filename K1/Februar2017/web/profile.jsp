<%-- 
    Document   : profile
    Created on : Feb 6, 2018, 3:21:17 AM
    Author     : Nikola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <jsp:useBean id="profileBean" class="beans.ProfileBean" scope="session" />
    <body>
        <h1>Profile</h1>
        <table>
            <tr>
                <td>
                    Username:
                </td>
                <td>
                    ${profileBean.username}
                </td>
            </tr>
            <tr>
                <td>
                    First name:
                </td>
                <td>
                    ${profileBean.firstName}
                </td>
            </tr>
            <tr>
                <td>
                    Last name:
                </td>
                <td>
                    ${profileBean.lastName}
                </td>
            </tr>
            <tr>
                <td>
                    Experience:
                </td>
                <td>
                    ${profileBean.experience}
                </td>
            </tr>
            <tr>
                <td>
                    Wants classes:
                </td>
                <td>
                    ${profileBean.wantsClasses}
                </td>
            </tr>
            <tr>
                <td>
                    Is instructor:
                </td>
                <td>
                    ${profileBean.isInstructor}
                </td>
            </tr>
        </table>
                
        <br />
        <br />
        
        <form action="SearchGear" method="GET">
            <table>
                <tr>
                    <td>
                        Input name:
                    </td>
                    <td>
                        <input type="text" name="name" value="" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Input type:
                    </td>
                    <td>
                        <input type="text" name="type" value="" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" />
                    </td>
                </tr>
            </table>
        </form>
        
        <br />
        <br />
        
        <c:if test="${profileBean.list.size() != 0}">
            <form action="OrderGear" method="POST">
                <table>
                    <c:forEach items="${profileBean.list}" var="item">
                        <tr>
                            <td>
                                <c:if test="${item.number > 0}">
                                    <input type="checkbox" name="order" value="${item.id}" />
                                </c:if>
                            </td>
                            <td>
                                ${item.name}
                            </td>
                            <td>
                                ${item.type}
                            </td>
                            <td>
                                ${item.number}
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${item.hasSize}">
                                        ${item.size}
                                    </c:when>
                                    <c:otherwise>
                                        <span style="color:red">
                                            Size not available
                                        </span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                ${item.price}
                            </td>
                            <td>
                                <c:if test="${item.number == 0}">
                                    <span style="color:red">
                                        Not available
                                    </span>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="7">
                            <input type="date" name="date" value="<%= new java.sql.Date(new java.util.Date().getTime()) %>" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="7">
                            <input type="submit" value="Submit" />
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
        
        <br />
        <br />
        
        <c:if test="${profileBean.shouldShowPaid}">
            <h2 style="color:red">Paid ${profileBean.paid}</h2>            
        </c:if>
        
        <br />
        <br />
        <a href="ReturnGear">Return gear</a>
        <br />
        <a href="ChangeWantsClasses">Change wants classes flag</a>
    </body>
</html>
