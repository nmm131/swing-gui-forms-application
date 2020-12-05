/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

/**
 *
 * @author N8
 */
public class Course implements java.io.Serializable {
    
    private String courseID;
    private String courseName;
    private Classroom classroom;
    
    public void setCourseID(String p_courseID) {
        courseID = p_courseID;
    }
    
    public void setCourseName(String p_courseName) {
        courseName = p_courseName;
    }
    
    public void setClassroom(Classroom p_classroom) {
        classroom = p_classroom;
    }
    
    public String getCourseID() {
        return courseID;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public Classroom getClassroom() {
        return classroom;
    }
    
    @Override
    public String toString() {
        return "Course{" + "courseID=" +courseID + ", courseName=" + courseName + ", classroom=" + classroom + "}";
    }    
    
}

