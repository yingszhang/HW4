<%-- 
    Document   : updateForm
    Created on : Nov 3, 2015, 5:42:09 PM
    Author     : Shuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Products"%>
<%Products product = (Products) request.getAttribute("product");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Product</title>
        <link rel="stylesheet" type="text/css" href="./format.css">
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs-->
            <%@ include file="includes/header.jsp"%>
            <%@ include file="includes/menu.jsp"%>
            <div class="main"> <!--main divs-->
                <h1>Update A Product Record</h1>
                <form name="updateForm" action="updateProduct" method="get">

                    <label> Product ID:</label>
                    <br>
                    <input type="text" name="id" value="<%= product.getPRODUCTID()%>" readonly/>
                    <br>

                    <label> Product Name:</label>
                    <br>
                    <input type="text" name="name" value="<%= product.getPRODUCTNAME()%>" />
                    <br>

                    <label> Price:</label>
                    <br>
                    <input type="text" name="price" value="<%= product.getPRICE()%>" />
                    <br>

                    <label> Unit in Stock:</label>
                    <br>
                    <input type="text" name="unit" value="<%= product.getUNITINSTOCK()%>" />
                    <br><br>
                    <input type="reset" value="Clear" id="clear">
                    <input type="submit" name="submit" value="Update" />

                </form>

            </div> <!-- close main div -->
            
            <br><br>
            <%@ include file="includes/footer.jsp"%>
        </div> <!-- close the wrap div -->
    </body>
</html>
