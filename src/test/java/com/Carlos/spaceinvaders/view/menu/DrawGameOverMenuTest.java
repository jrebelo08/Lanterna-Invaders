package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;

import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class DrawGameOverMenuTest {

    private DrawGameOverMenu drawGameOverMenu;
    private GameOverMenuModel gameOverMenuModel;
    private LanternaGui gui;

    @BeforeEach
    public void setUp() {
        gameOverMenuModel = mock(GameOverMenuModel.class);
        gui = mock(LanternaGui.class);
        drawGameOverMenu = new DrawGameOverMenu(gameOverMenuModel);
    }

    @Test
    public void testDraw() {
        String title = "Game Over";
        when(gameOverMenuModel.getText()).thenReturn(title);
        when(gameOverMenuModel.getEntryName(0)).thenReturn("EXIT TO MAIN MENU");
        when(gameOverMenuModel.getEntryName(1)).thenReturn("RESTART GAME");
        when(gameOverMenuModel.isSelected(0)).thenReturn(true);
        when(gameOverMenuModel.isSelected(1)).thenReturn(false);

        drawGameOverMenu.draw(gui);

        verify(gui).drawTitle(title);
        verify(gui).drawTextSelected(new PositionModel(30, 17), "EXIT TO MAIN MENU");
        verify(gui).drawText(new PositionModel(34, 21), "RESTART GAME", new TextColor.RGB(255, 255, 255));
    }

    @Test
    public void testDrawWithDifferentSelection() {
        String title = "Game Over";
        when(gameOverMenuModel.getText()).thenReturn(title);
        when(gameOverMenuModel.getEntryName(0)).thenReturn("EXIT TO MAIN MENU");
        when(gameOverMenuModel.getEntryName(1)).thenReturn("RESTART GAME");
        when(gameOverMenuModel.isSelected(0)).thenReturn(false);
        when(gameOverMenuModel.isSelected(1)).thenReturn(true);

        drawGameOverMenu.draw(gui);

        verify(gui).drawTitle(title);
        verify(gui).drawText(new PositionModel(30, 17), "EXIT TO MAIN MENU", new TextColor.RGB(255, 255, 255));
        verify(gui).drawTextSelected(new PositionModel(34, 21), "RESTART GAME");
    }

    @Test
    public void testDrawWithNoSelection() {
        String title = "Game Over";
        when(gameOverMenuModel.getText()).thenReturn(title);
        when(gameOverMenuModel.getEntryName(0)).thenReturn("EXIT TO MAIN MENU");
        when(gameOverMenuModel.getEntryName(1)).thenReturn("RESTART GAME");
        when(gameOverMenuModel.isSelected(0)).thenReturn(false);
        when(gameOverMenuModel.isSelected(1)).thenReturn(false);

        drawGameOverMenu.draw(gui);

        verify(gui).drawTitle(title);
        verify(gui).drawText(new PositionModel(30, 17), "EXIT TO MAIN MENU", new TextColor.RGB(255, 255, 255));
        verify(gui).drawText(new PositionModel(34, 21), "RESTART GAME", new TextColor.RGB(255, 255, 255));
    }
}