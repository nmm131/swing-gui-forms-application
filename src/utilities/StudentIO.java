/*
 *  This Class contains methods to write out the student objects in several different formats
 *  and read in the data in the same formats.
 */
package utilities;

import datamodels.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import datacontainers.StudentDC;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentIO {

    /**
     * Constructor is declared private because the IO classes are utilities
     * which contain static methods
     */
    private StudentIO() {
    }

    /**
     * Writes out the student data in JSON format containing all students in
     * the student data model
     *
     */
    public static void writeJSONFile(String fileLocation, StudentDC datacontainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "student.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert student list to JSON format
            gson.toJson(datacontainer.getListOfStudents(), jsonFile);

        } catch (Exception exp) {
            // TO-DO
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }

    /**
     * Reads a JSON formatted file of students and returns an array list of
     * students.
     *
     */
    public static ArrayList<Student> readJSONFile(String fileLocation) {

        ArrayList<Student> listOfStudents = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "student.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Student[] studentArray = gson.fromJson(jsonFile, Student[].class);

            // Convert to arraylist for the data model
            for (int i = 0; i < studentArray.length; i++) {
                listOfStudents.add(studentArray[i]);
            }
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfStudents;
        }
    }
    
    /**
     * Creates a serialized object output file containing all students in the
     * student data model
     */
    public static void writeSerializedFile(String fileLocation, StudentDC datacontainer) {
        try {
            // Create output file
            ObjectOutputStream serializedFile = new ObjectOutputStream(
                    new FileOutputStream(fileLocation + "student.ser"));
            // Write out the data
            serializedFile.writeObject(datacontainer.getListOfStudents());
        } catch (Exception exp) {
            // TO-DO
        }
    }

    /**
     * Reads a set of student objects from a serialized file and returns an
     * array list of students
     */
    public static ArrayList<Student> readSerializedFile(String fileLocation) {

        ArrayList<Student> listOfStudents = new ArrayList<>();

        try {
            ObjectInputStream serializedFile = new ObjectInputStream(
                    new FileInputStream(fileLocation + "student.ser"));
            // Read the serialized object and cast to its original type
            listOfStudents = (ArrayList<Student>) serializedFile.readObject();
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfStudents;
        }
    }
}
