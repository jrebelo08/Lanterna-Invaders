package com.Carlos.spaceinvaders.model.models;

import com.Carlos.spaceinvaders.HighScore;
import com.googlecode.lanterna.TextColor;

import java.util.ArrayList;
import java.util.List;

public class HighScoresModel {
    private final String entry;
    private String filePath = HighScore.absolutePath;
    private final List<TextColor.RGB> entries;


    public HighScoresModel(){
        this.entry = "Exit";
        entries = new ArrayList<>();
        fillList();

    }

    public String getEntryName(){
        return entry;
    }
    public String getFilePath() {
        return filePath;
    }
    private void fillList(){
        entries.add(new TextColor.RGB(255, 240, 0));
        entries.add(new TextColor.RGB(220, 220, 220));
        entries.add(new TextColor.RGB(205, 133, 63));
        entries.add(new TextColor.RGB(128, 128, 128));
    }
    public TextColor.RGB getColor(int i){
        return entries.get(i);
    }
}
