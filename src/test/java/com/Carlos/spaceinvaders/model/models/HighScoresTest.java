package com.Carlos.spaceinvaders.model.models;

import com.Carlos.spaceinvaders.HighScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoresTest {
    private HighScoresModel highScoresModel;

    @BeforeEach
    public void setUp() {
        highScoresModel = new HighScoresModel();
    }

    @Test
    public void testGetEntryName() {
        String expectedEntryName = "Exit";
        String actualEntryName = highScoresModel.getEntryName();
        assertEquals(expectedEntryName, actualEntryName);
    }

    @Test
    public void testGetFilePath() {
        String expectedFilePath = HighScore.absolutePath;
        String actualFilePath = highScoresModel.getFilePath();
        assertEquals(expectedFilePath, actualFilePath);
    }
}