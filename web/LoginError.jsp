<%-- 
    Document   : ErrorPage
    Created on : Jun 21, 2018, 5:56:53 PM
    Author     : ccami
--%>
<%@page import="java.io.PrintWriter"%>
<%@page session="true" import = "ChattBank.Customer" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charse="ISO-8859-1">
        <title>Invalid Login</title>
    </head>
    <body>
        <%
            Customer c2 = (Customer)session.getAttribute("c1");
            System.out.println("Testing customer ID " + c2.getCustID());
            String CustomerID = c2.getCustID();
            %>
    
            <h1>Invalid Login for customer #<%out.println(CustomerID);%></h1>
    </body>
</html>
