/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author LUUTHANH
 */
public class Room {
    private String name;
    private String block;
    private Boolean type;
    private Boolean roomGender;
    public Room(){
        
    }
    public Room( String name,String block, Boolean type){
        this.block = block;
        this.type = type;
        this.name = name;
    }

    /**
     * @return the block
     */
    public String getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(String block) {
        this.block = block;
    }

    /**
     * @return the type
     */
    public Boolean getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Boolean type) {
        this.type = type;
    }
    
    @Override
    public String toString(){
        return getName()+" "+ getType();
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
     * @return the roomGender
     */
    public Boolean getRoomGender() {
        return roomGender;
    }

    /**
     * @param roomGender the roomGender to set
     */
    public void setRoomGender(Boolean roomGender) {
        this.roomGender = roomGender;
    }

}
