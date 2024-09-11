package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.MenuController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.view.menu.DrawMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class MenuStateTest {

    @Mock
    private MenuModel menuModel;

    @Mock
    private DrawMenu drawMenu;

    @Mock
    private MenuController menuController;

    private MenuState menuState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        menuState = new MenuState(menuModel);
        menuState.setDrawMenu(drawMenu);
        menuState.setMenuController(menuController);
    }

    @Test
    void setDrawMenu_ShouldSetDrawMenu() {
        DrawMenu newDrawMenu = mock(DrawMenu.class);

        menuState.setDrawMenu(newDrawMenu);

        assertSame(newDrawMenu, menuState.getDrawMenu());
    }

    @Test
    void setMenuController_ShouldSetMenuController() {
        MenuController newMenuController = mock(MenuController.class);

        menuState.setMenuController(newMenuController);

        assertSame(newMenuController, menuState.getMenuController());
    }

    @Test
    void step_ShouldCallLanternaDrawAndMenuControllerToDo() throws IOException {
        String key = "A";
        LanternaGui gui = mock(LanternaGui.class);
        long time = 1000L;
        Game game = mock(Game.class);

        menuState.step(key, gui, time, game);

        verify(drawMenu).lanternaDraw(gui);
        verify(menuController).toDo(game, key, time);
    }
}