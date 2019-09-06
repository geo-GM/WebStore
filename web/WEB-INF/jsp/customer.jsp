<%-- 
    Document   : customer
    Created on : Jun 27, 2019, 9:02:11 PM
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
            <h1>Customer site</h1>
            <label for="customer_list" id="customer_list_label">All customers: </label><br/>
            <textarea id="customer_list" rows="20" cols="100" readonly>${newCustomers}</textarea>

            <h1><a href="/WebSore/insertCustomer.htm">Add new customer</a></h1>
            <h1><a href="/WebSore/updateCustomer.htm">Update customer data</a></h1>
            <h1><a href="/WebSore/deleteCustomer.htm">Delete customer</a></h1>
            <h1><a href="/WebSore/index.htm">Home page</a></h1>
        </center>
    </body>
</html>