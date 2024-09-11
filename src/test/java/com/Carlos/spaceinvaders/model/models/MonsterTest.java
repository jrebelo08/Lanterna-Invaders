package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterTest {
    private MonsterModel monster;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(0, 0);
        int speed = 5;
        monster = new MonsterModel(position, speed);
    }

    @Test
    public void testMove() {
        monster.move();
        assertEquals(5, monster.getPosition().getY());

        monster.setDirection(true);
        monster.move();
        assertEquals(0, monster.getPosition().getY());
    }

    @Test
    public void testMoveWithDirection() {
        monster.setDirection(true);
        monster.move();
        assertEquals(-5, monster.getPosition().getY());
    }

    @Test
    public void testGetSpeed() {
        int speed = monster.getSpeed();
        assertEquals(5, speed);
    }

    @Test
    public void testSetDirection() {
        monster.setDirection(true);
        boolean direction = monster.getDirection();
        assertEquals(true, direction);
    }
}
