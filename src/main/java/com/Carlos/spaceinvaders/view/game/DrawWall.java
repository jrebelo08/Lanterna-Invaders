package com.Carlos.spaceinvaders.view.game;
import com.Carlos.spaceinvaders.model.models.WallModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;


public class DrawWall extends Viewer<WallModel> implements DrawElement {

    public DrawWall(WallModel wall){
        super(wall);
    }

    @Override
    public void draw(LanternaGui GUI) {
        WallModel wallModel = getModel();
        GUI.drawText(wallModel.getPosition(),"*",new TextColor.RGB(255,255,255));
        }
    }

