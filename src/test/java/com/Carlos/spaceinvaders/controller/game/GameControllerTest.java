package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.State.GameOverMenuState;
import com.Carlos.spaceinvaders.State.ResumeMenuState;
import com.Carlos.spaceinvaders.controller.SoundController;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.Carlos.spaceinvaders.Game;

import static org.mockito.Mockito.*;

public class GameControllerTest {

    @Mock
    private ArenaModel arenaModel;
    @Mock
    private Game game;
    @Mock
    private PlayerModel playerModel;
    @Mock
    private ScoreModel scoreModel;
    @Mock
    private MonsterFactoryModel monsterFactoryModel;
    @Mock
    private SoundController soundController;

    private GameController gameController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        when(arenaModel.getPlayer()).thenReturn(playerModel);
        when(arenaModel.getScore()).thenReturn(scoreModel);
        when(arenaModel.getMonsterFactoryModel()).thenReturn(monsterFactoryModel);

        gameController = new GameController(arenaModel);
        gameController.setSoundController(soundController);
    }

    @Test
    public void testToDo() {
        when(playerModel.getHitPoints()).thenReturn(1);
        when(monsterFactoryModel.getDelay()).thenReturn(3000L);

        gameController.toDo(game, "Escape", 1000L);

        verify(game, times(1)).pushState(any(ResumeMenuState.class));
        verify(soundController, never()).playSound("GameOver");
    }

    @Test
    public void testEndGame() {
        when(playerModel.getHitPoints()).thenReturn(0);

        gameController.endGame(game);

        verify(soundController, times(1)).playSound("GameOver");
        verify(game, times(1)).popState();
        verify(game, times(1)).pushState(any(GameOverMenuState.class));
    }
    @Test
    public void testToDoEscapeKey() {
        when(playerModel.getHitPoints()).thenReturn(1);
        when(monsterFactoryModel.getDelay()).thenReturn(3000L);

        gameController.toDo(game, "Escape", 1000L);

        verify(game, times(1)).pushState(any(ResumeMenuState.class));
        verify(soundController, never()).playSound("GameOver");
    }

    @Test
    public void testToDoQuitKey() {
        when(playerModel.getHitPoints()).thenReturn(1);
        when(monsterFactoryModel.getDelay()).thenReturn(3000L);

        gameController.toDo(game, "Quit", 1000L);

        verify(game, times(1)).pushState(any(ResumeMenuState.class));
        verify(soundController, never()).playSound("GameOver");
    }

    @Test
    public void testToDoGameOver() {
        when(playerModel.getHitPoints()).thenReturn(0);

        gameController.toDo(game, null, 1000L);

        verify(soundController, times(1)).playSound("GameOver");
        verify(game, times(1)).popState();
        verify(game, times(1)).pushState(any(GameOverMenuState.class));
    }



}