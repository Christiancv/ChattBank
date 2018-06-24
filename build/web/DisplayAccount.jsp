<%-- 
    Document   : DisplayAccount
    Created on : Jun 22, 2018, 12:48:22 AM
    Author     : ccami
--%>
<%@page import="java.io.PrintWriter"%>
<%@page session="true" import = "ChattBank.Account" %>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="ISO-8859-1">
    </head>
    
    <body>
        
        <%
            Account acct = (Account)session.getAttribute("ac");
            System.out.println("Testing Account information ...");
            System.out.println(acct.getAccNo());
            System.out.println(acct.getCid());
            System.out.println(acct.getType());
            System.out.println(acct.getBalance());
            
            int accNo = acct.getAccNo();
            int cid = acct.getCid();
            String type = acct.getType();
            Double balance = acct.getBalance();
            
            
            %>
        <h1>Account Display</h1>
         <form>
            AccNo:&emsp; &emsp;
            <input type="text" name="AccNo" value="<%out.println(accNo);%>"><br>
            CustomerID:&nbsp;
            <input type="text" name="CustomerID" value="<%out.println(cid);%>"><br>
            Type:&emsp; &emsp; &ensp;
            <input type="text" name="Type" value="<%out.println(type);%>"><br>
            Balance: &emsp; &ensp;
            <input type="text" name="Balance" value="<%out.println("$" + balance);%>"><br>
            <button type="submit">Lookup</button>
            <button type="reset">Clear</button>
            

        </form>
    </body>
</html>

