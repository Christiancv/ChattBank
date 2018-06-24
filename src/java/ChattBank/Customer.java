package ChattBank;


import ChattBank.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccami
 */
public class Customer {
    
    public String CustID;
    public String CustPassword;
    public String CustFirstName;
    public String CustLastName;
    public String CustAddress;
    public String CustEmail;
    public AccountList alist = new AccountList();
    
    
    public Customer(){
        CustID = " ";
        CustPassword = " ";
        CustFirstName = " ";
        CustLastName = " ";
        CustAddress = " ";
        CustEmail = " ";
    }
    
    public Customer(String custid, String custpw, String custfn, String custln, String custad, String custemail){
    
        CustID = custid;
        CustPassword = custpw;
        CustFirstName = custfn;
        CustLastName = custln;
        CustAddress = custad;
        CustEmail = custemail;
    
    }
    
    public String getCustID(){
        return CustID;
    }
    
    public void setCustID(String id){
        CustID = id;
    }
    
    public String getCustPassword(){
        return CustPassword;
    }
    
    public void setCustPassword(String pw){
        CustPassword = pw;
    }
    
    public String getCustFirstName(){
        return CustFirstName;
    }
    
    public void setCustFirstName(String fn){
        CustFirstName = fn;
    }
    
    public String getCustLastName(){
        return CustLastName;
    }
    
    public void setCustLastName(String ln){
        CustLastName = ln;
        
    }
    
    public String getCustAddress(){
        return CustAddress;
    }
    
    public void setCustAddress(String address){
        CustAddress = address;
    }
    
    public String getCustEmail(){
        return CustEmail;
    }
    
    public void setCustEmail(String email){
        CustEmail = email;
    }
    
    

    
  
    
    public void selectDB(String customerID) throws SQLException, ClassNotFoundException
    {   
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        System.out.println("Connecting...");
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//ccami//Documents//NetBeansProjects//BankDatabase//ChattBankMDB.accdb");
        System.out.println("Connected!");
        Statement stmt = con.createStatement();
        String sql;
        
        sql = "select * from Customers" + 
                " where CustID = " + customerID;
        
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next())
        {
            CustID = rs.getString(1);
            CustPassword = rs.getString(2);
            CustFirstName = rs.getString(3);
            CustLastName = rs.getString(4);
            CustAddress = rs.getString(5);
            CustEmail = rs.getString(6);
            
        }
        con.close();
        getAccount();
    }
    
    public void insert(String custID, String custpw, String custfn, String custln, String custaddress, String custemail) throws ClassNotFoundException, SQLException{
    
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        System.out.println("Connecting...");
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//ccami//Documents//NetBeansProjects//BankDatabase//ChattBankMDB.accdb");
        System.out.println("Connected!");
        Statement stmt = con.createStatement();
        String sql;
        
        sql = "insert into Customers"
                + " values (" +"'"+custID+"'" + ", " + "'"+custpw+"'" + ", " + "'"+custfn+"'" + ", " 
                + "'"+custln+"'" + ", " + "'"+custaddress+"'" + ", " + "'"+custemail+"'" + " )";
        
        int n = stmt.executeUpdate(sql);
        
        if(n == 1){
            System.out.println("worked");
        }
        else{
            System.out.println("didnt work");
        }
        
        
       
    }
    
    public void deleteDB() throws ClassNotFoundException, SQLException{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        System.out.println("Connecting...");
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//ccami//Documents//NetBeansProjects//BankDatabase//ChattBankMDB.accdb");
        System.out.println("Connected!");
        Statement stmt = con.createStatement();
        String sql;
        
        
        sql = "delete from Customers" + 
                " where CustID =" + getCustID();
        
        int n = stmt.executeUpdate(sql);
        
        if (n == 1){
        
            System.out.println("it worked!!");
        }
        else
        {
            System.out.println("Didnt work");
        }
        
        
        
        
    
    }
    
    public void getAccount() {
        try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        System.out.println("Connecting...");
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//ccami//Documents//NetBeansProjects//BankDatabase//ChattBankMDB.accdb");
        System.out.println("Connected!");
        Statement stmt = con.createStatement();
        String sql;
        
        sql = "select AcctNo from Accounts where Cid = '" + getCustID() +"'";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        Account a1;
        int acctNo;
         
        while(rs.next())
        {
            acctNo = Integer.parseInt(rs.getString(1));
            System.out.println("AcctNo = "+acctNo);
            a1 = new Account();
            a1.selectDB(acctNo);
            alist.addAcount(a1);
            
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public void display()
    {
        System.out.println("Customer ID: "+ getCustID());
        System.out.println("Customer Password: " + getCustPassword());
        System.out.println("Customer FirstName: " + getCustFirstName());
        System.out.println("Customer LastName: " + getCustLastName());
        System.out.println("Customer Address: " + getCustAddress());
        System.out.println("Customer Email: " + getCustEmail());
        
       
        alist.display();
        
    }
        
    
    public void getAccounts(AccountList alist2) throws ClassNotFoundException, SQLException
    {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        System.out.println("Connecting...");
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//ccami//Documents//NetBeansProjects//BankDatabase//ChattBankMDB.accdb");
        System.out.println("Connected!");
        Statement stmt = con.createStatement();
        String sql;
        
        sql = "select AcctNo from Accounts where Cid = '" + getCustID() +"'";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        Account a1;
        int acctNo;
        
        while(rs.next())
        {
            acctNo = Integer.parseInt(rs.getString(1));
            System.out.println("Account Number: " + acctNo);
            a1 = new Account();
            a1.selectDB(acctNo);
            alist.addAcount(a1);
            alist = alist2;
            
     

        }
        
        
        
        
        
    }
    
        
    
        
    
    
public static void main(String[] args) throws SQLException, ClassNotFoundException{
    
    
   /* Customer c2 = new Customer();
    c2.selectDB("3003");
    System.out.println("Customer number " +  c2.getCustID());
    */
   
   Customer c1 = new Customer();
   c1.selectDB("3006");
   
   AccountList alist2 = new AccountList();
   c1.getAccounts(alist2);
   System.out.println(alist2.alist.get(2).getAccNo());
   
   
    
    
    
}

    




}

