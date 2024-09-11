package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class DrawPowerUpTest {

    LanternaGui guiMock;
    PositionModel positionModel;
    PowerUpModel powerUpModel;
    DrawPowerUp drawPowerUp;

    @BeforeEach
    public void setup() {
        guiMock = mock(LanternaGui.class);
        positionModel = new PositionModel(40,1);
        powerUpModel = new PowerUpModel(positionModel, 0, null);
        drawPowerUp = new DrawPowerUp(powerUpModel);
    }
    @Test
    public void testDrawScoreBoostPowerUp() {
        powerUpModel.setPowerUpType(PowerUpModel.PowerUpType.ScoreBoost);
        DrawPowerUp drawPowerUp = new DrawPowerUp(powerUpModel);

        drawPowerUp.draw(guiMock);
        verify(guiMock).drawText(powerUpModel.getPosition(), "★", new TextColor.RGB(255, 255, 0));
    }
    @Test
    public void testDrawHealthBoostPowerUp() {
        powerUpModel.setPowerUpType(PowerUpModel.PowerUpType.HealthBoost);
        DrawPowerUp drawPowerUp = new DrawPowerUp(powerUpModel);

        drawPowerUp.draw(guiMock);
        verify(guiMock).drawText(powerUpModel.getPosition(), "+", new TextColor.RGB(0,255,0));
    }
    @Test
    public void testDrawFireRateBoostPowerUp() {
        powerUpModel.setPowerUpType(PowerUpModel.PowerUpType.FireRateBoost);
        DrawPowerUp drawPowerUp = new DrawPowerUp(powerUpModel);

        drawPowerUp.draw(guiMock);
        verify(guiMock).drawText(powerUpModel.getPosition(), "$", new TextColor.RGB(0,255,255));
    }
}