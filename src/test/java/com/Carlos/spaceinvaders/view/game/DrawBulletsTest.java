package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DrawBulletsTest {

    @Mock
    private LanternaGui guiMock;

    private DrawBullets drawBullets;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        List<BulletModel> bullets = new ArrayList<>();
        PositionModel position1 = new PositionModel(1, 1);
        BulletModel bullet1 = new BulletModel(position1, 5, true);

        PositionModel position2 = new PositionModel(2, 2);
        BulletModel bullet2 = new BulletModel(position2, 3, false);
        bullets.add(bullet1);
        bullets.add(bullet2);
        drawBullets = new DrawBullets(bullets);
    }

    @Test
    public void testDraw() {
    
    drawBullets.draw(guiMock);
    
    verify(guiMock, times(2)).drawText(any(PositionModel.class), any(String.class), any(TextColor.RGB.class));
    }
}