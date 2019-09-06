<%-- 
    Document   : product
    Created on : Jul 6, 2019, 11:24:11 AM
    Author     : Gorana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Store</title>
    </head>
    <body>
        <center>
            <h1>Product site</h1>
            <label for="product_list" id="product_list_label">All products: </label><br/>
            <textarea id="product_list" rows="20" cols="100" readonly>${newProducts}</textarea>

            <h1><a href="/WebSore/insertProduct.htm">Add new product</a></h1>
            <h1><a href="/WebSore/updateProduct.htm">Update product data</a></h1>
            <h1><a href="/WebSore/deleteProduct.htm">Delete product</a></h1><br/>
            <h1><a href="/WebSore/index.htm">Home page</a></h1>

        </center>
    </body>
</html>
