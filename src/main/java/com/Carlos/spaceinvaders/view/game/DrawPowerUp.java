package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;

import com.Carlos.spaceinvaders.model.models.PowerUpModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawPowerUp extends Viewer<PowerUpModel> implements DrawElement {

    public DrawPowerUp(PowerUpModel powerUp){
        super(powerUp);
    }
    @Override
    public void draw(LanternaGui GUI){
        PowerUpModel powerUp = getModel();
        if(powerUp.isActive() != 2){
            if(powerUp.getPowerUpType() == PowerUpModel.PowerUpType.HealthBoost)
                GUI.drawText(powerUp.getPosition(),"+",new TextColor.RGB(0,255,0));
            if(powerUp.getPowerUpType() == PowerUpModel.PowerUpType.ScoreBoost)
                GUI.drawText(powerUp.getPosition(),"★",new TextColor.RGB(255,255,0));
            if(powerUp.getPowerUpType() == PowerUpModel.PowerUpType.FireRateBoost)
                GUI.drawText(powerUp.getPosition(),"$",new TextColor.RGB(0,255,255));
        }
    }
}