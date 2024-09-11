package com.Carlos.spaceinvaders.controller.game.MonsterStrategy;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.DiagonalMovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class DiagonalMovementStrategyTest {

    private DiagonalMovementStrategy diagonalMovementStrategy;
    private MonsterModel monster;
    private PositionModel positionModel;

    @BeforeEach
    public void setUp() {
        monster = mock(MonsterModel.class);
        positionModel = new PositionModel(5, 5);
        when(monster.getPosition()).thenReturn(positionModel);
        when(monster.getSpeed()).thenReturn(1);

        Random fixedSeedRandom = new Random(123);
        diagonalMovementStrategy = new DiagonalMovementStrategy(10, fixedSeedRandom);
    }

    @Test
    public void testMove_CanMove() {
        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
    }

    @Test
    public void testMove_CanMoveMultipleTimes() {
        for (int i = 0; i < 5; i++) {
            diagonalMovementStrategy.move(monster);
        }

        verify(monster, times(5)).getPosition();
    }

    @Test
    public void testMove_SpeedGreaterThanOne() {
        when(monster.getSpeed()).thenReturn(2);

        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
    }

    @Test
    public void testMove_ChangeDirectionOnBoundary() {
        when(monster.getPosition()).thenReturn(new PositionModel(10, 5));
        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
        assertEquals(1, diagonalMovementStrategy.getXDirection());
    }
    @Test
    public void testMove_CannotMoveBeyondUpperBound() {
        when(monster.getPosition()).thenReturn(new PositionModel(10, 5));

        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
        assertEquals(1, diagonalMovementStrategy.getXDirection());
    }
    @Test
    public void testMove_CannotMoveBeyondLowerBound() {
        when(monster.getPosition()).thenReturn(new PositionModel(-1, 5));

        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
        assertEquals(1, diagonalMovementStrategy.getXDirection());
    }

    @Test
    public void testMove_SwitchDirectionRandomly() {
        when(monster.getPosition()).thenReturn(new PositionModel(5, 5));
        when(monster.getSpeed()).thenReturn(1);

        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
        assertNotEquals(diagonalMovementStrategy.getXDirection(), 0);
    }

    @Test
    public void testMove_CanMove_NegatedConditional() {
        when(monster.getPosition()).thenReturn(new PositionModel(1, 5));
        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
        assertEquals(1, diagonalMovementStrategy.getXDirection());
    }
    @Test
    public void testMove_CorrectedXDirectionOnSubtraction() {
        when(monster.getPosition()).thenReturn(new PositionModel(3, 5));

        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
        assertEquals(1, diagonalMovementStrategy.getXDirection());
    }
    @Test
    public void testMove_CorrectedXDirectionOnMultiplication() {
        when(monster.getPosition()).thenReturn(new PositionModel(5, 5));
        when(monster.getSpeed()).thenReturn(2);

        diagonalMovementStrategy.move(monster);

        verify(monster, times(1)).getPosition();
        assertEquals(1, diagonalMovementStrategy.getXDirection());
    }
}

