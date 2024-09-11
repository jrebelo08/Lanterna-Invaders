package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.TutorialState;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MenuControllerTest {

    private MenuController menuController;
    private MenuModel menuModel;
    private Game game;

    @BeforeEach
    public void setUp() {
        menuModel = mock(MenuModel.class);
        game = mock(Game.class);
        menuController = new MenuController(menuModel);
    }

    @Test
    public void testNextEntry() {
        when(menuModel.getEntry()).thenReturn(0);
        when(menuModel.getEntriesSize()).thenReturn(3);

        menuController.nextEntry();

        verify(menuModel).setEntry(1);
    }

    @Test
    public void testPreviousEntry() {
        when(menuModel.getEntry()).thenReturn(1);
        when(menuModel.getEntriesSize()).thenReturn(3);

        menuController.previousEntry();

        verify(menuModel).setEntry(0);
    }


    @Test
    public void testSelect_Tutorial() {
        when(menuModel.getEntry()).thenReturn(2);

        menuController.Select(game);

        verify(game).pushState(Mockito.any(TutorialState.class));
    }
}