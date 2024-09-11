package com.Carlos.spaceinvaders.model.models;

import com.googlecode.lanterna.TextColor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuModel {
    static String text =
            "                          _                     _               \n" +
                    "                         (_)                   | |              \n" +
                    " ___ _ __   __ _  ___ ___ _ _ ____   ____ _  __| | ___ _ __ ___ \n" +
                    "/ __| '_ \\ / _` |/ __/ _ \\ | '_ \\ \\ / / _` |/ _` |/ _ \\ '__/ __|\n" +
                    "\\__ \\.|_) | (_| | (_|  __/ | | | \\ V / (_| | (_| |  __/ |  \\__ \\\n" +
                    "|___/ .__/ \\__,_|\\___\\___|_|_| |_|\\_/ \\__,_|\\__,_|\\___|_|  |___/\n" +
                    "    | |                                                          \n" +
                    "    |_|                                                          \n";

    private final List<String> entries;
    private int entry = 0;
    private final Map<String, TextColor.RGB> entryColors;

    public MenuModel(){
        this.entries = Arrays.asList("NEW GAME", "CONTINUE GAME", "TUTORIAL","HIGHSCORES","EXIT");
        entry = 0;
        entryColors = new HashMap<>();
        entryColors.put("NEW GAME",new TextColor.RGB(255,0,0));
        entryColors.put("TUTORIAL", new TextColor.RGB(0,255,0));
        entryColors.put("HIGHSCORES",new TextColor.RGB(0,0,255));
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


    public void nextEntry() {
        entry = (entry + 1) % getEntriesSize();
    }
}