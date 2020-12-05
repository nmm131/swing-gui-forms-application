/*
 * Listens for events on the input form. 
 * Implements the ActionListener interface which contains a single method, 
 * "actionPerformed" - this method contains all the logic to process the data
 * on the form, as well as several other events
 */
package controllers;

import datamodels.Classroom;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import datacontainers.ClassroomDC;
import view.inputforms.ClassroomInputForm;
import exceptionhandlers.ErrorPopup;
import exceptionhandlers.InvalidDataException;

public class InputClassroomFormController implements ActionListener {

    // The Classroom data model is passed in via the constructor
    private ClassroomDC dataModel;

    // The form is created here and this constructor object gets passed to it
    private ClassroomInputForm form;

    // Constructor 
    public InputClassroomFormController(ClassroomDC dataModel) {

        // Store the passed in data model
        this.dataModel = dataModel;

        // create the form
        form = new ClassroomInputForm(this);

        // make the form visible
        this.form.setVisible(true);
    }

    /**
     * The ActionListener interface contains a single method, actionPerformed
     * which we implement in the controller
     */
    public void actionPerformed(java.awt.event.ActionEvent event) {

        // TO-DO - implement the controller logic
        
        if (event.getActionCommand().equals("Save")) {
            this.saveData();
        } else if (event.getActionCommand().equals("Clear")) {
            this.clearForm();
        } else if (event.getActionCommand().equals("Close")) {
            this.closeForm();
        }
    }

    /**
     * Private save method called by the actionPerformed method
     */
    private void saveData() {
        
        try {

            // Create a new classroom object
            Classroom aClassroom = new Classroom();

            // Retrieve the room number from the form
            String roomNumber = form.getRoomNumberTextfield().getText();
        
            // Validate the room number, calls two private methods, 
            // "isValid" will test for valid data - notice that we are actually testing for "not valid"
            // by putting the ! before the method name
            // "isEmpty" will test for empty data
            if (isEmpty(roomNumber)) {
                throw new InvalidDataException("Missing Data!");
            }
        
            if (!isValid(roomNumber)) {
                throw new InvalidDataException("Invalid Data!");
            }

            // Retrieve roomNumber capacity, convert to an integer
            int roomCapacity = Integer.parseInt(form.getRoomCapacityTextField().getText());
        
            // The value must come from the drop down list of roomNumber types
            // Step 1 - Retrieve the data model associated with the combo list box
            ComboBoxModel datamodel = this.form.getRoomTypeCombobox().getModel();
            // Step 2 - Retrieve the selected item from the data model, notice
            // it is stored as type Object, we need to convert it in the next step
            Object selectedItem = datamodel.getSelectedItem();
            // Step 3 - Convert (Cast) the selected item to a string
            String roomType = (String) selectedItem;
            // Step 4 - Use the Classroom setters to set the values
            aClassroom.setRoomNumber(roomNumber);
            aClassroom.setTypeOfRoom(roomType);
            aClassroom.setCapacity(roomCapacity);

        // Add the new classroom to the list in ClassroomDC
        dataModel.getListOfClassrooms().add(aClassroom);
    } catch (InvalidDataException exception) {
            // Invalid data was found, 
            // No classroom will be saved,
            // create an error popup
            ErrorPopup error = new ErrorPopup(form, exception);
    }
    }

    /**
     * Private method to clearForm the data called by the actionPerformed method
     */
    private void clearForm() {
        form.getRoomNumberTextfield().setText("");
        form.getRoomTypeCombobox().setSelectedIndex(0);
        form.getRoomCapacityTextField().setText("");
    }

    /**
     * Private method to close the form called by the actionPerformed method
     */
    private void closeForm() {
        this.form.dispose();
    }

    // Getters used in the controller - this one returns the applicatoin data model
    public ClassroomDC getDC() {
        return dataModel;
    }

    // This one returns the form this controller is linked to
    public ClassroomInputForm getForm() {
        return form;
    }
    
    /**
     * Uses the isEmpty method from the String class to test whether the method
     * argument is empty. Notice that there is really no value added to have 
     * a private helper method for isEmpty but I put it in for consistency
     *
     * @param data
     * @return
     */
    private boolean isEmpty(String data) {
        if (data.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Uses a regular expression (regex) to compare the format of the data
     * argument
     *
     * ^[a-zA-Z]{2}[0-9]{3}$ will compare the first 2 characters to a-z and A-Z
     * and the last 3 characters to numerics
     *
     * @param data
     * @return
     */
    private boolean isValid(String data) {

        if (data.matches("^[a-zA-Z]{2}[0-9]{3}$")) {
            return true;
        } else {
            return false;
        }
    }

}
