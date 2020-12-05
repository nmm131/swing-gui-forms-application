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
public class Student extends Person implements java.io.Serializable {
    
    private int studentID;
    private LocalDate dateOfGraduation;
    private float gpa;
    private ArrayList<Course> listOfCourses;
    
    public void setStudentID(int p_studentID) {
        studentID = p_studentID;
    }
    
    public void setStudentID(String p_studentID) {
        int i = Integer.parseInt(p_studentID);
        studentID = i;
    }
    
    public void setDateOfGraduation(LocalDate p_dateOfGraduation) {
        dateOfGraduation = p_dateOfGraduation;
    }
    
    public void setGPA(float p_gpa) {
        gpa = p_gpa;
    }
    
    public int getStudentID() {
        return studentID;
    }
    
    public LocalDate getDateOfGraduation() {
        return dateOfGraduation;
    }
    
    public float getGPA() {
        return gpa;
    }
    
    public ArrayList<Course> getListOfCourses() {
        listOfCourses = new ArrayList<Course>();
        return listOfCourses;
    }
    
    @Override
    public String toString() {
        return "Student{" + "studentID=" +studentID + ", dateOfGraduation=" + dateOfGraduation + ", gpa=" + gpa + ", listOfCourses=" + listOfCourses + "}";
    }
}
