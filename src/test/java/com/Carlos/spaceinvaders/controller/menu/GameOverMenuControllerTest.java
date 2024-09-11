package com.Carlos.spaceinvaders.controller.menu;
import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameOverMenuControllerTest {
    private GameOverMenuController controller;

    @BeforeEach
    void setUp() {
        controller = new GameOverMenuController(new GameOverMenuModel());
    }

    @Test
    void testNextEntry() {
        controller.nextEntry();
        assertEquals(1, controller.getModel().getEntry());
    }

    @Test
    void testPreviousEntry() {
        controller.previousEntry();
        assertEquals(controller.getModel().getEntriesSize() - 1, controller.getModel().getEntry());
    }
}