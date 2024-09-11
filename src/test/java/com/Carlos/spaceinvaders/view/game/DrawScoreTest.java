package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class DrawScoreTest {

    @Test
    public void testDraw() {
        LanternaGui guiMock = Mockito.mock(LanternaGui.class);

        PositionModel position = new PositionModel(10, 10);
        ScoreModel scoreModel = new ScoreModel(position);
        scoreModel.setScore(100);

        DrawScore drawScore = new DrawScore(scoreModel);

        drawScore.draw(guiMock);

        verify(guiMock).drawText(scoreModel.getPosition(), "100", new TextColor.RGB(255, 255, 255));
    }
}
