package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.model.models.TutorialModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TutorialControllerTest {

    @Mock
    private Game game;

    private TutorialController tutorialController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        tutorialController = new TutorialController(new TutorialModel());
    }

    @Test
    public void testToDo_EnterKey_GamePushState() {
        String keyPressed = "Enter";
        tutorialController.toDo(game, keyPressed, 0L);
        verify(game).pushState(any(MenuState.class));
    }

    @Test
    public void testToDo_EscapeKey_GamePopState() {
        String keyPressed = "Escape";
        tutorialController.toDo(game, keyPressed, 0L);
        verify(game).popState();
    }

    @Test
    public void testToDo_QuitKey_GamePopState() {
        String keyPressed = "Quit";
        tutorialController.toDo(game, keyPressed, 0L);
        verify(game).popState();
    }

    @Test
    public void testToDo_NullKey_NoAction() {
        tutorialController.toDo(game, null, 0L);
        verifyNoInteractions(game);
    }

    @Test
    public void testToDo_OtherKey_NoAction() {
        String keyPressed = "OtherKey";
        tutorialController.toDo(game, keyPressed, 0L);
        verifyNoInteractions(game);
    }

    @Test
    public void testToDo_NullKeyAndGame_NoAction() {
        tutorialController.toDo(null, null, 0L);
        verifyNoInteractions(game);
    }
}