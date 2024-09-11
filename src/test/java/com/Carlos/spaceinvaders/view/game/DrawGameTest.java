package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class DrawGameTest {

    private DrawGame drawGame;
    private ArenaModel arenaModel;
    private LanternaGui gui;

    @BeforeEach
    public void setUp() {
        arenaModel = Mockito.mock(ArenaModel.class);
        PositionModel position = new PositionModel(0, 0);
        ScoreModel scoreModel = new ScoreModel(position);
        Mockito.when(arenaModel.getScore()).thenReturn(scoreModel);

        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        Mockito.when(playerModel.getPosition()).thenReturn(position);
        Mockito.when(arenaModel.getPlayer()).thenReturn(playerModel);

        gui = Mockito.mock(LanternaGui.class);
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(gui.getGraphics()).thenReturn(graphics);

        drawGame = new DrawGame(arenaModel);
    }

    @Test
    public void testDraw() {
        drawGame.draw(gui);

        verify(arenaModel).getActiveMonsters();
        verify(arenaModel).getActiveBullets();
        verify(arenaModel).getWalls();
        verify(arenaModel).getScore();
    }
}
