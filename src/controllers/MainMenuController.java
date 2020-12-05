/*
 * Listens for events on the menu form. 
 * Implements the ActionListener interface which contains a single method, 
 * "actionPerformed"
 */
package controllers;

import datacontainers.ClassroomDC;
import datacontainers.CourseDC;
import datacontainers.FacultyDC;
import datacontainers.StudentDC;
import utilities.ClassroomIO;
import utilities.CourseIO;
import utilities.FacultyIO;
import utilities.StudentIO;
import java.awt.event.ActionListener;
import view.MainMenu;

public class MainMenuController implements ActionListener {
    
    // File location
    String fileLocation;
    
    /**
     * Constructor
     * @param fileLocation 
     */
    public MainMenuController(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    // The data models are instantiated here and passed to the 
    // constructors for the controllers
    ClassroomDC classroomDao = new ClassroomDC();
    CourseDC courseDao = new CourseDC();
    FacultyDC facultyDao = new FacultyDC();
    StudentDC studentDao = new StudentDC();
   
    // The main menu form gets created here. Notice it takes this controller object
    // as an argument to the constructor
    private MainMenu mainMenu = new MainMenu(this);

    /**
     * The ActionListener interface contains a single method, actionPerformed
     * which we implement in the controller
     */
    public void actionPerformed(java.awt.event.ActionEvent event) {

        //  Figure out which button was clicked
        String menuItemClicked = event.getActionCommand();

        // create the controller which will open the correct form (refer to the controller constructor
        // methods do determine which Dao classes need to be passed to the controller constructors)
        if (menuItemClicked.equals("Add Classroom")) {
            InputClassroomFormController inputController = new InputClassroomFormController(classroomDao);
        } else if (menuItemClicked.equals("List Classrooms")) {
            ReportClassroomController reportController = new ReportClassroomController(classroomDao);
        } else if (menuItemClicked.equals("Save Data")) {
            ClassroomIO.writeJSONFile(fileLocation, classroomDao);
            CourseIO.writeJSONFile(fileLocation, courseDao);
            FacultyIO.writeJSONFile(fileLocation, facultyDao);
            StudentIO.writeJSONFile(fileLocation, studentDao);
            ClassroomIO.writeSerializedFile(fileLocation, classroomDao);
            CourseIO.writeSerializedFile(fileLocation, courseDao);
            FacultyIO.writeSerializedFile(fileLocation, facultyDao);
            StudentIO.writeSerializedFile(fileLocation, studentDao);
        } else if (menuItemClicked.equals("Load Data")) {
            //classroomDao.setListOfClassrooms(ClassroomIO.readJSONFile(fileLocation));
            //courseDao.setListOfCourses(CourseIO.readJSONFile(fileLocation));
            //facultyDao.setListOfFaculty(FacultyIO.readJSONFile(fileLocation));
            //studentDao.setListOfStudents(StudentIO.readJSONFile(fileLocation));
            classroomDao.setListOfClassrooms(ClassroomIO.readSerializedFile(fileLocation));
            courseDao.setListOfCourses(CourseIO.readSerializedFile(fileLocation));
            facultyDao.setListOfFaculty(FacultyIO.readSerializedFile(fileLocation));
            studentDao.setListOfStudents(StudentIO.readSerializedFile(fileLocation));
        } else if (menuItemClicked.equals("Add Course")) {
            InputCourseController inputController = new InputCourseController(courseDao, classroomDao);
        } else if (menuItemClicked.equals("List Courses")) {
            ReportCourseController reportController = new ReportCourseController(courseDao);
        } else if (menuItemClicked.equals("Add Faculty")) {
            InputFacultyFormController inputController = new InputFacultyFormController(facultyDao, courseDao);
        } else if (menuItemClicked.equals("List Faculty")) {
            ReportFacultyController reportController = new ReportFacultyController(facultyDao);
        } else if (menuItemClicked.equals("Add Student")) {
            InputStudentFormController inputController = new InputStudentFormController(studentDao, courseDao);
        } else if (menuItemClicked.equals("List Students")) {
            ReportStudentController reportController = new ReportStudentController(studentDao);
        } else if (menuItemClicked.equals("Exit")) {
            System.exit(0);
        }
    }

    // Getter used in the Application.java class
    public MainMenu getMainMenu() {
        return mainMenu;
    }
}
