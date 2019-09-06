<%-- 
    Document   : deleteCustomer
    Created on : Jul 6, 2019, 11:29:09 AM
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
        <h1>Delete customer</h1>
    <form:form action="deleteCustomer.htm" method="post" commandName="delete">

        <form:label path="id">Enter customer ID</form:label><br/>
        <form:input id="id" type = "number" path="id" /><br/>


        <input type="submit" value="Submit"/>
        </form:form>

        <label for="customer_list" id="customer_list_label">All customers: </label><br/>
        <textarea id="customer_list" rows="20" cols="100" readonly>${newCustomers}</textarea>
        <h1><a href="/WebSore/index.htm">Home page</a></h1>
    </body>
</html>
