package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BulletTest {

    private BulletModel bulletModel;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(0, 0);
        bulletModel = new BulletModel(position, 10, true);
    }

    @Test
    public void testGetActive() {
        assertTrue(bulletModel.getActive());
    }

    @Test
    public void testProcessActiveWhenDirectionIsTrue() {
        bulletModel.getPosition().setY(-1);
        bulletModel.processActive(10);
        assertFalse(bulletModel.getActive());
    }

    @Test
    public void testProcessActiveWhenDirectionIsFalse() {
        bulletModel.getPosition().setY(11);
        bulletModel.setDirection(false);
        bulletModel.processActive(10);
        assertFalse(bulletModel.getActive());
    }

    @Test
    public void testSetActive() {
        bulletModel.setActive(false);
        assertFalse(bulletModel.getActive());
    }

    @Test
    public void testGetDirection() {
        assertTrue(bulletModel.getDirection());
    }

    @Test
    public void testGetSpeed() {
        assertEquals(10, bulletModel.getSpeed());
    }

    @Test
    public void testSetDirection() {
        bulletModel.setDirection(false);
        assertFalse(bulletModel.getDirection());
    }

    @Test
    public void testSetSpeed() {
        bulletModel.setSpeed(20);
        assertEquals(20, bulletModel.getSpeed());
    }
}