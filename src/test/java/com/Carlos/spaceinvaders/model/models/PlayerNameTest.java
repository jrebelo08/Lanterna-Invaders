package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerNameTest {
    private PlayerNameModel playerNameModel;

    @BeforeEach
    public void setUp() {
        playerNameModel = new PlayerNameModel();
    }

    @Test
    public void testGetEntryName() {
        String expectedEntryName = "Enter";
        String actualEntryName = playerNameModel.getEntryName();
        assertEquals(expectedEntryName, actualEntryName);
    }

    @Test
    public void testGetName() {
        String expectedName = "";
        String actualName = playerNameModel.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testSetName() {
        String newName = "John";
        playerNameModel.setName(newName);
        String actualName = playerNameModel.getName();
        assertEquals(newName, actualName);
    }
}
