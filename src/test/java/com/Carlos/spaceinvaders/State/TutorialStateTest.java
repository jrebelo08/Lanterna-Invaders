package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.TutorialController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.TutorialModel;
import com.Carlos.spaceinvaders.view.menu.DrawTutorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TutorialStateTest {

    @Mock
    private TutorialModel tutorialModel;

    @Mock
    private DrawTutorial drawTutorial;

    @Mock
    private TutorialController tutorialController;

    private TutorialState tutorialState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tutorialState = new TutorialState(tutorialModel);
        tutorialState.setDrawTutorial(drawTutorial);
        tutorialState.setTutorialController(tutorialController);
    }

    @Test
    void step_ShouldCallLanternaDrawAndToDoMethods() throws IOException {
        String key = "A";
        LanternaGui gui = mock(LanternaGui.class);
        long time = 1000L;
        Game game = mock(Game.class);

        tutorialState.step(key, gui, time, game);

        verify(drawTutorial).lanternaDraw(gui);
        verify(tutorialController).toDo(game, key, time);
    }

    @Test
    void setDrawTutorial_ShouldSetDrawTutorial() {
        DrawTutorial newDrawTutorial = mock(DrawTutorial.class);

        tutorialState.setDrawTutorial(newDrawTutorial);

        assertEquals(newDrawTutorial, tutorialState.getDrawTutorial());
    }

    @Test
    void setTutorialController_ShouldSetTutorialController() {
        TutorialController newTutorialController = mock(TutorialController.class);

        tutorialState.setTutorialController(newTutorialController);

        assertEquals(newTutorialController, tutorialState.getTutorialController());
    }
}