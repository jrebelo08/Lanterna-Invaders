package com.Carlos.spaceinvaders.model.models;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverMenuTest {
    private GameOverMenuModel gameOverMenuModel;

    @BeforeEach
    public void setUp() {
        gameOverMenuModel = new GameOverMenuModel();
    }

    @Test
    public void testGetNumEntries() {
        int numEntries = gameOverMenuModel.getNumEntries();
        assertEquals(2, numEntries);
    }

    @Test
    public void testGetEntryName() {
        String entryName = gameOverMenuModel.getEntryName(0);
        assertEquals("NEW GAME", entryName);
    }

    @Test
    public void testGetEntries() {
        List<String> entries = gameOverMenuModel.getEntries();
        assertEquals(2, entries.size());
        assertTrue(entries.contains("NEW GAME"));
        assertTrue(entries.contains("EXIT TO MAIN MENU"));
    }

    @Test
    public void testGetColor() {
        TextColor.RGB color = gameOverMenuModel.getColor("NEW GAME");
        assertNotNull(color);
        assertEquals(255, color.getRed());
        assertEquals(0, color.getGreen());
        assertEquals(0, color.getBlue());
    }

    @Test
    public void testGetEntry() {
        int entry = gameOverMenuModel.getEntry();
        assertEquals(0, entry);
    }

    @Test
    public void testSetEntry() {
        gameOverMenuModel.setEntry(1);
        int entry = gameOverMenuModel.getEntry();
        assertEquals(1, entry);
    }

    @Test
    public void testGetEntriesSize() {
        int entriesSize = gameOverMenuModel.getEntriesSize();
        assertEquals(2, entriesSize);
    }

    @Test
    public void testGetText() {
        String text = gameOverMenuModel.getText();
        String expectedtext =
                "  ____    _    __  __ _____    _____     _______ ____  \n" +
                        " / ___|  / \\  |  \\/  | ____|  / _ \\ \\   / / ____|  _ \\ \n" +
                        "| |  _  / _ \\ | |\\/| |  _|   | | | \\ \\ / /|  _| | |_) |\n" +
                        "| |_| |/ ___ \\| |  | | |___  | |_| |\\ V / | |___|  _ < \n" +
                        " \\____/_/   \\_\\_|  |_|_____|  \\___/  \\_/  |_____|_| \\_\\";
        assertNotNull(text);
        assertEquals(expectedtext,text);

    }

    @Test
    public void testSetText() {
        gameOverMenuModel.setText("New text");
        String text = gameOverMenuModel.getText();
        assertEquals("New text", text);
    }

    @Test
    public void testIsSelected() {
        assertTrue(gameOverMenuModel.isSelected(0));
        assertFalse(gameOverMenuModel.isSelected(2));
        gameOverMenuModel.setEntry(1);
        assertTrue(gameOverMenuModel.isSelected(1));
    }

    @Test
    public void testGetCurrentEntry() {
        int currentEntry = gameOverMenuModel.getCurrentEntry();
        assertEquals(0, currentEntry);
    }
}