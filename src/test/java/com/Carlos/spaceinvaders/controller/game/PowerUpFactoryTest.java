package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.PowerUpModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PowerUpFactoryTest {

    private PowerUpFactory powerUpFactory;
    private List<PowerUpModel> activePowerUps;

    @BeforeEach
    public void setUp() {
        activePowerUps = new ArrayList<>();
        powerUpFactory = new PowerUpFactory(activePowerUps);
    }

    @Test
    public void testCreatePowerUp() {
        long time = System.currentTimeMillis();
        int arenaX = 10;

        powerUpFactory.createPowerUp(time, arenaX);

        assertEquals(1, activePowerUps.size());
        assertEquals(time, powerUpFactory.getLastCreation());
    }

    @Test
    public void testCreatePowerUp_DelayNotPassed() {
        long time = System.currentTimeMillis();
        int arenaX = 10;

        powerUpFactory.createPowerUp(time, arenaX);

        powerUpFactory.createPowerUp(time + powerUpFactory.getDelay() - 1, arenaX);

        assertEquals(1, activePowerUps.size());
        assertEquals(time, powerUpFactory.getLastCreation());
    }

    @Test
    public void testCreatePowerUp_DelayPassed() {
        long time = System.currentTimeMillis();
        int arenaX = 10;

        powerUpFactory.createPowerUp(time, arenaX);

        powerUpFactory.createPowerUp(time, arenaX);

        assertEquals(1, activePowerUps.size());
    }

    @Test
    public void testSetDelay() {
        long delay = 5000;

        powerUpFactory.setDelay(delay);

        assertEquals(delay, powerUpFactory.getDelay());
    }
}