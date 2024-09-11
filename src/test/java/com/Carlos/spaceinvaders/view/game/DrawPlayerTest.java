package com.Carlos.spaceinvaders.view.game;


import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class DrawPlayerTest {

    private DrawPlayer drawPlayer;
    private PlayerModel playerModel;
    private LanternaGui gui;

    @BeforeEach
    public void setUp() {
        playerModel = Mockito.mock(PlayerModel.class);
        gui = Mockito.mock(LanternaGui.class);
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(gui.getGraphics()).thenReturn(textGraphics);
        drawPlayer = new DrawPlayer(playerModel);
    }

    @Test
    public void testDraw() {
        PositionModel position = new PositionModel(10, 10);
        Mockito.when(playerModel.getPosition()).thenReturn(position);

        drawPlayer.draw(gui);

        verify(gui.getGraphics()).setBackgroundColor(Mockito.any());
        verify(gui).drawText(eq(new PositionModel(10, 8)), eq("|"), Mockito.any(), eq(false));
        verify(gui).drawText(eq(new PositionModel(8, 9)), eq(" /"), Mockito.any(), eq(false));
        verify(gui).drawText(eq(new PositionModel(10, 9)), eq(" "), Mockito.any(), eq(false));
        verify(gui).drawText(eq(new PositionModel(11, 9)), eq("\\ "), Mockito.any(), eq(false));
        verify(gui).drawText(eq(new PositionModel(8, 10)), eq("<"), Mockito.any(), eq(false));
        verify(gui).drawText(eq(new PositionModel(9, 10)), eq("   "), Mockito.any(), eq(false));
        verify(gui).drawText(eq(new PositionModel(12, 10)), eq(">"), Mockito.any(), eq(false));
        verify(gui).drawText(eq(new PositionModel(9, 10)), eq("___"), Mockito.any(), eq(false));
    }
}