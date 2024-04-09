/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author azzam
 */
public class Account  {
    
    double Balance;
    private int accountNum;
   
    
    
    // making a sequential account number 
    static int count = 0;
     
     public Account(){
     
         Balance = 0;
         count++;
         accountNum = count;
     }
      // setter and getter for accountNum
    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }
         
         
       
    // setter amd getter Balance

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
    // Dipsit method 
     public void diposit(double amount){
     if(amount > 0){
       this.Balance += amount;
       System.out.println("your balance after diposit : "+this.Balance);
     }else{
      System.out.println(" the diposit should be larger than 0");
     }
         
     }
    // Withdrawal method 
     public void Withdraw(double amount){
     if(amount > 0){
         if(amount<=this.Balance){
            this.Balance -= amount;
         }else{
          System.out.println("not enough balance in your account");
           System.out.println(" your current balance is : "+this.Balance);
         }
        
     }else{
      System.out.println("you should Withdraw number larger than 0");
     }
     }
      // check Balance method 
     public void checkBalance(){
     
         System.out.println("your balance is :"+Balance );
     }

    @Override
    public String toString() {
        return "Account{" + "Balance=" + Balance + ", accountNum=" + accountNum + '}';
    }
    
     
}
