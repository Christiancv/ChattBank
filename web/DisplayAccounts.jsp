<%-- 
    Document   : DisplayAccounts
    Created on : Jun 24, 2018, 2:21:07 AM
    Author     : ccami
--%>

<%@page import="ChattBank.AccountList"%>
<%@page import="java.io.PrintWriter"%>
<%@page session="true" import = "ChattBank.Customer" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charse="ISO-8859-1">
        <title>Display Accounts</title>
    </head>
    <body>
        
        <%
            Customer c2 = (Customer)session.getAttribute("c1");
            AccountList alist2 = new AccountList();
            c2.getAccounts(alist2);
            
            
        
        %>
        <h1>Accounts</h1>
        
        <table>
            <tr>
                <th>Account Number</th>
                <th>Customer ID</th>
                <th>Account Type</th>
                <th>Balance</th>
            </tr>
            <%for(int i = 0; i < alist2.alist.size();i++){%>
                <tr>
                    <th><%out.println(alist2.alist.get(i).getAccNo());%></th>
                    <th><%out.println(alist2.alist.get(i).getCid());%></th>
                    <th><%out.println(alist2.alist.get(i).getType());%></th>
                    <th>$<%out.println(alist2.alist.get(i).getBalance());%></th>
                </tr>
                
                <%}%>
            
        </table>
    </body>
</html>
