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
public class Employee {
    private int uniqueId;
    private String firstName;
    private String lastName;
    private String moobileNumber;
    private String email;
    private double salary;

    public Employee(int uniqueId, String firstName, String lastName, String moobileNumber, String email, double salary) {
        this.uniqueId = uniqueId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moobileNumber = moobileNumber;
        this.email = email;
        this.salary = salary;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
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
    
    
}

