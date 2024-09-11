package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private PlayerModel playerModel;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(0, 0);
        playerModel = new PlayerModel(position, 3);
    }
    /*
    @Test
    public void testCanMove() {
        PositionModel position1 = new PositionModel(5, 0);
        assertTrue(playerModel.canMove(position1));

        PositionModel position2 = new PositionModel(-1, 0);
        assertFalse(playerModel.canMove(position2));
    }
 */
    @Test
    public void testIncrementHitPoints() {
        playerModel.incrementHitPoints();
        assertEquals(4, playerModel.getHitPoints());
    }

    @Test
    public void testDecrementHitPoints() {
        playerModel.decrementHitPoints();
        assertEquals(2, playerModel.getHitPoints());
    }

    @Test
    public void testSetAndGetDelayShooting() {
        long delay = 1000;
        playerModel.setDelayShooting(delay);
        assertEquals(delay, playerModel.getDelayShooting());
    }

    @Test
    public void testSetAndGetPowerUpType() {
        PowerUpModel.PowerUpType powerUpType = PowerUpModel.PowerUpType.ScoreBoost;
        playerModel.setPowerUpType(powerUpType);
        assertEquals(powerUpType, playerModel.getPowerUpType());
    }

    @Test
    public void testSetAndGetHitPoints() {
        int hitPoints = 5;
        playerModel.setHitPoints(hitPoints);
        assertEquals(hitPoints, playerModel.getHitPoints());
    }
}
