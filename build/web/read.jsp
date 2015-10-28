<%-- 
    Document   : read
    Created on : 2015-10-15, 21:53:46
    Author     : Shuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Products</h1>
        <%= table %>
        
    </body>
</html>
