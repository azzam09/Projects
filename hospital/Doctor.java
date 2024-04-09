/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.Vector;

/**
 *
 * @author azzam
 */
public class Doctor extends Employee {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String moobileNumber;
    private String email;
    private double salary;
    private String rank;
    private String specialty;
    private Vector<Patient> patient;
    
      // constructor 
    public Doctor(int doctorId, String firstName, String lastName, String moobileNumber, String email, double salary, String rank, String specialty, Vector<Patient> patient) {
        
        super(doctorId,firstName,lastName, moobileNumber, email, salary);
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moobileNumber = moobileNumber;
        this.email = email;
        this.salary = salary;
        this.rank = rank;
        this.specialty = specialty;
        this.patient = patient;
    }
    
   
    
    //setters and getters 
    public Vector<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Vector<Patient> patient) {
        this.patient = patient;
    }
    
    

    public int getDoctortId() {
        return doctorId;
    }

    public void setDoctortId(int doctortId) {
        this.doctorId = doctortId;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" + "doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", moobileNumber=" + moobileNumber + ", email=" + email + ", salary=" + salary + ", rank=" + rank + ", specialty=" + specialty + '}';
    }
    
}
