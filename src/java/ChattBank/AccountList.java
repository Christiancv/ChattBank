package ChattBank;


import ChattBank.Account;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccami
 */
public class AccountList {
    
    int count;
    public List<Account> alist = new ArrayList<Account>(10);

    public void addAcount(Account a1) {
        alist.add(count, a1);
        count++;
        
    }
    
    public void display(){
        System.out.println("In AccountList display()");
        for(int i = 0; i < count; i++)
        {
            alist.get(i).display();
            System.out.println("-----------------");
            
            
                    
        }
    }
   
    
    
    
    public static void main(String [] args)
    {
        AccountList al = new AccountList();
        
        al.addAcount(new Account(5555, 3007, "SAV", 9000.00));
        al.display();
        
        
    }
    
  
    
   
    
    
}
