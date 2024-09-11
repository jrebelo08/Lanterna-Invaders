package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.ResumeMenuController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;
import com.Carlos.spaceinvaders.view.menu.DrawResumeMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ResumeMenuStateTest {

    @Mock
    private ResumeMenuModel mockModel;
    @Mock
    private DrawResumeMenu mockDrawResumeMenu;
    @Mock
    private ResumeMenuController mockResumeMenuController;

    private ResumeMenuState resumeMenuState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        resumeMenuState = new ResumeMenuState(mockModel);
        resumeMenuState.setDrawResumeMenu(mockDrawResumeMenu);
        resumeMenuState.setResumeMenuController(mockResumeMenuController);
    }

    @Test
    void step_ShouldCallLanternaDrawAndToDoMethods() throws IOException {
        String key = "A";
        LanternaGui gui = mock(LanternaGui.class);
        long time = 1000L;
        Game game = mock(Game.class);

        resumeMenuState.step(key, gui, time, game);

        verify(mockDrawResumeMenu).lanternaDraw(gui);
        verify(mockResumeMenuController).toDo(game, key, time);
    }
    @Test
    void setDrawResumeMenu_ShouldSetDrawResumeMenu() {
        DrawResumeMenu newDrawResumeMenu = mock(DrawResumeMenu.class);

        resumeMenuState.setDrawResumeMenu(newDrawResumeMenu);

        assertEquals(newDrawResumeMenu, resumeMenuState.getDrawResumeMenu());
    }

    @Test
    void setResumeMenuController_ShouldSetResumeMenuController() {
        ResumeMenuController newResumeMenuController = mock(ResumeMenuController.class);

        resumeMenuState.setResumeMenuController(newResumeMenuController);

        assertEquals(newResumeMenuController, resumeMenuState.getResumeMenuController());
    }
}