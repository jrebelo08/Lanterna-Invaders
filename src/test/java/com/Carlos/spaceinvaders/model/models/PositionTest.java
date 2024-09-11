package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PositionTest {

    @Test
    public void testGetX() {
        PositionModel position = new PositionModel(10, 20);
        Assertions.assertEquals(10, position.getX());
    }

    @Test
    public void testSetX() {
        PositionModel position = new PositionModel(10, 20);
        position.setX(30);
        Assertions.assertEquals(30, position.getX());
    }

    @Test
    public void testGetY() {
        PositionModel position = new PositionModel(10, 20);
        Assertions.assertEquals(20, position.getY());
    }

    @Test
    public void testSetY() {
        PositionModel position = new PositionModel(10, 20);
        position.setY(30);
        Assertions.assertEquals(30, position.getY());
    }

    @Test
    public void testEquals() {
        PositionModel position1 = new PositionModel(10, 20);
        PositionModel position2 = new PositionModel(10, 20);
        PositionModel position3 = new PositionModel(30, 40);

        Assertions.assertEquals(position1, position2);
        Assertions.assertNotEquals(position1, position3);
    }
    @Test
    public void testGetRightBound() {
        PositionModel position = new PositionModel(10, 20);
        PositionModel expectedRightBound = new PositionModel(11, 20);
        Assertions.assertEquals(expectedRightBound, position.getRightBound());
    }
    @Test
    public void testGetLeftBound() {
        PositionModel position = new PositionModel(10, 20);
        PositionModel expectedLeftBound = new PositionModel(9, 20);
        Assertions.assertEquals(expectedLeftBound, position.getLeftBound());
    }
    @Test
    public void testHashCode() {
        PositionModel position1 = new PositionModel(10, 20);
        PositionModel position2 = new PositionModel(10, 20);
        PositionModel position3 = new PositionModel(30, 40);

        Assertions.assertEquals(position1.hashCode(), position2.hashCode());
        Assertions.assertNotEquals(position1.hashCode(), position3.hashCode());
    }
}
