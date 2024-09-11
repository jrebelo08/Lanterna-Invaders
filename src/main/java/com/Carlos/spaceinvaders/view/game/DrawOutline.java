package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.model.models.WallModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;

import java.util.List;


public class DrawOutline extends Viewer<List<WallModel>> implements DrawElement {

    public DrawOutline(List<WallModel> walls){
        super(walls);
    }

    @Override
    public void draw(LanternaGui GUI){
        for(WallModel wallModel : getModel()){
            DrawWall drawWall = new DrawWall(wallModel);
            drawWall.draw(GUI);
        }
    }
}
