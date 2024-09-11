package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class DrawMenuTest {

    private LanternaGui gui;
    private MenuModel menuModel;
    private DrawMenu drawMenu;

    @BeforeEach
    public void setUp() {
        gui = mock(LanternaGui.class);
        menuModel = mock(MenuModel.class);
        drawMenu = new DrawMenu(menuModel);
    }

    @Test
    public void testDraw() {
        when(menuModel.getText()).thenReturn("Test Title");
        when(menuModel.getEntryName(anyInt())).thenReturn("Test Entry");
        when(menuModel.isSelected(anyInt())).thenReturn(false);

        drawMenu.draw(gui);

        verify(gui).drawTitle("Test Title");
        verify(gui, times(5)).drawText(any(PositionModel.class), eq("Test Entry"), any(TextColor.RGB.class));
    }
}