/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;
import interfaces.IClassroom;

/**
 *
 * @author N8
 */
public class Classroom implements IClassroom, java.io.Serializable {
    
    private String roomNumber;
    private String typeOfRoom;
    private int capacity;
    
    public void setRoomNumber(String p_roomNumber) {
        roomNumber = p_roomNumber;
    }
    
    public void setTypeOfRoom(String p_typeOfRoom) {
        typeOfRoom = p_typeOfRoom;
    }
    
    public void setCapacity(int p_capacity) {
        capacity = p_capacity;
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }
    
    public String getTypeOfRoom() {
        return typeOfRoom;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    @Override
    public String toString() {
        return "Classroom{" + "roomNumber=" +roomNumber + ", typeOfRoom=" + typeOfRoom + ", capacity=" +capacity + "}";
    }    
}