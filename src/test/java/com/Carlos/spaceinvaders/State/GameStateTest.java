package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.game.GameController;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.view.game.DrawGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameStateTest {

    private GameState gameState;
    private ArenaModel arenaModel;
    private DrawGame drawGame;
    private GameController gameController;

    @BeforeEach
    public void setUp() {
        arenaModel = mock(ArenaModel.class);
        drawGame = mock(DrawGame.class);
        gameController = mock(GameController.class);
        MonsterFactoryModel monsterFactoryModel = mock(MonsterFactoryModel.class);
        when(arenaModel.getMonsterFactoryModel()).thenReturn(monsterFactoryModel);
        when(monsterFactoryModel.getDelay()).thenReturn(3000L);
        gameState = new GameState(arenaModel);
        gameState.setDrawGame(drawGame);
        gameState.setGameController(gameController);
    }

    @Test
    public void testStep() throws IOException {
        String key = "A";
        LanternaGui gui = mock(LanternaGui.class);
        long time = 1000L;
        Game game = mock(Game.class);

        gameState.step(key, gui, time, game);

        verify(drawGame).lanternaDraw(gui);
        verify(gameController).toDo(game, key, time);
    }

    @Test
    public void testConstructor() {
        assertEquals(arenaModel, gameState.getModel());
        assertEquals(drawGame, gameState.getDrawGame());
        assertEquals(gameController, gameState.getGameController());
    }
    @Test
    public void testSetDrawGame() {
        DrawGame newDrawGame = mock(DrawGame.class);
        gameState.setDrawGame(newDrawGame);
        assertEquals(newDrawGame, gameState.getDrawGame());
    }

    @Test
    public void testSetGameController() {
        GameController newGameController = mock(GameController.class);
        gameState.setGameController(newGameController);
        assertEquals(newGameController, gameState.getGameController());
    }

}