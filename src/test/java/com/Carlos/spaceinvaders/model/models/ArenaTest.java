package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArenaTest {

    private ArenaModel arenaModel;

    @BeforeEach
    public void setUp() {
        arenaModel = new ArenaModel(100, 80);
    }

    @Test
    public void testGetWidth() {
        int expectedWidth = 100;
        int actualWidth = arenaModel.getWidth();
        assertEquals(expectedWidth, actualWidth);
    }

    @Test
    public void testGetHeight() {
        int expectedHeight = 80;
        int actualHeight = arenaModel.getHeight();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    public void testGetPlayer() {
        PlayerModel playerModel = arenaModel.getPlayer();
        assertNotNull(playerModel);
    }

    @Test
    public void testGetActiveBullets() {
        List<BulletModel> activeBullets = arenaModel.getActiveBullets();
        assertNotNull(activeBullets);
    }

    @Test
    public void testGetActiveMonsters() {
        List<MonsterModel> activeMonsters = arenaModel.getActiveMonsters();
        assertNotNull(activeMonsters);
    }

    @Test
    public void testGetWalls() {
        List<WallModel> walls = arenaModel.getWalls();
        assertNotNull(walls);
    }

    @Test
    public void testGetScore() {
        ScoreModel scoreModel = arenaModel.getScore();
        assertNotNull(scoreModel);
    }

    @Test
    public void testGetActivePowerUps() {
        List<PowerUpModel> activePowerUps = arenaModel.getActivePowerUps();
        assertNotNull(activePowerUps);
    }
}