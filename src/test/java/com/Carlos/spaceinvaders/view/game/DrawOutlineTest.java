package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.WallModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class DrawOutlineTest {

    @Mock
    private LanternaGui mockGui;

    private DrawOutline drawOutline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<WallModel> walls = new ArrayList<>();
        drawOutline = new DrawOutline(walls);
    }

    @Test
    void draw_ShouldDrawEachWallModel() {
        WallModel wallModel1 = mock(WallModel.class);
        WallModel wallModel2 = mock(WallModel.class);
        PositionModel positionModel1 = new PositionModel(0, 0); 
        PositionModel positionModel2 = new PositionModel(1000, 1000);
        when(wallModel1.getPosition()).thenReturn(positionModel1);
        when(wallModel2.getPosition()).thenReturn(positionModel2);

        List<WallModel> walls = new ArrayList<>();
        walls.add(wallModel1);
        walls.add(wallModel2);

        DrawOutline drawOutline = new DrawOutline(walls);

        drawOutline.draw(mockGui);

        verify(mockGui, times(1)).drawText(eq(positionModel1), eq("*"), eq(new TextColor.RGB(255, 255, 255)));
        verify(mockGui, times(1)).drawText(eq(positionModel2), eq("*"), eq(new TextColor.RGB(255, 255, 255)));
    }
}
