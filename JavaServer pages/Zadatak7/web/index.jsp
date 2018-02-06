<%-- 
    Document   : index
    Created on : Feb 5, 2018, 9:19:09 PM
    Author     : Nikola
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <jsp:useBean id="messageBean" class="beans.MessageBean" scope="session" />
    <body>
        <h1>Students</h1>
        <h2 style="color:red">${messageBean.message}</h2>
        
        <br />
        <br />
        
        <form action="ShowGpa" method="POST">
            Input index: 
            <input type="text" name="index" value="" />
            <input type="submit" value="Submit" />
        </form>
        
        <br />
        <br />
        
        <form action="ShowPassed" method="POST">
            <table>
                <tr>
                    <td>
                        Input first date:
                    </td>
                    <td>
                        <input type="date" name="first" value="<%= new java.sql.Date(new Date().getTime()) %>" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Input second date:
                    </td>
                    <td>
                        <input type="date" name="second" value="<%= new java.sql.Date(new Date().getTime()) %>" />
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
        
        <form action="UpdateExam" method="POST">
            <table>
                <tr>
                    <td>
                        Input student id:
                    </td>
                    <td>
                        <input type="number" name="studentId" value="" /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Input exam name:
                    </td>
                    <td>
                        <input type="text" name="examName" value="" /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Input grade:
                    </td>
                    <td>
                        <input type="number" name="grade" value="" /> 
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
