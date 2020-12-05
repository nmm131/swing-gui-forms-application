/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels; 
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author N8
 */
public class Faculty extends Person implements java.io.Serializable {
    
    private LocalDate dateOfHire;
    private double salary;
    private String status;
    private ArrayList<Course> listOfCourses;
    
    public void setDateOfHire(LocalDate p_dateOfHire) {
        dateOfHire = p_dateOfHire;
    }
    
    public void setSalary (double p_salary) {
        salary = p_salary;
    }
    
    public void setStatus (String p_status) {
        status = p_status;
    }
        
    public LocalDate getDateOfHire() {
        return dateOfHire;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public String getStatus() {
        return status;
    }
    
    public ArrayList<Course> getListOfCourses() {
        listOfCourses = new ArrayList<Course>();
        return listOfCourses;
    }
    
    @Override
    public String toString() {
        return "Faculty{" + "dateOfHire=" +dateOfHire + ", salary=" + salary + ", status=" + status + ", listOfCourses=" + listOfCourses + "}";
        }
    }
