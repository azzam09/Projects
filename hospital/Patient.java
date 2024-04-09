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
public class Patient {
    
    private int patientId;
    private String pfirstName;
    private String plastName;
    private String pmoobileNumber;
    private String pemail;
    private Vector<Service> servise;
    private Doctor doctor;
    private Service serv;
    private Type t ;
    
    
     //constructor 
    public Patient(int patientId, String pfirstName, String plastName, String pmoobileNumber, String pemail, Vector<Service> servise, Doctor doctor,Service serv,Type t) {
        this.patientId = patientId;
        this.pfirstName = pfirstName;
        this.plastName = plastName;
        this.pmoobileNumber = pmoobileNumber;
        this.pemail = pemail;
        this.servise = servise;
        this.doctor = doctor;
        this.serv = serv;
        this.t = t;
    }
    
    // setters and getters

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }
    
    
    
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    

    public Service getServ() {
        return serv;
    }

    public void setServ(Service serv) {
        this.serv = serv;
    }
    

   

    public Vector<Service> getServise() {
        return servise;
    }

    public void setServise(Vector<Service> servise) {
        this.servise = servise;
    }
    

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPfirstName() {
        return pfirstName;
    }

    public void setPfirstName(String pfirstName) {
        this.pfirstName = pfirstName;
    }

    public String getPlastName() {
        return plastName;
    }

    public void setPlastName(String plastName) {
        this.plastName = plastName;
    }

    public String getPmoobileNumber() {
        return pmoobileNumber;
    }

    public void setPmoobileNumber(String pmoobileNumber) {
        this.pmoobileNumber = pmoobileNumber;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }
    

    @Override
    public String toString() {
        return "Patient{" + "patientId=" + patientId + ", pfirstName=" + pfirstName + ", plastName=" + plastName + ", pmoobileNumber=" + pmoobileNumber + ", pemail=" + pemail + ", servise=" + servise + '}';
    }

}
