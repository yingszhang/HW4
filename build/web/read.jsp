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
        <link rel="stylesheet" type="text/css" href="./format.css">
    </head>

    <%String table = (String) request.getAttribute("table");%>

    <body>
        <div class="wrap"> <!--div to hold all other divs-->
            <%@ include file="includes/header.jsp"%>
            <%@ include file="includes/menu.jsp"%>
            <div class="main"> <!--main divs-->
                <h1>Products</h1>

                <%= table%>

                <br><br>
                <a href="add"> Add A New Product </a>
                <br><br>
                <a href="search.jsp"> Search Products</a>

            </div> <!-- close main div -->
            <%@ include file="includes/footer.jsp"%>
        </div> <!-- close the wrap div -->
    </body>
</html>
