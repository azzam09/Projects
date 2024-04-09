/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author azzam
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String Name;
        int nationalId;
        String Address;
        String Email;
        int mobileNumber;
        double Balance;
        int accountNum;
        double loan; 
        double period; 
        double interestrat;

    
        System.out.println("****************************************************");
        System.out.println("\tWelcome to My Bank");
        System.out.println("Student #1: Azzam Ahmed alsharif , 441017846");
        System.out.println("****************************************************");
        
        Vector<Costumer> costumers = new Vector();

        Scanner key = new Scanner(System.in);
        
        

       
        int userSelected;
        do {
            userSelected = menudata();
            switch (userSelected) {

                case 1:

                    boolean found = false;
                    System.out.println("enter your name : ");
                    Name = key.nextLine();

                    System.out.println("enter your national Id : ");
                    nationalId = key.nextInt();

                    System.out.println("enter your address: ");
                    Address = key.nextLine();
                    key.nextLine();

                    System.out.println("enter your email : ");
                    Email = key.nextLine();

                    System.out.println("enter your mobile Number: ");
                    mobileNumber = key.nextInt();

                    Account acc = new Account();
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).getNationalId() == nationalId) {
                            found = true;
                        }

                    }
                    if (!found) {
                        Costumer cost = new Costumer(Name, nationalId, Address, Email, mobileNumber, acc);
                        costumers.add(cost);
                    } else {
                        System.out.println("ther is another account with the same nationalId ");
                    }

                    break;
                case 2:
                    boolean found2 = false;
                    Costumer c = null;
                    System.out.println("enter your nationalId : ");
                    nationalId = key.nextInt();
                    key.nextLine();
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).getNationalId() == nationalId) {
                            c = costumers.get(i);
                            found2 = true;
                        }

                    }
                    if (found2) {
                        System.out.println("enter the amount : ");
                        double balance = key.nextDouble();
                        key.nextLine();
                        c.getAccount().diposit(balance);
                    } else {
                        System.out.println("ther is no account with the same nationalId  ");
                    }
                    
                    break;
                case 3:
                    boolean found1 = false;
                    Costumer c1 = null;
                    System.out.println("enter your nationalId : ");
                    nationalId = key.nextInt();
                    key.nextLine();
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).getNationalId() == nationalId) {
                            c1 = costumers.get(i);
                            found1 = true;
                        }
                        
                        }
                    if(found1){
                            System.out.println("enter the amount : ");
                            double balance = key.nextDouble();
                            key.nextLine();
                            c1.getAccount().Withdraw(balance);
                    }else {
                        System.out.println("ther is no account with the same nationalId  ");
                    }
                    break;
                case 4:
                    boolean found3 = false;
                    Costumer c2 = null;
                    System.out.println("enter your nationalId: ");
                    nationalId = key.nextInt();
                    key.nextLine();
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).getNationalId() == nationalId) {
                            c2 = costumers.get(i);
                            found3 = true;
                        }
                        
                    }
                    if(found3){
                    c2.getAccount().checkBalance();
                    
                    }else {
                        System.out.println("ther is no account with the same nationalId  ");
                    }


                    break;
                case 5: 
                 
                    boolean found4 = false;
                    Costumer c3 = null;
                    System.out.println("enter your nationalId : ");
                    nationalId = key.nextInt();
                    key.nextLine();
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).getNationalId() == nationalId) {
                            c3 = costumers.get(i);
                            found4 = true;
                        }

                    }
                    if(found4){
                        if(c3.hasloan()){
                        System.out.println(" this account has a loan already ! ");
                        }
                        else{
                    System.out.println("how much is the new loan : ");
                    loan = key.nextDouble();

                    System.out.println("The loan period in months : ");
                    period = key.nextDouble();

                    System.out.println("What is the interest rate on this loan? :  ");
                    interestrat = key.nextDouble();
                    key.nextLine();
                    
                    Loan loa = new Loan(loan, period, interestrat);
                    c3.setLoan(loa);
                    
                            System.out.println(" the total Intrest : ");
                            c3.getLoan().Totalinterest(loan, interestrat);
                            System.out.println("");
                            System.out.println("the Total payable amount :");
                            c3.getLoan().Totalpayableamount(loa.getTotalIntrest(), loan);
                            System.out.println("");
                            System.out.println("the The monthly payment : ");
                            c3.getLoan().Themonthlypayment(loa.getTotalpayableamount(), period);
                            System.out.println("");
                            c3.getAccount().diposit(loan);
                            System.out.println("---------------------------------");
                        
                            
                    } 
                    
                    }else{
                     System.out.println("ther is no account with the same nationalId  ");
                    }
                    
                    break;
                case 6:
                    boolean found5 = false;
                    Costumer c4 = null;
                    System.out.println("enter your nationalId : ");
                    nationalId = key.nextInt();
                    key.nextLine();
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).getNationalId() == nationalId) {
                            c4 = costumers.get(i);
                            found5 = true;
                        }

                    }
                    
                    if(found5){
                       if(c4.chechloan()){
                       System.out.println("you dont have a loan !");
                       }else{
                       System.out.println(" your loan is : "+ c4.getLoan().getLoan());
                       System.out.println("the period is " + c4.getLoan().getPeriod()+ " " + "months");
                       }
                    }else{
                     System.out.println("ther is no account with the same nationalId  ");
                    }
                    break;
                case 7:
                     boolean found6 = false;
                    Costumer c5 = null;
                    System.out.println("enter your nationalId : ");
                    nationalId = key.nextInt();
                    key.nextLine();
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).getNationalId() == nationalId) {
                            c5 = costumers.get(i);
                            found6 = true;
                        }

                    }
                    
                    if(found6){
                       if(c5.chechloan()){
                       System.out.println("you dont have a loan !");
                       }if(c5.getAccount().getBalance() >= c5.getLoan().getThemonthlypayment()){
                           System.out.println("you have paied the monthly payment  ");
                            c5.getAccount().Withdraw(c5.getLoan().getThemonthlypayment());
                            c5.getLoan().remainingloan();
                            //if the user has paid all the monthly payment he can get a new loan.
                             if(c5.getLoan().getLoan()<=0){
                             c5.setLoan(null);
                             }
                           
                       }else{
                        System.out.println(" your balance not enough !");
                        
                       }
                    }else{
                     System.out.println("ther is no account with the same nationalId  ");
                    }
                    break;
                case 8:
                    break;
            }

        } while (userSelected != 8);

    }

    public static int menudata() {

        int selection;
        Scanner selec = new Scanner(System.in);
        System.out.println("please enter the number of your choise (enter 8 to exit)");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Create a new account. ");
        System.out.println("2. Deposit an amount on an existing account. ");
        System.out.println("3. Withdrawal an amount from an existing account.");
        System.out.println("4. Check the current balance of an existing account.");
        System.out.println("5. Get a new loan on an existing account. ");
        System.out.println("6. Check an existing loan status ");
        System.out.println("7. Pay for the monthly payment for an existing loan. ");
        System.out.println("8. Exit.");

        System.out.println("please choose a choise between 1 and 8 : ");
        selection = selec.nextInt();
        return selection;

    }

}
