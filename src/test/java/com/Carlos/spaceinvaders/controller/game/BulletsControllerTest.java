package com.Carlos.spaceinvaders.controller.game;


import com.Carlos.spaceinvaders.model.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BulletsControllerTest {

    private BulletsController bulletsController;
    private List<BulletModel> bullets;
    private List<MonsterModel> activeMonsters;
    private List<PowerUpModel> activePowerUps;
    private PlayerModel playerModel;
    private ScoreModel scoreModel;
    private int arenaH;

    @BeforeEach
    public void setUp() {
        bullets = new ArrayList<>();
        activeMonsters = new ArrayList<>();
        activePowerUps = new ArrayList<>();
        playerModel = new PlayerModel(new PositionModel(5,5),3);
        scoreModel = new ScoreModel(new PositionModel(10,10));
        arenaH = 100;
        bulletsController = new BulletsController(bullets, activeMonsters, activePowerUps, playerModel, scoreModel,arenaH);
    }
    @Test
    public void testMove_bulletCollidesWithMonster() {
        BulletModel bullet = new BulletModel(new PositionModel(5,10),1,true);
        bullet.setActive(true);
        bullet.setPosition(new PositionModel(0, 1));
        bullet.setDirection(true);
        bullet.setSpeed(1);
        bullets.add(bullet);

        MonsterModel monster = new MonsterModel(new PositionModel(5,11), 1);
        monster.setPosition(new PositionModel(0, 0));
        activeMonsters.add(monster);

        bulletsController.move(bullet, 0);

        assertTrue(activeMonsters.isEmpty());
        assertEquals(1, scoreModel.getScore());
    }

    @Test
    public void testMove_bulletCollidesWithPowerUp() {
        BulletModel bullet = new BulletModel(new PositionModel(5,10),1,true);
        bullet.setActive(true);
        bullet.setPosition(new PositionModel(0, 1));
        bullet.setDirection(true);
        bullet.setSpeed(1);
        bullets.add(bullet);

        PowerUpModel powerUp = new PowerUpModel(new PositionModel(10,5),5, PowerUpModel.PowerUpType.ScoreBoost);
        powerUp.setPosition(new PositionModel(0, 0));
        activePowerUps.add(powerUp);

        bulletsController.move(bullet, 0);

        assertTrue(activePowerUps.isEmpty());
        assertEquals(1, powerUp.isActive());
    }

    @Test
    public void testMove_bulletDoesNotCollide() {
        BulletModel bullet = new BulletModel(new PositionModel(5,10),5,true);
        bullet.setActive(true);
        bullet.setPosition(new PositionModel(0, 0));
        bullet.setDirection(true);
        bullet.setSpeed(1);
        bullets.add(bullet);

        bulletsController.move(bullet, 0);

        assertEquals(0, scoreModel.getScore());
    }

    @Test
    public void testCalculateNewPosition_bulletMovingUp() {
        BulletModel bullet = new BulletModel(new PositionModel(5,10),5,true);
        bullet.setPosition(new PositionModel(0, 1));
        bullet.setDirection(true);
        bullet.setSpeed(1);

        PositionModel newPosition = bulletsController.calculateNewPosition(bullet);

        assertEquals(0, newPosition.getX());
        assertEquals(0, newPosition.getY());
    }

    @Test
    public void testCalculateNewPosition_bulletMovingDown() {
        BulletModel bullet = new BulletModel(new PositionModel(5,10),5,true);
        bullet.setPosition(new PositionModel(0, 0));
        bullet.setDirection(false);
        bullet.setSpeed(1);

        PositionModel newPosition = bulletsController.calculateNewPosition(bullet);

        assertEquals(0, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }

    @Test
    public void testColide_bulletCollidesWithMonster() {
        PositionModel nextPosition = new PositionModel(0, 1);
        MonsterModel monster = new MonsterModel(new PositionModel(10,10), 5);
        monster.setPosition(nextPosition);
        activeMonsters.add(monster);

        boolean result = bulletsController.colide(nextPosition, 0, true);

        assertTrue(result);
        assertTrue(activeMonsters.isEmpty());
        assertEquals(1, scoreModel.getScore());
    }

    @Test
    public void testColide_bulletCollidesWithPowerUp() {
        PositionModel nextPosition = new PositionModel(0, 1);
        PowerUpModel powerUp = new PowerUpModel(new PositionModel(10,5),5, PowerUpModel.PowerUpType.ScoreBoost);
        powerUp.setPosition(nextPosition);
        activePowerUps.add(powerUp);

        boolean result = bulletsController.colide(nextPosition, 0, true);

        assertFalse(result);
        assertTrue(activePowerUps.isEmpty());
    }

    @Test
    public void testColide_bulletDoesNotCollide() {
        PositionModel nextPosition = new PositionModel(0, 1);

        boolean result = bulletsController.colide(nextPosition, 0, true);

        assertFalse(result);
    }

    @Test
    public void testIsMonster_nextPositionIsMonster() {
        PositionModel nextPosition = new PositionModel(0, 1);
        MonsterModel monster = new MonsterModel(new PositionModel(10,10), 5);
        monster.setPosition(nextPosition);
        activeMonsters.add(monster);

        MonsterModel result = bulletsController.isMonster(nextPosition);

        assertEquals(monster, result);
    }

    @Test
    public void testIsMonster_nextPositionIsNotMonster() {
        PositionModel nextPosition = new PositionModel(0, 1);

        MonsterModel result = bulletsController.isMonster(nextPosition);

        assertNull(result);
    }

    @Test
    public void testIsPlayer_nextPositionIsPlayer() {
        PositionModel nextPosition = new PositionModel(0, 0);
        playerModel.setPosition(nextPosition);

        boolean result = bulletsController.isPlayer(nextPosition);

        assertTrue(result);
        assertEquals(2, playerModel.getHitPoints());
    }

    @Test
    public void testIsPlayer_nextPositionIsNotPlayer() {
        PositionModel nextPosition = new PositionModel(0, 1);

        boolean result = bulletsController.isPlayer(nextPosition);

        assertFalse(result);
    }

    @Test
    public void testIsPowerUp_nextPositionIsPowerUp() {
        PositionModel nextPosition = new PositionModel(0, 1);
        PowerUpModel powerUp = new PowerUpModel(new PositionModel(10,5),3, PowerUpModel.PowerUpType.HealthBoost);
        powerUp.setPosition(nextPosition);
        activePowerUps.add(powerUp);

        PowerUpModel result = bulletsController.isPowerUp(nextPosition);

        assertEquals(powerUp, result);
    }

    @Test
    public void testIsPowerUp_nextPositionIsNotPowerUp() {
        PositionModel nextPosition = new PositionModel(0, 1);

        PowerUpModel result = bulletsController.isPowerUp(nextPosition);

        assertNull(result);
    }

    @Test
    public void testProcessPowerUp_scoreBoost() {
        PowerUpModel powerUp = new PowerUpModel(new PositionModel(10,5),5, PowerUpModel.PowerUpType.ScoreBoost);
        powerUp.setPowerUpType(PowerUpModel.PowerUpType.ScoreBoost);

        bulletsController.processPowerUp(powerUp, 0);

        assertEquals(5, scoreModel.getIncrementValue());
        assertEquals(PowerUpModel.PowerUpType.ScoreBoost, playerModel.getPowerUpType());
    }

    @Test
    public void testScoreBoost() {
        scoreModel.setIncrementValue(0);

        bulletsController.ScoreBoost();

        assertEquals(5, scoreModel.getIncrementValue());
        assertEquals(PowerUpModel.PowerUpType.ScoreBoost, playerModel.getPowerUpType());
    }

    @Test
    public void testHealthBoost() {
        playerModel.setHitPoints(2);

        bulletsController.HealthBoost();

        assertEquals(3, playerModel.getHitPoints());
    }
}