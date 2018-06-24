package ChattBank;


import java.sql.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccami
 */
public class Account {
    
    private int AccNo;
    private int Cid;
    private String Type;
    private double Balance;
    
    
    
    
    
    public Account(){
        AccNo = 0;
        Cid = 0;
        Type = " ";
        Balance = 0;
    }
    
    public Account(int accno, int cid, String type, double balance)
    {
        AccNo = accno;
        Cid = cid;
        Type = type;
        Balance = balance;
    
    }

    
    
    public int getAccNo(){
        return AccNo;
    }
    
    public void setAccNo(int accNo){
        AccNo = accNo;
    }
    
    public int getCid(){
        return Cid;
    }
    
    public void setCid(int cid){
        Cid = cid;
    }
    
    public String getType(){
        return Type;
    }
    
    public void setType(String type){
        Type = type;
    }
    
    public double getBalance(){
        return  + Balance;
    }
    
    public void setBalance(double balance){
        Balance = balance;
    }
    
    public void selectDB(int accNo) throws ClassNotFoundException, SQLException{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        System.out.println("Connecting...");
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//ccami//Documents//NetBeansProjects//BankDatabase//ChattBankMDB.accdb");
        System.out.println("Connected!");
        Statement stmt = con.createStatement();
        String sql;
        
        sql = "select * from Accounts" +
                " where AcctNo = " + accNo;
        
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next())
        {
            AccNo = rs.getInt(1);
            Cid = rs.getInt(2);
            Type = rs.getString(3);
            Balance = rs.getDouble(4);
                    
        
        }
        
    
    }
    
    public void deposit(double amount) throws ClassNotFoundException, SQLException{
        
        double newbalance = getBalance() + amount;
       
        
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        System.out.println("Connecting...");
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//ccami//Documents//NetBeansProjects//BankDatabase//ChattBankMDB.accdb");
        System.out.println("Connected!");
        Statement stmt = con.createStatement();
        String sql;
        
        sql = "update Accounts " +
                "set Balance = " + newbalance +
                " where AcctNo = " + getAccNo();
                
                
        
        int n = stmt.executeUpdate(sql);
        
        if (n == 1){
            System.out.println("worked");
        }
        else 
        {
            System.out.println("didnt work");
        }
        
        
    
        
    }
    
    public void display(){
        System.out.println("Account Number: " + getAccNo());
        System.out.println("Customer ID: " + getCid());
        System.out.println("Account Type: " + getType());
        System.out.println("Balance: $" + getBalance());
    
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Account acc = new Account();
        
       
        
        acc.selectDB(90000);
        acc.deposit(1000.00);
        acc.display();
    }
}
