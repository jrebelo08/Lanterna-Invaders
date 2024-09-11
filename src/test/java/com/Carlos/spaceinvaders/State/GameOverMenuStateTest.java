package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import com.Carlos.spaceinvaders.view.menu.DrawGameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GameOverMenuStateTest {

    @Mock
    private GameOverMenuModel mockModel;
    @Mock
    private DrawGameOverMenu mockDrawGameOverMenu;
    @Mock
    private com.Carlos.spaceinvaders.controller.menu.GameOverMenuController mockGameOverMenuController;

    private GameOverMenuState gameOverMenuState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameOverMenuState = new GameOverMenuState(mockModel);
        gameOverMenuState.setDrawGameOverMenu(mockDrawGameOverMenu);
        gameOverMenuState.setGameOverMenuController(mockGameOverMenuController);
    }

    @Test
    void step_ShouldCallLanternaDrawAndToDoMethods() throws IOException {
        String key = "A";
        LanternaGui gui = mock(LanternaGui.class);
        long time = 1000L;
        Game game = mock(Game.class);

        gameOverMenuState.step(key, gui, time, game);

        verify(mockDrawGameOverMenu).lanternaDraw(gui);
        verify(mockGameOverMenuController).toDo(game, key, time);
    }

    @Test
    void setDrawGameOverMenu_ShouldSetDrawGameOverMenu() {
        DrawGameOverMenu newMockDrawGameOverMenu = mock(DrawGameOverMenu.class);

        gameOverMenuState.setDrawGameOverMenu(newMockDrawGameOverMenu);

        assertEquals(newMockDrawGameOverMenu, gameOverMenuState.getDrawGameOverMenu());
    }

    @Test
    void setGameOverMenuController_ShouldSetGameOverMenuController() {
        com.Carlos.spaceinvaders.controller.menu.GameOverMenuController newMockGameOverMenuController =
                mock(com.Carlos.spaceinvaders.controller.menu.GameOverMenuController.class);

        gameOverMenuState.setGameOverMenuController(newMockGameOverMenuController);

        assertEquals(newMockGameOverMenuController, gameOverMenuState.getGameOverMenuController());
    }
}