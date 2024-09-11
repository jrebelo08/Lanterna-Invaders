package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.WallModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class DrawWallTest {

    @Test
    public void testDraw() {
        LanternaGui guiMock = Mockito.mock(LanternaGui.class);

        PositionModel position = new PositionModel(0, 0);
        WallModel wallModel = new WallModel(position);

        DrawWall drawWall = new DrawWall(wallModel);

        drawWall.draw(guiMock);

        verify(guiMock).drawText(wallModel.getPosition(), "*", new TextColor.RGB(255, 255, 255));
    }

    @Test
    public void testDrawWithDifferentPosition() {
        LanternaGui guiMock = Mockito.mock(LanternaGui.class);

        PositionModel position = new PositionModel(10, 10);
        WallModel wallModel = new WallModel(position);

        DrawWall drawWall = new DrawWall(wallModel);

        drawWall.draw(guiMock);

        verify(guiMock).drawText(wallModel.getPosition(), "*", new TextColor.RGB(255, 255, 255));
    }
}
