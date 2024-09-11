package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.WallModel;

import java.util.ArrayList;
import java.util.List;

public class WallFactory {
    public WallFactory(int arenaX, int arenaY, List<WallModel> walls){

        walls.addAll(createWalls(arenaX, arenaY));
    }

    public static List<WallModel> createWalls (int width, int height){
        List<WallModel> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new WallModel(new PositionModel(c, 0)));
        }

        for (int c = 0; c < width; c++) {
            walls.add(new WallModel(new PositionModel(c, height - 1)));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new WallModel(new PositionModel(0, r)));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new WallModel(new PositionModel(width - 1, r)));
        }

        return walls;
    }
}
