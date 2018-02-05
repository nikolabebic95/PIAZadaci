<%-- 
    Document   : calculate
    Created on : Feb 5, 2018, 2:49:27 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculation</title>
    </head>
    <%
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        try {
            double result = Double.parseDouble(first) - Double.parseDouble(second);
            if (result > 0) {
                %><body bgcolor="green">Difference is greater than 0</body><%
            } else if (result < 0) {
                %><body bgcolor="blue"> Difference is less than 0</body><%
            } else {
                %><body bgcolor="yellow"> Difference is 0</body><%
            }
        } catch (NumberFormatException e) {
            %><body bgcolor="red"><h1>Error</h1></body><%
        }
    %>    
</html>
