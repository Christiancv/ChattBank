<%-- 
    Document   : AccountLookup
    Created on : Jun 11, 2018, 4:33:10 PM
    Author     : ccami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Lookup</title>
    </head>
    <body>
        <h1>Account Lookup</h1>
         <form action="http://localhost:8084/ChattBank/AccountLookupServlet" method="post">
            AccNo:&emsp; &emsp;
            <input type="text" name="AccNo"><br>
            CustomerID:&nbsp;
            <input type="text" name="CustomerID"><br>
            Type:&emsp; &emsp; &ensp;
            <input type="text" name="Type"><br>
            Balance: &emsp; &ensp;
            <input type="text" name="Balance"><br>
            <button type="submit">Lookup</button>
            <button type="reset">Clear</button>
            

        </form>
    </body>
</html>
