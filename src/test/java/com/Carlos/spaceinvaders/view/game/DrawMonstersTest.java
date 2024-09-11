
package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
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

public class DrawMonstersTest{
    @Mock
    private LanternaGui guiMock;

    private DrawMonsters drawMonsters;
    private List<MonsterModel> monsters;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        monsters = new ArrayList<>();

    }

    @Test
    public void testDrawDiagonalAndShooter() {
        PositionModel position1 = new PositionModel(41, 1);
        MonsterModel monster1 = new MonsterModel(position1, 1);
        monster1.setMoveType(MonsterModel.MoveType.Shooter);

        PositionModel position2 = new PositionModel(40, 1);
        MonsterModel monster2 = new MonsterModel(position2, 1);
        monster2.setMoveType(MonsterModel.MoveType.Diagonal);

        monsters.add(monster1);
        monsters.add(monster2);

        drawMonsters = new DrawMonsters(monsters);
        drawMonsters.draw(guiMock);

        verify(guiMock, times(1)).drawText(eq( new PositionModel(41, 1)), eq("["), eq(new TextColor.RGB(0, 100, 0)));
        verify(guiMock, times(1)).drawText(eq( new PositionModel(40, 1)), eq("]"),eq(new TextColor.RGB(255, 0, 0)));

    }

    @Test
    public void testDrawEmpty(){
        drawMonsters = new DrawMonsters(monsters);
        drawMonsters.draw(guiMock);
        verify(guiMock, times(0)).drawText(any(PositionModel.class), any(String.class), any(TextColor.RGB.class));
    }

    @Test
    public void testDrawDiagonalAndVertical() {
        PositionModel position1 = new PositionModel(41, 1);
        MonsterModel monster1 = new MonsterModel(position1, 1);
        monster1.setMoveType(MonsterModel.MoveType.Vertical);

        PositionModel position2 = new PositionModel(40, 1);
        MonsterModel monster2 = new MonsterModel(position2, 1);
        monster2.setMoveType(MonsterModel.MoveType.Diagonal);

        monsters.add(monster1);
        monsters.add(monster2);

        drawMonsters = new DrawMonsters(monsters);
        drawMonsters.draw(guiMock);

        verify(guiMock, times(1)).drawText(eq( new PositionModel(41, 1)), eq("]"), eq(new TextColor.RGB(255, 0, 0)));
        verify(guiMock, times(1)).drawText(eq( new PositionModel(40, 1)), eq("]"),eq(new TextColor.RGB(255, 0, 0)));

    }
    @Test
    public void testDrawMultipleVertical() {
        PositionModel position1 = new PositionModel(41, 1);
        MonsterModel monster1 = new MonsterModel(position1, 1);
        monster1.setMoveType(MonsterModel.MoveType.Vertical);

        PositionModel position2 = new PositionModel(42, 1);
        MonsterModel monster2 = new MonsterModel(position2, 1);
        monster2.setMoveType(MonsterModel.MoveType.Vertical);

        PositionModel position3 = new PositionModel(43, 1);
        MonsterModel monster3 = new MonsterModel(position3, 1);
        monster3.setMoveType(MonsterModel.MoveType.Vertical);




        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);

        drawMonsters = new DrawMonsters(monsters);
        drawMonsters.draw(guiMock);

        verify(guiMock, times(1)).drawText(eq( new PositionModel(41, 1)), eq("]"), eq(new TextColor.RGB(255, 0, 0)));
        verify(guiMock, times(1)).drawText(eq( new PositionModel(42, 1)), eq("]"),eq(new TextColor.RGB(255, 0, 0)));
        verify(guiMock, times(1)).drawText(eq( new PositionModel(43, 1)), eq("]"),eq(new TextColor.RGB(255, 0, 0)));

    }

}
