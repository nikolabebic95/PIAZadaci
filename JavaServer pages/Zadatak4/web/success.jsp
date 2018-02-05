<%-- 
    Document   : success
    Created on : Feb 5, 2018, 4:00:33 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <jsp:useBean id="quiz" class="beans.Quiz" scope="session" />
    <body>
        <h1>Congratulations</h1>
        <h2>Score: ${quiz.score}</h2>
        <a href="index.html">Return to first page</a>
    </body>
</html>
