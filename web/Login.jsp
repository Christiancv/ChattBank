<%-- 
    Document   : Login
    Created on : Jun 11, 2018, 4:30:14 PM
    Author     : ccami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    
        <h1>Login</h1>
        <div>
            <form action="http://localhost:8084/ChattBank/LoginServlet" method="post">
                Customer ID:</div>
                <input type="text" name="CustomerID">
                Password: 
                <input type="password" name="Password"><br>
                
                <button type="submit">Login</button> 
                <button type="reset">Clear</button>
                
            </form>
                
        </div>
    
</html>
