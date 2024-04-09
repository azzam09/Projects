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
public class Service {
    
    int serviceId;
    String serviceName;
    double price;
    
    
    //constructor 
    public Service(){
    
    
    }
     
    //constructor
    public Service(int serviceId, String serviceName, double price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
    }
    
    // setters and getters
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
   
    
}
