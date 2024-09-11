package com.Carlos.spaceinvaders.model.builders;

import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.WallModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateWallsTest {

    @Test
    public void testCreateWalls() {
        int width = 10;
        int height = 8;

        List<WallModel> walls = CreateWalls.createWalls(width, height);

        for (int c = 0; c < width; c++) {
            WallModel wall = walls.get(c);
            PositionModel position = wall.getPosition();
            assertEquals(c, position.getX());
            assertEquals(0, position.getY());
        }

        for (int c = 0; c < width; c++) {
            WallModel wall = walls.get(c + width);
            PositionModel position = wall.getPosition();
            assertEquals(c, position.getX());
            assertEquals(height - 1, position.getY());
        }

        for (int r = 1; r < height - 1; r++) {
            WallModel wall = walls.get(2 * width + r - 1);
            PositionModel position = wall.getPosition();
            assertEquals(0, position.getX());
            assertEquals(r, position.getY());
        }

        for (int r = 1; r < height - 1; r++) {
            WallModel wall = walls.get(2 * width + height - 2 + r - 1);
            PositionModel position = wall.getPosition();
            assertEquals(width - 1, position.getX());
            assertEquals(r, position.getY());
        }
    }
    
    @Test
    public void testCreateWallsWithZeroWidthAndHeight() {
        int width = 0;
        int height = 0;

        List<WallModel> walls = CreateWalls.createWalls(width, height);

        assertEquals(0, walls.size());
    }
    
    @Test
    public void testCreateWallsWithNegativeWidthAndHeight() {
        int width = -10;
        int height = -8;

        List<WallModel> walls = CreateWalls.createWalls(width, height);

        assertEquals(0, walls.size());
    }
}