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
public interface LoanInterface {
    
    public void Totalinterest(double loan, double interestrate);
    
    public void  Totalpayableamount(double totalIntrest, double loan);
    
    public void Themonthlypayment(double totalpayableamount, double period);
    
     public void remainingloan();
    
    
}
