package com.Carlos.spaceinvaders.model.models;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResumeMenuTest {

    @Test
    public void testGetNumEntries() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertEquals(4, resumeMenuModel.getNumEntries());
    }

    @Test
    public void testGetEntryName() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertEquals("RESUME", resumeMenuModel.getEntryName(0));
        assertEquals("RESTART", resumeMenuModel.getEntryName(1));
        assertEquals("SAVE PROGRESS", resumeMenuModel.getEntryName(2));
        assertEquals("GO TO MAIN MENU", resumeMenuModel.getEntryName(3));
    }

    @Test
    public void testGetEntries() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertEquals(4, resumeMenuModel.getEntries().size());
        assertTrue(resumeMenuModel.getEntries().contains("RESUME"));
        assertTrue(resumeMenuModel.getEntries().contains("RESTART"));
        assertTrue(resumeMenuModel.getEntries().contains("SAVE PROGRESS"));
        assertTrue(resumeMenuModel.getEntries().contains("GO TO MAIN MENU"));
    }

    @Test
    public void testGetColor() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertEquals(new TextColor.RGB(255, 0, 0), resumeMenuModel.getColor("RESUME"));
        assertEquals(new TextColor.RGB(0, 255, 0), resumeMenuModel.getColor("RESTART"));
        assertEquals(new TextColor.RGB(0, 0, 255), resumeMenuModel.getColor("SAVE/LOAD"));
        assertEquals(new TextColor.RGB(255, 255, 0), resumeMenuModel.getColor("GO TO MENU"));
    }

    @Test
    public void testGetEntry() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertEquals(0, resumeMenuModel.getEntry());
    }

    @Test
    public void testSetEntry() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        resumeMenuModel.setEntry(2);
        assertEquals(2, resumeMenuModel.getEntry());
    }

    @Test
    public void testGetEntriesSize() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertEquals(4, resumeMenuModel.getEntriesSize());
    }

    @Test
    public void testGetText() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertEquals(" ___          ____                      \n" +
                "|_ _|_ __    / ___| __ _ _ __ ___   ___ \n" +
                " | || '_ \\  | |  _ / _` | '_ ` _ \\ / _ \\\n" +
                " | || | | | | |_| | (_| | | | | | |  __/\n" +
                "|___|_| |_|  \\____|\\__,_|_| |_| |_|\\___|\n", resumeMenuModel.getText());
    }

    @Test
    public void testSetText() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        resumeMenuModel.setText("New Space Invaders Text");
        assertEquals("New Space Invaders Text", resumeMenuModel.getText());
    }

    @Test
    public void testIsSelected() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertTrue(resumeMenuModel.isSelected(0));
        resumeMenuModel.setEntry(1);
        assertTrue(resumeMenuModel.isSelected(1));
    }

    @Test
    public void testGetCurrentEntry() {
        ResumeMenuModel resumeMenuModel = new ResumeMenuModel();
        assertEquals(0, resumeMenuModel.getCurrentEntry());
        resumeMenuModel.setEntry(2);
        assertEquals(2, resumeMenuModel.getCurrentEntry());
    }
}