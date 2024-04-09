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
public class Costumer {
    
    private String Name;
    private int nationalId;
    private String Address;
    private String Email;
    private int  mobileNumber;
    private Account account;
    private Loan loan;
    
    //constructor 

    public Costumer(String Name, int nationalId, String Address, String Email, int mobileNumber, Account account ) {
        this.Name = Name;
        this.nationalId = nationalId;
        this.Address = Address;
        this.Email = Email;
        this.mobileNumber = mobileNumber;
        this.account = account;
       
       
    }
    
    // setters and getters

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Costumer{" + "Name=" + Name + ", nationalId=" + nationalId + ", Address=" + Address + ", Email=" + Email + ", mobileNumber=" + mobileNumber + '}';
    }
    

     // methods for loan 
    public boolean hasloan(){
    
        return loan != null;
    }
    
    public boolean chechloan(){
    
        return loan == null;
        
        
    
    }
    
}
