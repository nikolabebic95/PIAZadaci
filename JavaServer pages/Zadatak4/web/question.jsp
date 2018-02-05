<%-- 
    Document   : question
    Created on : Feb 5, 2018, 3:43:02 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question</title>
    </head>
    <jsp:useBean id="question" class="beans.Question" scope="session" />
    <jsp:useBean id="quiz" class="beans.Quiz" scope="session" />
    <body>
        <h1>Score: ${quiz.score}</h1>
        
        <h2>Question: ${question.question}</h2>
        
        <form action="answer_question" method="POST">
            <input type="text" name="answer" value="" />
            <br />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
