package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class DrawMonsterTest {

    LanternaGui guiMock;
    PositionModel positionModel;
    MonsterModel monsterModel;
    DrawMonster drawMonster;

    @BeforeEach
    public void setup() {
        guiMock = mock(LanternaGui.class);
        positionModel = new PositionModel(40,1);
        monsterModel = new MonsterModel(positionModel, 1);
        drawMonster = new DrawMonster(monsterModel);
    }

    @Test
    public void testDrawWithDiagonalMove() {

        monsterModel.setMoveType(MonsterModel.MoveType.Diagonal);
        drawMonster.draw(guiMock);
        verify(guiMock).drawText(monsterModel.getPosition(), "]", new TextColor.RGB(255, 0, 0));
    }

    @Test
    public void testDrawWithShooterMove() {
        monsterModel.setMoveType(MonsterModel.MoveType.Shooter);
        drawMonster.draw(guiMock);
        verify(guiMock).drawText(monsterModel.getPosition(), "[", new TextColor.RGB(0, 100, 0));
    }

    @Test
    public void testDrawWithVerticalMove() {
        monsterModel.setMoveType(MonsterModel.MoveType.Vertical);
        drawMonster.draw(guiMock);
        verify(guiMock).drawText(monsterModel.getPosition(), "]", new TextColor.RGB(255, 0, 0));
    }
}