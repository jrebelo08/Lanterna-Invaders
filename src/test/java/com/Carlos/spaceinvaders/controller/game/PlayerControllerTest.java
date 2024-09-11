package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.SoundController;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerTest {

    private PlayerController playerController;
    private List<BulletModel> bullets;
    private SoundController soundController;
    private int arenaW;

    @BeforeEach
    public void setUp() {
        PlayerModel playerModel = new PlayerModel(new PositionModel(10,5),3);
        int arenaW = 10;
        bullets = new ArrayList<>();
        soundController = new SoundController();

        playerController = new PlayerController(playerModel, arenaW, bullets, soundController);
    }

    @Test
    public void testMoveLeft() {
        int initialX = playerController.getModel().getPosition().getX();
        playerController.moveLeft();
        int newX = playerController.getModel().getPosition().getX();

        assertEquals(initialX, newX);
    }

    @Test
    public void testMoveRight() {
        int initialX = playerController.getModel().getPosition().getX();
        playerController.moveRight();
        int newX = playerController.getModel().getPosition().getX();

        assertEquals(initialX , newX);
    }

    @Test
    public void testMoveLeftBoundary() {
        playerController.getModel().getPosition().setX(2);
        playerController.moveLeft();
        int newX = playerController.getModel().getPosition().getX();

        assertEquals(1, newX);
    }

    @Test
    public void testMoveRightBoundary() {
        playerController.getModel().getPosition().setX(arenaW - 3);
        playerController.moveRight();
        int newX = playerController.getModel().getPosition().getX();

        assertEquals(arenaW - 3, newX);
    }

    @Test
    public void testShoot() {
        long currentTime = System.currentTimeMillis();
        int initialBulletsSize = bullets.size();

        playerController.shoot(currentTime);

        assertEquals(initialBulletsSize + 1, bullets.size());
    }
}