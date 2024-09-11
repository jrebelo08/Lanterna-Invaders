package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PowerUpTest {

    @Test
    public void testGetPowerUpType() {
        PositionModel position = new PositionModel(0, 0);
        PowerUpModel powerUp = new PowerUpModel(position, 1, PowerUpModel.PowerUpType.HealthBoost);
        assertEquals(PowerUpModel.PowerUpType.HealthBoost, powerUp.getPowerUpType());
    }

    @Test
    public void testGetSpeed() {
        PositionModel position = new PositionModel(0, 0);
        PowerUpModel powerUp = new PowerUpModel(position, 2, PowerUpModel.PowerUpType.ScoreBoost);
        assertEquals(2, powerUp.getSpeed());
    }

    @Test
    public void testIncrementActive() {
        PositionModel position = new PositionModel(0, 0);
        PowerUpModel powerUp = new PowerUpModel(position, 3, PowerUpModel.PowerUpType.ScoreBoost);
        powerUp.incrementActive();
        assertEquals(1, powerUp.isActive());
    }

    @Test
    public void testMove() {
        PositionModel position = new PositionModel(0, 0);
        PowerUpModel powerUp = new PowerUpModel(position, 4, PowerUpModel.PowerUpType.HealthBoost);
        powerUp.move();
        assertEquals(4, powerUp.getPosition().getY());
    }
}