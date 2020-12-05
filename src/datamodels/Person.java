/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;
import java.time.LocalDate;

/**
 *
 * @author N8
 */
public abstract class Person implements java.io.Serializable {
   
    private String name;
    private String address;
    private LocalDate dateOfBirth;
    
    public void setName(String p_name) {
        name = p_name;
    }
    
    public void setAddress(String p_address) {
        address = p_address; 
    }
    
    public void setDateOfBirth(java.time.LocalDate p_dateOfBirth) {
        dateOfBirth = p_dateOfBirth;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public java.time.LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    @Override
    public String toString() {
        return "Person{" + "name=" +name + ", address=" + address + ", dateOfBirth=" + dateOfBirth + "}";
    }
    
}
