package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class MonsterControllerTest {

    private MonsterModel model;
    private MovementStrategy movementStrategy;
    private MonsterController monsterController;

    @BeforeEach
    void setUp() {
        model = mock(MonsterModel.class);
        movementStrategy = mock(MovementStrategy.class);
        monsterController = new MonsterController(model, movementStrategy,3);
    }
    @Test
    void toDo_ShouldNotMoveModel_WhenTimeDifferenceIsLessThan1000() {
        Game game = mock(Game.class);
        long currentTime = 500;
        monsterController.toDo(game, "keyPressed", currentTime);

        verifyNoInteractions(movementStrategy);
        assertNotEquals(currentTime, monsterController.getLastMove());
    }

    @Test
    void toDo_ShouldMoveModel_WhenTimeDifferenceIsGreaterThan1000() {
        Game game = mock(Game.class);
        long currentTime = 1500;

        monsterController.toDo(game, "keyPressed", 1000);
        monsterController.toDo(game, "keyPressed", currentTime);

        verify(movementStrategy, times(1)).move(model);
        assertEquals(currentTime, monsterController.getLastMove());
    }

    @Test
    void checkWin_ShouldSetWinMonsterToTrue_WhenPositionIsAtArenaHeightMinusOne() {
        when(model.getPosition()).thenReturn(new PositionModel(0, 2));

        monsterController.checkWin(model);

        assertTrue(monsterController.isWinMonster());
    }

    @Test
    void checkWin_ShouldNotSetWinMonsterToTrue_WhenPositionIsBelowArenaHeightMinusOne() {
        MonsterModel model = mock(MonsterModel.class);
        when(model.getPosition()).thenReturn(new PositionModel(0, 1));

        monsterController.checkWin(model);

        assertFalse(monsterController.isWinMonster());
    }

    @Test
    void toDo_ShouldMoveModel_WhenWinMonsterIsFalse() {
        Game game = mock(Game.class);
        long currentTime = 1500;
        monsterController.checkWin(model);

        monsterController.toDo(game, "keyPressed", currentTime);

        verify(movementStrategy, times(1)).move(model);
        assertEquals(currentTime, monsterController.getLastMove());
    }


}