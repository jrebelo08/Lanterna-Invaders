package com.Carlos.spaceinvaders.model.models;

import com.googlecode.lanterna.TextColor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOverMenuModel {
    static String text =
            "  ____    _    __  __ _____    _____     _______ ____  \n" +
            " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
            "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
            "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
            " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\";


    private final List<String> entries;
    private int entry = 0;
    private final Map<String, TextColor.RGB> entryColors;

    public GameOverMenuModel(){
        this.entries = Arrays.asList("NEW GAME","EXIT TO MAIN MENU");
        entry = 0;
        entryColors = new HashMap<>();
        entryColors.put("NEW GAME",new TextColor.RGB(255,0,0));
        entryColors.put("EXIT", new TextColor.RGB(255,255,0));
    }
    public int getNumEntries() {
        return entries.size();
    }

    public String getEntryName(int i){
        return entries.get(i);
    }

    public List<String> getEntries() {
        return entries;
    }
    public TextColor.RGB getColor(String entry) {
        return entryColors.get(entry);
    }
    public int getEntry(){
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public int getEntriesSize(){
        return entries.size();
    }
    public String getText(){
        return text;
    }

    public void setText(String spaceInvaders) {
        this.text = spaceInvaders;
    }

    public boolean isSelected(int i){
        return i == getCurrentEntry();
    }

    public int getCurrentEntry() {
        return entry;
    }
}
