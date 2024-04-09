/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author azzam
 */
public class AdministrationStaff extends Employee {
    
   private int administrationstaffId;
   private String firstName;
   private String lastName;
   private String moobileNumber;
   private String email;
   private double salary;
   private String position;
   
    //constructor
    public AdministrationStaff(int administrationstaffId, String firstName, String lastName, String moobileNumber, String email, double salary, String position) {
        super(administrationstaffId,firstName, lastName,  moobileNumber, email, salary);
        this.administrationstaffId = administrationstaffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moobileNumber = moobileNumber;
        this.email = email;
        this.salary = salary;
        this.position = position;
    }
    
    
    // setters and getters 
     

    public int getAdministrationstaffId() {
        return administrationstaffId;
    }

    public void setAdministrationstaffId(int administrationstaffId) {
        this.administrationstaffId = administrationstaffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMoobileNumber() {
        return moobileNumber;
    }

    public void setMoobileNumber(String moobileNumber) {
        this.moobileNumber = moobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
   

}
