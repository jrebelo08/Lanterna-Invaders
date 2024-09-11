package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DrawBulletTest {

    @Test
    public void testDraw() {
        LanternaGui guiMock = mock(LanternaGui.class);

        PositionModel positionModel = new PositionModel(0, 0);

        BulletModel bulletModel = new BulletModel(positionModel, 1, true);

        DrawBullet drawBullet = new DrawBullet(bulletModel);

        drawBullet.draw(guiMock);

        verify(guiMock).drawText(bulletModel.getPosition(), "|", new TextColor.RGB(0, 255, 0));
    }
}
