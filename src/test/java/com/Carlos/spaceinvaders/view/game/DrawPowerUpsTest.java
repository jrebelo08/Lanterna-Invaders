
package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DrawPowerUpsTest{
    @Mock
    private LanternaGui guiMock;

    private DrawPowerUps drawPowerUps;
    private List<PowerUpModel> powerUps;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        powerUps = new ArrayList<>();

    }

    @Test
    public void testDrawHealthAndScoreBoost() {
        PositionModel position1 = new PositionModel(41, 1);
        PowerUpModel powerUp1 = new PowerUpModel(position1, 1, PowerUpModel.PowerUpType.HealthBoost);


        PositionModel position2 = new PositionModel(40, 1);
        PowerUpModel powerUp2 = new PowerUpModel(position2, 1, PowerUpModel.PowerUpType.ScoreBoost);


        powerUps.add(powerUp1);
        powerUps.add(powerUp2);


        drawPowerUps = new DrawPowerUps(powerUps);
        drawPowerUps.draw(guiMock);

        verify(guiMock, times(1)).drawText(eq( new PositionModel(41, 1)), eq("+"),eq(new TextColor.RGB(0, 255, 0)));
        verify(guiMock, times(1)).drawText(eq( new PositionModel(40, 1)), eq("★"),eq(new TextColor.RGB(255, 255, 0)));

    }

    @Test
    public void testDrawEmpty(){
        drawPowerUps = new DrawPowerUps(powerUps);
        drawPowerUps.draw(guiMock);
        verify(guiMock, times(0)).drawText(any(PositionModel.class), any(String.class), any(TextColor.RGB.class));
    }


    @Test
    public void testDrawMultipleVertical() {
        PositionModel position1 = new PositionModel(41, 1);
        PowerUpModel powerUp1 = new PowerUpModel(position1, 1, PowerUpModel.PowerUpType.HealthBoost);


        PositionModel position2 = new PositionModel(42, 1);
        PowerUpModel powerUp2 = new PowerUpModel(position2, 1, PowerUpModel.PowerUpType.HealthBoost);


        PositionModel position3 = new PositionModel(43, 1);
        PowerUpModel powerUp3 = new PowerUpModel(position3, 1, PowerUpModel.PowerUpType.HealthBoost);

        powerUps.add(powerUp1);
        powerUps.add(powerUp2);
        powerUps.add(powerUp3);

        drawPowerUps = new DrawPowerUps(powerUps);
        drawPowerUps.draw(guiMock);

        verify(guiMock, times(1)).drawText(eq( new PositionModel(41, 1)), eq("+"), eq(new TextColor.RGB(0, 255, 0)));
        verify(guiMock, times(1)).drawText(eq( new PositionModel(42, 1)), eq("+"), eq(new TextColor.RGB(0, 255, 0)));
        verify(guiMock, times(1)).drawText(eq( new PositionModel(43, 1)), eq("+"), eq(new TextColor.RGB(0, 255, 0)));

    }

}
