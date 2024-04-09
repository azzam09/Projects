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
public class Loan implements LoanInterface{
    
    
    private double loan;
    private double period;
    private double interestrate;
    private double totalIntrest;
    public  double  totalpayableamount;
    private double  Themonthlypayment;

    // constructor
    public Loan(double loan, double period, double interestrate) {
        this.loan = loan;
        this.period = period;
        this.interestrate = interestrate;
    }

    // setters and getters

    public double getThemonthlypayment() {
        return Themonthlypayment;
    }
    

    public double getTotalpayableamount() {
        return totalpayableamount;
    }

    
    public double getTotalIntrest() {
        return totalIntrest;
    }
    
    
    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
        
    }
    
     // methods 
    @Override
    public void Totalinterest(double loan, double interestrate ) {
      
         totalIntrest = loan*(interestrate/100);
         System.out.println(totalIntrest);
    }

    @Override
    public void Totalpayableamount(double totalIntrest, double loan ) {
     
       totalpayableamount = totalIntrest + loan;
       System.out.println(totalpayableamount);
    }

    @Override
    public void Themonthlypayment(double totalpayableamount, double period ) {
     
        Themonthlypayment = totalpayableamount/period;
        System.out.println(Themonthlypayment);
        
       
         }

    @Override
    public void remainingloan() {
      
     loan =  loan - Themonthlypayment;
     System.out.println("the remaining of your loan to be paid is "+ loan);
     

    }
    

    
    
    
}
