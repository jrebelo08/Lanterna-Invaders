package com.Carlos.spaceinvaders.controller.game.MonsterStrategy;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.VerticalMovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VerticalMovementStrategyTest {

    private VerticalMovementStrategy verticalMovementStrategy;
    private MonsterModel monster;
    private PositionModel positionModel;

    @BeforeEach
    public void setUp() {
        monster = mock(MonsterModel.class);
        positionModel = new PositionModel(5, 5);
        when(monster.getPosition()).thenReturn(positionModel);
        when(monster.getSpeed()).thenReturn(1);
        verticalMovementStrategy = new VerticalMovementStrategy();
    }

    @Test
    public void testMove() {
        verticalMovementStrategy.move(monster);
        verify(monster, times(1)).setPosition(any(PositionModel.class));
    }
    @Test
    public void testMoveWithNegativeSpeed() {
        when(monster.getSpeed()).thenReturn(-1);
        verticalMovementStrategy.move(monster);
        verify(monster, times(1)).setPosition(argThat(position -> position.getY() == 4));
    }


    @Test
    public void testMoveWithZeroSpeed() {
        when(monster.getSpeed()).thenReturn(0);
        verticalMovementStrategy.move(monster);
        verify(monster, times(1)).setPosition(argThat(position -> position.getY() == 5));
    }

    @Test
    public void testMoveMultipleTimes() {
        when(monster.getSpeed()).thenReturn(2);
        PositionModel initialPosition = new PositionModel(positionModel.getX(), positionModel.getY());
        verticalMovementStrategy.move(monster);
        verticalMovementStrategy.move(monster);
        verify(monster, times(2)).setPosition(argThat(position -> position.getY() == initialPosition.getY() + 4));
    }


    @Test
    public void testMoveWithLargeSpeed() {
        when(monster.getSpeed()).thenReturn(10);
        verticalMovementStrategy.move(monster);
        verify(monster, times(1)).setPosition(argThat(position -> position.getY() == 15));
    }
}