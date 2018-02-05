<%-- 
    Document   : page3
    Created on : Feb 5, 2018, 6:15:23 PM
    Author     : Nikola
--%>

<%@page import="beans.Counter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page 1</title>
    </head>
    <jsp:useBean id="cnt" class="beans.Counter" scope="session" />
    <%
        if (cnt == null) cnt = new Counter();
        if (cnt.getFirst() == null) cnt.setFirst("Page 3");
        cnt.setPage3(cnt.getPage3() + 1);
        cnt.setAll(cnt.getAll() + 1);
    %>
    <body>
        <h1>This is Page 3. Visits: ${cnt.page3}</h1>
        <a href="page1.jsp">Page 1</a> Visits: ${cnt.page1}
        <br />
        <a href="page2.jsp">Page 2</a> Visits: ${cnt.page2}
        <br />
        Visits to all pages: ${cnt.all}
        <br />
        First visited page: ${cnt.first}
    </body>
</html>
