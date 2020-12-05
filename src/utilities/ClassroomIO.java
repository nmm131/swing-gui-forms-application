/*
 *  This Class contains methods to write out the classroom objects in several different formats
 *  and read in the data in the same formats.
 */
package utilities;

import datamodels.Classroom;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import datacontainers.ClassroomDC;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClassroomIO {

    /**
     * Constructor is declared private because the IO classes are utilities
     * which contain static methods
     */
    private ClassroomIO() {
    }

    /**
     * Writes out the classroom data in JSON format containing all classrooms in
     * the classroom data model
     *
     */
    public static void writeJSONFile(String fileLocation, ClassroomDC datacontainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "classroom.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert classroom list to JSON format
            gson.toJson(datacontainer.getListOfClassrooms(), jsonFile);

        } catch (Exception exp) {
            // TO-DO
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }

    /**
     * Reads a JSON formatted file of classrooms and returns an array list of
     * classrooms.
     *
     */
    public static ArrayList<Classroom> readJSONFile(String fileLocation) {

        ArrayList<Classroom> listOfClassrooms = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "classroom.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Classroom[] classroomArray = gson.fromJson(jsonFile, Classroom[].class);

            // Convert to arraylist for the data model
            for (int i = 0; i < classroomArray.length; i++) {
                listOfClassrooms.add(classroomArray[i]);
            }
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfClassrooms;
        }
    }
    
    /**
     * Creates a serialized object output file containing all classrooms in the
     * classroom data model
     */
    public static void writeSerializedFile(String fileLocation, ClassroomDC datacontainer) {
        try {
            // Create output file
            ObjectOutputStream serializedFile = new ObjectOutputStream(
                    new FileOutputStream(fileLocation + "classroom.ser"));
            // Write out the data
            serializedFile.writeObject(datacontainer.getListOfClassrooms());
        } catch (Exception exp) {
            // TO-DO
        }
    }

    /**
     * Reads a set of classroom objects from a serialized file and returns an
     * array list of classrooms
     */
    public static ArrayList<Classroom> readSerializedFile(String fileLocation) {

        ArrayList<Classroom> listOfClassrooms = new ArrayList<>();

        try {
            ObjectInputStream serializedFile = new ObjectInputStream(
                    new FileInputStream(fileLocation + "classroom.ser"));
            // Read the serialized object and cast to its original type
            listOfClassrooms = (ArrayList<Classroom>) serializedFile.readObject();
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfClassrooms;
        }
    }
}
