/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author azzam
 */
public class HospitalSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DuplicateServiceIdException {

        int doctorId, serviceId, patientId;
        String firstName, specialty, rank, email, moobileNumber, lastName, serviceName;
        String pfirstName, plastName, pmoobileNumber, pemail, admfirstName;
        double salary, price;
        
        System.out.println("****************************************************");
        System.out.println("Student #1: Azzam Ahmed alsharif , 441017846, Group:4, \nEmail: s441017846@st.uqu.edu.sa");
        System.out.println("****************************************************");

        Scanner key = new Scanner(System.in);

        //vectors 
        Vector<Doctor> doctors = new Vector();
        Vector<Service> services = new Vector();
        Vector<Patient> patients = new Vector();
        Vector<AdministrationStaff> adm = new Vector<AdministrationStaff>();

        // added at  least 3 administration staffs
        adm.add(new AdministrationStaff(1, "nora", "khaled", "0551735727", "nora@hotamil", 5000.0, "reception"));
        adm.add(new AdministrationStaff(2, "ahmed", "saleh", "05517354973", "saleh@hotmail", 5000.0, "security gaurd"));
        adm.add(new AdministrationStaff(3, "mohammed", "osama", "0553683648", "mohammed@hotamil", 10000.0, "manager"));

        //added at least 2 doctors
        doctors.add(new Doctor(1, "azzam", "ahmed", "0551868163", "azzam@hotamil", 10000.0, "Medical Directors", "General Surgery", patients));
        doctors.add(new Doctor(2, "mohammed", "saleh", "0557358268", "mohhamed@hotmail", 10000.0, "Hospitalist", "Orthopedic Surgery ", patients));

        // this cod for checking AdministrationStaff name
        boolean found;
        do {
            System.out.println("enter your name :");
            admfirstName = key.nextLine();
            found = false;
            for (int i = 0; i < adm.size(); i++) {
                if (adm.get(i).getFirstName().equals(admfirstName)) {
                    found = true;
                }

            }
        } while (!found);

        int userSelected;
        do {
            userSelected = menudata();
            switch (userSelected) {

                case 1:

                    // add doctor code and checking if ther is similar ids
                    System.out.println("enter the doctor ID : ");
                    doctorId = key.nextInt();
                    key.nextLine();

                    System.out.println("enter the doctor first name : ");
                    firstName = key.nextLine();

                    System.out.println("enter the doctor last name : ");
                    lastName = key.nextLine();

                    System.out.println("enter the doctor moobileNumber : ");
                    moobileNumber = key.nextLine();

                    System.out.println("enter the doctor email : ");
                    email = key.nextLine();

                    System.out.println("enter the doctor salary : ");
                    salary = key.nextDouble();

                    System.out.println("enter the doctor rank : ");
                    rank = key.nextLine();
                    key.nextLine();

                    System.out.println("enter the doctor specialty : ");
                    specialty = key.nextLine();

                    Vector<Patient> pa = new Vector<Patient>();

                    boolean found1 = false;
                    for (int i = 0; i < doctors.size(); i++) {
                        if (doctors.get(i).getDoctortId() == doctorId) {
                            found1 = true;
                        }

                    }
                    if (!found1) {
                        Doctor d = new Doctor(doctorId, firstName, lastName, moobileNumber, email, salary, rank, specialty, pa);
                        doctors.add(d);
                    } else {
                        System.out.println("ther is another doctor with the same id  ");
                    }

                    break;
                case 2:

                    //add service code and checking if ther is similar ids
                    System.out.println("enter the service ID : ");
                    serviceId = key.nextInt();
                    key.nextLine();

                    System.out.println("enter the service name : ");
                    serviceName = key.nextLine();

                    System.out.println("enter the service price  : ");
                    price = key.nextDouble();

                    boolean found2 = false;
                    for (int i = 0; i < services.size(); i++) {
                        if (services.get(i).getServiceId() == serviceId) {
                            found2 = true;
                        }

                    }
                    if (!found2) {
                        Service serv = new Service(serviceId, serviceName, price);
                        services.add(serv);
                    } else {
                        throw new DuplicateServiceIdException("Invalid service ID. \nThis service ID is already utilized!");
                    }

                    break;
                case 3:

                    //add patient code and checking if ther is similar ids
                    System.out.println("enter the the patient ID : ");
                    patientId = key.nextInt();
                    key.nextLine();

                    System.out.println("enter the patient first name : ");
                    pfirstName = key.nextLine();

                    System.out.println("enter the patient last name : ");
                    plastName = key.nextLine();

                    System.out.println("enter the patient moobileNumber : ");
                    pmoobileNumber = key.nextLine();

                    System.out.println("enter the patient email : ");
                    pemail = key.nextLine();
                    
                    Type t = null;
                    Service ser = new Service();
                    Doctor doc = null; 
                    Vector<Service> s = new Vector<Service>();

                    // treat by one doctor code 
                    Doctor doct = null;
                    System.out.println("enter the doctor id : ");
                    int doctId = key.nextInt();
                    boolean exist1 = false;
                    for (int i = 0; i < doctors.size(); i++) {
                        if (doctors.get(i).getDoctortId() == doctId) {
                            doct = doctors.get(i);
                            exist1 = true;
                        }

                    }
                    if (!exist1) {
                        System.out.println("wrong doctor id ");

                    }

                    // reseved ids code 
                    System.out.println("How many of services");
                    int n = key.nextInt();
                    key.nextLine();

                    boolean exist2 = false;
                    for (int i = 1; i <= n; i++) {

                        System.out.println("enter the id of the service");
                        int serId = key.nextInt();

                        for (int j = 0; j < services.size(); j++) {
                            if (serId == services.get(j).getServiceId()) {
                                s.add(services.get(j));
                                exist2 = true;
                            }

                        }
                        if (!exist2) {
                            System.out.println("wrong service id ");
                        }
                    }

                    boolean found3 = false;
                    for (int i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getPatientId() == patientId) {
                            found3 = true;
                        }

                    }

                    if (!found3) {
                        Patient p = new Patient(patientId, pfirstName, plastName, pmoobileNumber, pemail, s, doc, ser,t);
                        patients.add(p);
                    } else {
                        System.out.println("ther is another patient with the same id  ");
                    }

                    break;
                case 4:

                    //doctors information code 
                    for (int i = 0; i < doctors.size(); i++) {
                        System.out.println(doctors.get(i));
                    }
                    break;
                case 5:

                    //patients information
                    for (int i = 0; i < patients.size(); i++) {
                        System.out.println(patients.get(i));
                    }
                    break;
                case 6:
                    //specific doctor data code 
                    System.out.println("enter the doctor id : ");
                    int docId = key.nextInt();
                    Doctor d = null;
                    boolean found4 = false;
                    for (int i = 0; i < doctors.size(); i++) {
                        if (doctors.get(i).getDoctortId() == docId) {
                            d = doctors.get(i);
                            found4 = true;
                        }
                    }
                    if (found4) {
                        System.out.println(d);
                    } else {
                        System.out.println("ther is no doctor with the same id");
                    }

                    break;
                case 7:
                    //specific patient data
                    System.out.println("enter the patient id : ");
                    int patId = key.nextInt();
                    Patient p = null;
                    boolean found5 = false;
                    for (int i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getPatientId() == patId) {
                            p = patients.get(i);
                            found5 = true;
                        }
                    }
                    if (found5) {
                        System.out.println(p);
                    } else {
                        System.out.println("ther is no patient with the same id");
                    }
                    break;
                case 8:
                    //specific patient’s bill  and discount from checking type code 
                   Type t1 = null;
                    Patient p1 = null;
                    System.out.println("enter the patient id : ");
                    int paId = key.nextInt();
                    boolean found6 = false;
                    for (int i = 0; i < patients.size(); i++) {
                        if (patients.get(i).getPatientId() == paId) {
                            p1 = patients.get(i);
                            found6 = true;
                        }
                    }
                    if (found6) {
                        System.out.println("enter the patient type : ");
                        char type = key.next().charAt(0);

                        double sum = 0;
                        for (int i = 0; i < p1.getServise().size(); i++) {
                            sum = sum + p1.getServise().get(i).getPrice();
                        }
                        if (type == 'A') {
                            p1.setT(t1.A);
                            sum = sum * 60 / 100.0;
                        }
                        System.out.println("patient bill is : "+sum);

                    }else{
                        System.out.println("ther is no patient with the same id");
                    }

                    break;
                case 9:
                    System.out.println("Exiting from the program…");
                    break;
            }
        } while (userSelected != 9);

    }

    public static int menudata() {

        int selection;
        Scanner selec = new Scanner(System.in);
        System.out.println("please enter the number of your choise (enter 9 to exit)");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Add a doctor");
        System.out.println("2. Add a service");
        System.out.println("3. Add a patient");
        System.out.println("4. Print all doctors information");
        System.out.println("5. Print all patients information ");
        System.out.println("6. Display specific doctor data ");
        System.out.println("7. Display specific patient data");
        System.out.println("8. Print a specific patient’s bill");
        System.out.println("9. Exit the program");

        System.out.println("please choose a choise between 1 and 9 : ");
        selection = selec.nextInt();
        return selection;
    }

}
