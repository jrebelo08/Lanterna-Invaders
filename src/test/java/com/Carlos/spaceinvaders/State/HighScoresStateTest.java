package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.HighScoresController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;

import com.Carlos.spaceinvaders.view.menu.DrawHighScores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HighScoresStateTest {

    private HighScoresState highScoresState;
    private HighScoresModel highScoresModel;
    private DrawHighScores drawHighScores;
    private HighScoresController highScoresController;
    private Game game;

    @BeforeEach
    public void setUp() {
        highScoresModel = mock(HighScoresModel.class);
        drawHighScores = mock(DrawHighScores.class);
        highScoresController = mock(HighScoresController.class);
        game = mock(Game.class);
        highScoresState = new HighScoresState(highScoresModel);
        highScoresState.setDrawHighScores(drawHighScores);
        highScoresState.setHighScoresController(highScoresController);
    }

    @Test
    public void testStep() throws IOException {
        String key = "A";
        LanternaGui gui = mock(LanternaGui.class);
        long time = 1000L;

        highScoresState.step(key, gui, time, game);

        verify(drawHighScores).lanternaDraw(gui);
        verify(highScoresController).toDo(game, key, time);
    }
    @Test
    public void testSetDrawHighScores() {
        DrawHighScores newDrawHighScores = mock(DrawHighScores.class);
        highScoresState.setDrawHighScores(newDrawHighScores);
        assertEquals(newDrawHighScores, highScoresState.getDrawHighScores());
    }

    @Test
    public void testSetHighScoresController() {
        HighScoresController newHighScoresController = mock(HighScoresController.class);
        highScoresState.setHighScoresController(newHighScoresController);
        assertEquals(newHighScoresController, highScoresState.getHighScoresController());
    }

    @Test
    public void testConstructor() {
        assertEquals(highScoresModel, highScoresState.getModel());
        assertEquals(drawHighScores, highScoresState.getDrawHighScores());
        assertEquals(highScoresController, highScoresState.getHighScoresController());
    }

}