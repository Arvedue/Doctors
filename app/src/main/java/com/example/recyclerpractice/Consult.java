package com.example.recyclerpractice;

public class Consult {
    private String surname;
    private String name;
    private String room;
    private int photoResource;

    public Consult(String surname, String name, String room, int photoResource){
        this.surname = surname;
        this.name = name;
        this.room = room;
        this.photoResource = photoResource;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getPhotoResource() {
        return photoResource;
    }

    public void setPhotoResource(int photoResource) {
        this.photoResource = photoResource;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
