package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class HighScoresControllerTest {

    private HighScoresController highScoresController;
    private HighScoresModel highScoresModel;
    private Game game;

    @BeforeEach
    public void setUp() {
        highScoresModel = mock(HighScoresModel.class);
        game = mock(Game.class);
        highScoresController = new HighScoresController(highScoresModel);
    }

    @Test
    public void testToDo_EnterKey() {
        highScoresController.toDo(game, "Enter", 0);

        verify(game).pushState(any(MenuState.class));
    }

    @Test
    public void testToDo_EscapeKey() {
        highScoresController.toDo(game, "Escape", 0);

        verify(game).popState();
    }

    @Test
    public void testToDo_QuitKey() {
        highScoresController.toDo(game, "Quit", 0);

        verify(game).popState();
    }

    @Test
    public void testToDo_NullKey() {
        highScoresController.toDo(game, null, 0);

        verify(game, never()).pushState(any(MenuState.class));
        verify(game, never()).popState();
    }
}