/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ADMIN
 */
public class Student {
    private String id;
    private String name;
    private String className;
    private String birthday;
    private String address;
    private String email;
    private boolean gender;
    private String phoneNumber;
    private String room = null;
    private boolean havingRoom = false;
    private String changingRoom = null;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the class
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param classs the classs to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public boolean getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the havingRoom
     */
    public boolean isHavingRoom() {
        return havingRoom;
    }

    /**
     * @param havingRoom the havingRoom to set
     */
    public void setHavingRoom(boolean havingRoom) {
        this.havingRoom = havingRoom;
    }

    /**
     * @return the changingRoom
     */
    public String getChangingRoom() {
        return changingRoom;
    }

    /**
     * @param changingRoom the changingRoom to set
     */
    public void setChangingRoom(String changingRoom) {
        this.changingRoom = changingRoom;
    }

    /**
     * @return the idUser
     */


    /**
     * @return the phonNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phonNumber the phonNumber to set
     */
    public void setPhoneNumber(String phonNumber) {
        this.phoneNumber = phonNumber;
    }
    public String whichGender(){
        if (this.gender) {
            return "Nam";
        }
        return "Nữ";
    }
    
    public String issHavingRoom() {
        if (this.havingRoom) {
            return "Đã có";
        }
        return "Chưa có";
    }
    
    public String onlyName(String fullName) {
        String[] name = fullName.split(" ");
        return name[name.length - 1];
    }
}
