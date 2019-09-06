<%-- 
    Document   : deleteProduct
    Created on : Jul 6, 2019, 11:30:02 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Store</title>
    </head>
    <body>
        <h1>Delete product</h1>
    <form:form action="deleteProduct.htm" method="post" commandName="delete">

        <form:label path="product_id">Enter product ID:</form:label><br/>
        <form:input id="product_id" type = "number" path="product_id" /><br/>


        <input type="submit" value="Submit"/>
        </form:form>

        <label for="product_list" product_id="product_list_label">All products: </label><br/>
        <textarea id="product_list" rows="10" cols="100" readonly>${newProducts}</textarea>

        <h1><a href="/WebSore/index.htm">Home page</a></h1>
    </body>
</html>
