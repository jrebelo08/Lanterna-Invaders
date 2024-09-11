package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class WallTest {

    @Test
    public void testWallModelCreation() {
        PositionModel position = new PositionModel(0, 0);
        WallModel wall = new WallModel(position);

        assertNotNull(wall);
        assertEquals(position, wall.getPosition());
    }
}
