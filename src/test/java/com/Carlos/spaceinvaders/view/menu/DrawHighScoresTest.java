package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class DrawHighScoresTest {

    private LanternaGui gui;
    private HighScoresModel model;
    private DrawHighScores drawHighScores;

    @BeforeEach
    public void setup() {
        gui = mock(LanternaGui.class);
        model = mock(HighScoresModel.class);
        drawHighScores = new DrawHighScores(model);
    }

    @Test
    public void testDrawTitle() {
        drawHighScores.drawTitle(gui);

        verify(gui, times(1)).drawText(new PositionModel(33, 7), "HIGH SCORES", new TextColor.RGB(178, 73, 210), false);
        verify(gui, times(1)).drawText(new PositionModel(32, 11), "NAME", new TextColor.RGB(178, 73, 210), false);
        verify(gui, times(1)).drawText(new PositionModel(42, 11), "SCORE", new TextColor.RGB(178, 73, 210), false);
    }

    @Test
    public void testDrawScores() throws Exception {
        when(model.getFilePath()).thenReturn("scores.txt");
        when(model.getColor(anyInt())).thenReturn(new TextColor.RGB(178, 73, 210));
        when(model.getEntryName()).thenReturn("Test");

        Path path = Files.createTempFile("scores", ".txt");
        Files.write(path, Arrays.asList("Julio,100", "Joana,200"));

        when(model.getFilePath()).thenReturn(path.toString());

        drawHighScores.drawScores(gui);

        verify(gui, times(1)).drawText(new PositionModel(32, 14), "Joana", new TextColor.RGB(178, 73, 210), false);
        verify(gui, times(1)).drawText(new PositionModel(42, 14), "200", new TextColor.RGB(178, 73, 210), false);
        verify(gui, times(1)).drawText(new PositionModel(32, 16), "Julio", new TextColor.RGB(178, 73, 210), false);
        verify(gui, times(1)).drawText(new PositionModel(42, 16), "100", new TextColor.RGB(178, 73, 210), false);
    }
}