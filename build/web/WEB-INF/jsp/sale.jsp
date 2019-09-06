<%-- 
    Document   : sale
    Created on : Jul 6, 2019, 11:27:27 AM
    Author     : Gorana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Store</title>
        <style>
            .field
            {
                clear:both;
                padding:5px;
            }

            .field label
            {
                text-align: left;
                width:130px;
                float:left;
            }
        </style>
    </head>
    <body>
        <h1>Buy product!</h1>
    <form:form action="sale.htm" method="post" commandName="sale">

        <div class=" field ">
            <form:label path="s_customer_id">Enter customer ID: </form:label>
            <form:input path="s_customer_id" type="number"/>
        </div>

        <div class="field">
            <form:label path="s_product_id">Enter product ID:</form:label>
            <form:input path="s_product_id" type="number"/>
        </div>

        <div class="field">
            <form:label path="sold">Is product sold:</form:label>
            <form:input path="sold" type="text"/>
        </div>

        <input type="submit" value="Submit"/>
    </form:form>

    <div>
        <label for="customer_list" id="customer_list_label">All customers: </label><br/>
            <textarea id="customer_list" rows="10" cols="100" readonly>${newCustomers}</textarea>
    </div>

    <div>
        <label for="product_list" id="product_list_label">All products: </label><br/>
            <textarea id="product_list" rows="10" cols="100" readonly>${newProducts}</textarea>
    </div>

    <div>
        <label for="sale_list" id="sale_list_label">Sold products: </label><br/>
        <textarea id="sale_list" rows="10" cols="100" readonly>${allSale}</textarea>
    </div>
    <h1><a href="/WebSore/index.htm">Home page</a></h1>   
</body>
</html>
