package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PowerUpControllerTest {

    private PowerUpController powerUpController;
    private List<PowerUpModel> powerUps;

    @BeforeEach
    public void setUp() {
        powerUps = new ArrayList<>();
        powerUpController = new PowerUpController(powerUps);
    }

    @Test
    public void testMove() {
        PowerUpModel powerUp1 = mock(PowerUpModel.class);
        PowerUpModel powerUp2 = mock(PowerUpModel.class);
        powerUps.add(powerUp1);
        powerUps.add(powerUp2);

        powerUpController.move();

        verify(powerUp1, times(1)).move();
        verify(powerUp2, times(1)).move();
    }
    @Test
    public void testSetLastMove() {
        int move = 1000;

        powerUpController.setLastMove(move);

        assertEquals(move, powerUpController.getLastMove());
    }

    @Test
    public void testToDo_MovePowerUpsWhenTimeDifferenceIsGreaterThan1500() {
        Game game = mock(Game.class);
        long currentTime = 2000;
        PowerUpModel powerUp = mock(PowerUpModel.class);
        powerUps.add(powerUp);
        powerUpController.setLastMove(500);

        powerUpController.toDo(game, "keyPressed", currentTime);
        verify(powerUp, never()).move();
        assertEquals(500, powerUpController.getLastMove());
    }


    @Test
    public void testToDo_DoesNotMovePowerUpsWhenTimeDifferenceIsLessThan1500() {
        Game game = mock(Game.class);
        long currentTime = 1000;
        PowerUpModel powerUp = mock(PowerUpModel.class);
        powerUps.add(powerUp);
        powerUpController.setLastMove(500);

        powerUpController.toDo(game, "keyPressed", currentTime);
        verify(powerUp, never()).move();
        assertEquals(500, powerUpController.getLastMove());
    }

    @Test
    public void testToDo_DoesNotMovePowerUpsWhenListIsEmpty() {
        Game game = mock(Game.class);
        long currentTime = 2000;

        powerUpController.toDo(game, "keyPressed", currentTime);

        for (PowerUpModel powerUp : powerUps) {
            verifyZeroInteractions(powerUp);
        }

        assertEquals(0, powerUpController.getLastMove());
    }
}