package com.Carlos.spaceinvaders.gui;

import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LanternaGuiTest {
    private Screen screen;
    private LanternaGui gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() throws IOException, FontFormatException {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGui(screen);
    }

    @Test
    void drawText() {
        gui.drawText(new PositionModel(1, 1), "Hello World", new TextColor.RGB(51, 102, 153));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void getGraphics() {
        TextGraphics graphics = gui.getGraphics();

        assert graphics == tg;
    }
    @Test
    void testDrawTextBold() {
        PositionModel position = new PositionModel(1, 1);
        String string = "Test";
        TextColor.RGB rgbColor = new TextColor.RGB(255, 255, 255);

        gui.drawText(position, string, rgbColor, true);

        verify(tg).enableModifiers(SGR.BOLD);
        verify(tg).putString(position.getX(), position.getY(), string);
    }
    @Test
    void testScreenRefresh() throws IOException {
        gui.screenRefresh();

        verify(screen).refresh();
    }
    @Test
    void testDrawTextWithNullPosition() {
        String string = "Test";
        TextColor.RGB rgbColor = new TextColor.RGB(255, 255, 255);

        assertThrows(NullPointerException.class, () -> {
            gui.drawText(null, string, rgbColor);
        });
    }

    @Test
    void testDrawTextWithNullString() {
        PositionModel position = new PositionModel(1, 1);
        TextColor.RGB rgbColor = new TextColor.RGB(255, 255, 255);

        assertThrows(NullPointerException.class, () -> {
            gui.drawText(position, null, rgbColor);
        });
    }

    @Test
    void testDrawTextWithNullColor() {
        PositionModel position = new PositionModel(1, 1);
        String string = "Test";

        assertThrows(NullPointerException.class, () -> {
            gui.drawText(position, string, null);
        });
    }

    @Test
    void testGetUserInputWithNoInput() throws IOException {
        when(screen.pollInput()).thenReturn(null);

        String input = gui.getUserInput();

        assertNull(input);
    }
}