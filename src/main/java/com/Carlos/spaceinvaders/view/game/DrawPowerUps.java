package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;
import com.Carlos.spaceinvaders.view.Viewer;

import java.util.List;

public class DrawPowerUps extends Viewer<List<PowerUpModel>> implements DrawElement{
    public DrawPowerUps(List<PowerUpModel> PowerUp){
        super(PowerUp);
    }

    @Override
    public void draw(LanternaGui GUI){
        for (PowerUpModel PowerUp : getModel()) {
            DrawPowerUp drawPowerUp = new DrawPowerUp(PowerUp);
            drawPowerUp.draw(GUI);
        }
    }
}
