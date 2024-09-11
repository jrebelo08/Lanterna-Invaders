package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.GameState;
import com.Carlos.spaceinvaders.State.State;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.mockito.Mockito.*;

public class ResumeMenuControllerTest {

    private ResumeMenuController resumeMenuController;
    private ResumeMenuModel resumeMenuModel;
    private Game game;

    @BeforeEach
    public void setUp() {
        resumeMenuModel = mock(ResumeMenuModel.class);
        game = mock(Game.class);
        resumeMenuController = new ResumeMenuController(resumeMenuModel);
    }

    @Test
    public void testNextEntry() {
        when(resumeMenuModel.getEntry()).thenReturn(0);
        when(resumeMenuModel.getEntriesSize()).thenReturn(3);

        resumeMenuController.nextEntry();

        verify(resumeMenuModel).setEntry(1);
    }

    @Test
    public void testPreviousEntry() {
        when(resumeMenuModel.getEntry()).thenReturn(1);
        when(resumeMenuModel.getEntriesSize()).thenReturn(3);

        resumeMenuController.previousEntry();

        verify(resumeMenuModel).setEntry(0);
    }
    @Test
    public void testSelect_Resume() {
        when(resumeMenuModel.getEntry()).thenReturn(0);
        Stack<State> mockStates = new Stack<>();
        mockStates.push(mock(State.class));
        game.states = mockStates;

        resumeMenuController.Select(game);

        verify(game).popState();
    }
    @Test
    public void testSelect_Restart() {
        when(resumeMenuModel.getEntry()).thenReturn(1);
        PositionModel mockScreenSize = mock(PositionModel.class);
        when(mockScreenSize.getX()).thenReturn(100);
        when(mockScreenSize.getY()).thenReturn(100);
        when(game.getScreenSize()).thenReturn(mockScreenSize);

        resumeMenuController.Select(game);

        verify(game).pushState(any(GameState.class));
    }
}