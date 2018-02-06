<%-- 
    Document   : gpa
    Created on : Feb 5, 2018, 9:57:58 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GPA</title>
    </head>
    <jsp:useBean id="gpaBean" class="beans.GpaBean" scope="session" />
    <body>
        <h1>GPA: ${gpaBean.gpa}</h1>
        <a href="index.jsp">Back to home page</a>
    </body>
</html>
