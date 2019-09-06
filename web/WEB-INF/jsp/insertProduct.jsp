<%-- 
    Document   : insertProduct
    Created on : Jul 6, 2019, 11:29:32 AM
    Author     : Gorana
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
        <h1>Add new product</h1>
        <form:form action="insertProduct.htm" method="post" commandName="add">

            <form:label path="p_name">Product name:</form:label><br/>
            <form:input id="p_name" type = "text" path="p_name"/><br/>

            <form:label path="description">Enter short description:</form:label><br/>
            <form:input id="description" type = "text" path="description"/><br/>
            
            <form:label path="price">Product price:</form:label><br/>
            <form:input id="price" type = "number" path="price"/><br/>

            <input type="submit" value="Submit"/>
        </form:form>

        <label for="product_list" id="product_list_label">All products: </label><br/>
        <textarea id="product_list" rows="10" cols="100" readonly>${newProducts}</textarea>

        <h1><a href="/WebSore/index.htm">Home page</a></h1>   
    </body>
</html>
