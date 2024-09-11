package com.Carlos.spaceinvaders.model.models;

public class PlayerNameModel {
    private final String entry;
    public static String name;


    public PlayerNameModel(){
        this.entry = "Enter";
        this.name = "";

    }

    public String getEntryName(){
        return entry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        PlayerNameModel.name = name;
    }


}
