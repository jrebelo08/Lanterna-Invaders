package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TutorialTest {

    @Test
    public void testGetEntryName() {
        TutorialModel tutorialModel = new TutorialModel();
        assertEquals("Exit", tutorialModel.getEntryName());
    }
}