/*
 *  This Class contains methods to write out the faculty objects in several different formats
 *  and read in the data in the same formats.
 */
package utilities;

import datamodels.Faculty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import datacontainers.FacultyDC;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FacultyIO {

    /**
     * Constructor is declared private because the IO classes are utilities
     * which contain static methods
     */
    private FacultyIO() {
    }

    /**
     * Writes out the faculty data in JSON format containing all faculty in
     * the faculty data model
     *
     */
    public static void writeJSONFile(String fileLocation, FacultyDC datacontainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "faculty.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert faculty list to JSON format
            gson.toJson(datacontainer.getListOfFaculty(), jsonFile);

        } catch (Exception exp) {
            // TO-DO
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }

    /**
     * Reads a JSON formatted file of faculty and returns an array list of
     * faculty.
     *
     */
    public static ArrayList<Faculty> readJSONFile(String fileLocation) {

        ArrayList<Faculty> listOfFaculty = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "faculty.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Faculty[] facultyArray = gson.fromJson(jsonFile, Faculty[].class);

            // Convert to arraylist for the data model
            for (int i = 0; i < facultyArray.length; i++) {
                listOfFaculty.add(facultyArray[i]);
            }
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfFaculty;
        }
    }
    
    /**
     * Creates a serialized object output file containing all faculty in the
     * faculty data model
     */
    public static void writeSerializedFile(String fileLocation, FacultyDC datacontainer) {
        try {
            // Create output file
            ObjectOutputStream serializedFile = new ObjectOutputStream(
                    new FileOutputStream(fileLocation + "faculty.ser"));
            // Write out the data
            serializedFile.writeObject(datacontainer.getListOfFaculty());
        } catch (Exception exp) {
            // TO-DO
        }
    }

    /**
     * Reads a set of faculty objects from a serialized file and returns an
     * array list of faculty
     */
    public static ArrayList<Faculty> readSerializedFile(String fileLocation) {

        ArrayList<Faculty> listOfFaculty = new ArrayList<>();

        try {
            ObjectInputStream serializedFile = new ObjectInputStream(
                    new FileInputStream(fileLocation + "faculty.ser"));
            // Read the serialized object and cast to its original type
            listOfFaculty = (ArrayList<Faculty>) serializedFile.readObject();
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfFaculty;
        }
    }
}
