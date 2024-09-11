package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PlayerNameModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class DrawPlayerNameTest {

    private LanternaGui gui;
    private PlayerNameModel playerNameModel;
    private DrawPlayerName drawPlayerName;

    @BeforeEach
    public void setup() {
        gui = mock(LanternaGui.class);
        playerNameModel = mock(PlayerNameModel.class);
        drawPlayerName = new DrawPlayerName(playerNameModel);
    }

    @Test
    public void testDraw() {
        when(playerNameModel.getEntryName()).thenReturn("TestPlayer");

        drawPlayerName.draw(gui);

        verify(gui, times(1)).screenClear();
        verify(gui, times(1)).drawTitle(anyString());
        verify(gui, times(12)).drawText(any(PositionModel.class), anyString(), any(TextColor.RGB.class), eq(false));
        verify(gui, times(1)).drawRectangleName(gui, new TextColor.RGB(178, 73 ,210));
        verify(gui, times(1)).drawText(new PositionModel(35, 21), "TestPlayer", new TextColor.RGB(255, 0, 0), false);
    }
}