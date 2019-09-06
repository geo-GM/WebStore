<%-- 
    Document   : insertCustomer
    Created on : Jul 6, 2019, 11:28:37 AM
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
        <h1>Add new customer</h1>

    <form:form action="insertCustomer.htm" method="post" commandName="add">

        <form:label path="name">Name:</form:label><br/>
        <form:input id="name" type = "text" path="name" ></form:input><br/>

        <form:label path="age">Age:</form:label><br/>
        <form:input id="age" type = "number" path="age" /><br/>

        <form:label path="address">Address</form:label><br/>
        <form:input id="address" type = "text" path="address" /><br/>

        <input type="submit" value="Submit"/>
        <br/>

    </form:form>
    <label for="customer_list" id="customer_list_label">All customers: </label><br/>
    <textarea id="customer_list" rows="20" cols="100" readonly>${newCustomers}</textarea>
    <h1><a href="/WebSore/index.htm">Home page</a></h1>
</body>
</body>
</html>
