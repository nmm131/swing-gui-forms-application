/*
 *  This Class contains methods to write out the course objects in several different formats
 *  and read in the data in the same formats.
 */
package utilities;

import datamodels.Course;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import datacontainers.CourseDC;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CourseIO {

    /**
     * Constructor is declared private because the IO classes are utilities
     * which contain static methods
     */
    private CourseIO() {
    }

    /**
     * Writes out the course data in JSON format containing all courses in
     * the course data model
     *
     */
    public static void writeJSONFile(String fileLocation, CourseDC datacontainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "course.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert course list to JSON format
            gson.toJson(datacontainer.getListOfCourses(), jsonFile);

        } catch (Exception exp) {
            // TO-DO
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }

    /**
     * Reads a JSON formatted file of courses and returns an array list of
     * courses.
     *
     */
    public static ArrayList<Course> readJSONFile(String fileLocation) {

        ArrayList<Course> listOfCourses = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "course.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Course[] courseArray = gson.fromJson(jsonFile, Course[].class);

            // Convert to arraylist for the data model
            for (int i = 0; i < courseArray.length; i++) {
                listOfCourses.add(courseArray[i]);
            }
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfCourses;
        }
    }
    
    /**
     * Creates a serialized object output file containing all courses in the
     * course data model
     */
    public static void writeSerializedFile(String fileLocation, CourseDC datacontainer) {
        try {
            // Create output file
            ObjectOutputStream serializedFile = new ObjectOutputStream(
                    new FileOutputStream(fileLocation + "course.ser"));
            // Write out the data
            serializedFile.writeObject(datacontainer.getListOfCourses());
        } catch (Exception exp) {
            // TO-DO
        }
    }

    /**
     * Reads a set of course objects from a serialized file and returns an
     * array list of courses
     */
    public static ArrayList<Course> readSerializedFile(String fileLocation) {

        ArrayList<Course> listOfCourses = new ArrayList<>();

        try {
            ObjectInputStream serializedFile = new ObjectInputStream(
                    new FileInputStream(fileLocation + "course.ser"));
            // Read the serialized object and cast to its original type
            listOfCourses = (ArrayList<Course>) serializedFile.readObject();
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfCourses;
        }
    }
}
