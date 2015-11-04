<%-- 
    Document   : add
    Created on : Oct 28, 2015, 11:04:51 AM
    Author     : Shuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Product</title>
        <link rel="stylesheet" type="text/css" href="./format.css">
    </head>


    <body>
        <div class="wrap"> <!--div to hold all other divs-->
            <%@ include file="includes/header.jsp"%>
            <%@ include file="includes/menu.jsp"%>
            <div class="main"> <!--main divs-->
                <h1>Add A New Product</h1>
                <form name="addForm" action="addProduct" method="get">
                    <label> Product Name:</label>
                    <br>
                    <input type="text" name="name" value="" />
                    <br>

                    <label> Price:</label>
                    <br>
                    <input type="text" name="price" value="" />
                    <br>

                    <label> Unit in Stock:</label>
                    <br>
                    <input type="text" name="unit" value="" />
                    <br><br>
                    <input type="reset" value="Clear" id="clear">
                    <input type="submit" name="submit" value="submit" />
                    
                </form>
            </div> <!-- close main div -->
            <br><br>
            <%@ include file="includes/footer.jsp"%>
        </div> <!-- close the wrap div -->
    </body>
</html>
