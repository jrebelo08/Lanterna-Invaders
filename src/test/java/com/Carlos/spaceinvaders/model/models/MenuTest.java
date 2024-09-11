package com.Carlos.spaceinvaders.model.models;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    private MenuModel menuModel;

    @BeforeEach
    public void setUp() {
        menuModel = new MenuModel();
    }

    @Test
    public void testGetEntries() {
        List<String> entries = menuModel.getEntries();
        assertNotNull(entries);
        assertEquals(5, entries.size());
        assertEquals("NEW GAME", entries.get(0));
        assertEquals("CONTINUE GAME", entries.get(1));
        assertEquals("TUTORIAL", entries.get(2));
        assertEquals("HIGHSCORES", entries.get(3));
        assertEquals("EXIT", entries.get(4));
    }

    @Test
    public void testGetColor() {
        TextColor.RGB color = menuModel.getColor("NEW GAME");
        assertNotNull(color);
        assertEquals(255, color.getRed());
        assertEquals(0, color.getGreen());
        assertEquals(0, color.getBlue());
    }

    @Test
    public void testNextEntry() {
        int initialEntry = menuModel.getEntry();
        menuModel.nextEntry();
        assertEquals((initialEntry + 1) % 5, menuModel.getEntry());
    }

    @Test
    public void testGetNumEntries() {
        assertEquals(5, menuModel.getNumEntries());
    }

    @Test
    public void testGetEntryName() {
        assertEquals("NEW GAME", menuModel.getEntryName(0));
        assertEquals("CONTINUE GAME", menuModel.getEntryName(1));
        assertEquals("TUTORIAL", menuModel.getEntryName(2));
        assertEquals("HIGHSCORES", menuModel.getEntryName(3));
        assertEquals("EXIT", menuModel.getEntryName(4));
    }

    @Test
    public void testSetEntry() {
        menuModel.setEntry(3);
        assertEquals(3, menuModel.getEntry());
    }

    @Test
    public void testGetEntriesSize() {
        assertEquals(5, menuModel.getEntriesSize());
    }

    @Test
    public void testSetText() {
        String newText = "New Text";
        menuModel.setText(newText);
        assertEquals(newText, menuModel.getText());
    }

    @Test
    public void testIsSelected() {
        assertTrue(menuModel.isSelected(menuModel.getEntry()));
        assertFalse(menuModel.isSelected(menuModel.getEntry() + 1));
    }

    @Test
    public void testGetText() {
        String expectedText =
                "                          _                     _               \n" +
                        "                         (_)                   | |              \n" +
                        " ___ _ __   __ _  ___ ___ _ _ ____   ____ _  __| | ___ _ __ ___ \n" +
                        "/ __| '_ \\ / _` |/ __/ _ \\ | '_ \\ \\ / / _` |/ _` |/ _ \\ '__/ __|\n" +
                        "\\__ \\.|_) | (_| | (_|  __/ | | | \\ V / (_| | (_| |  __/ |  \\__ \\\n" +
                        "|___/ .__/ \\__,_|\\___\\___|_|_| |_|\\_/ \\__,_|\\__,_|\\___|_|  |___/\n" +
                        "    | |                                                          \n" +
                        "    |_|                                                          \n";
        assertEquals(expectedText, menuModel.getText());
    }
}