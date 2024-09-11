package com.Carlos.spaceinvaders.gui;

import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.google.common.base.Ascii;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;


public class LanternaGui {

    private final TextGraphics graphics;
    Screen screen;
    private int width;

    public LanternaGui(int width, int height) throws IOException, FontFormatException {
        Terminal terminal = createTerminal(width, height);
        this.width = width;
        screen = createScreen(terminal);
        assert screen != null;
        graphics = createGraphics(screen);
    }

    public LanternaGui(Screen screen) {
        this.screen = screen;
        this.graphics = screen.newTextGraphics();
    }

    Terminal createTerminal(int width, int height) throws IOException, FontFormatException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();

        AWTTerminalFontConfiguration fontConfig = fontLoader();
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        terminalFactory.setForceAWTOverSwing(true);

        terminalFactory.setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        AWTTerminalFrame terminalFrame = (AWTTerminalFrame) terminal;
        terminalFrame.setTitle("Space Invaders");
        windowClosing(terminalFrame);
        return terminal;
    }

    private void windowClosing(AWTTerminalFrame terminal) {
        terminal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent close) {
                close.getWindow().dispose();
                System.exit(0);
            }
        });
    }

    private AWTTerminalFontConfiguration fontLoader() throws FontFormatException, IOException {
        InputStream fontStream = getClass().getClassLoader().getResourceAsStream("fonts/game.ttf");
        assert fontStream != null;
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    private Screen createScreen(Terminal terminal) {
        try {
            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            return screen;
        } catch (IOException e) {
            System.err.println("Error creating screen: " + e.getMessage());
            return null;
        }
    }
    public String getUserInput() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        String ch = "";
        if (keyStroke == null) return null;
        if (keyStroke.getKeyType() == KeyType.EOF) return "Quit";
        if (keyStroke.getKeyType() == KeyType.Escape) return "Escape";
        if (keyStroke.getKeyType() == KeyType.Character) {
            char character = keyStroke.getCharacter();
            if (character == 'q' || character == 'Q') return "Quit";
        }
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return "ArrowUp";
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return "ArrowRight";
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return "ArrowDown";
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return "ArrowLeft";
        if (keyStroke.getKeyType() == KeyType.Enter) return "Enter";
        if (keyStroke.getKeyType() == KeyType.Backspace) return "BackSpace";
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return "Space";
        if (keyStroke.getKeyType() != KeyType.Character) {
            return null;
        }
        return ch + Ascii.toUpperCase(Character.toString(keyStroke.getCharacter()));

    }
    private TextGraphics createGraphics(Screen screen) {
        return screen.newTextGraphics();
    }


    public void drawText(PositionModel position, String string, TextColor.RGB rgbColor) {
        drawText(position, string, rgbColor, false);
    }

    public void drawText(PositionModel position, String string, TextColor.RGB rgbColor, boolean bold) {
        if (string == null) {
            throw new NullPointerException("String cannot be null");
        }
        if (rgbColor == null) {
            throw new NullPointerException("Color cannot be null");
        }
        if (bold)
            graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(rgbColor);
        graphics.putString(position.getX(), position.getY(), string);
    }

    public void drawRectangleName(LanternaGui gui, TextColor.RGB rgbColor){
        for (int col = 30; col <= 44; col++) {
            gui.drawText(new PositionModel(col, 17), "-", rgbColor, false);
        }

        for (int row = 18; row == 18; row++) {
            gui.drawText(new PositionModel(29, row), "|", rgbColor, false);
            gui.drawText(new PositionModel(45, row), "|", rgbColor, false);
        }

        for (int col = 30; col <= 44; col++) {
            gui.drawText(new PositionModel(col, 19), "-", rgbColor, false);
        }
    }

    public void screenClear() {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#010327"));
        graphics.fillRectangle(new TerminalPosition(0, 0), screen.getTerminalSize(), ' ');
    }

    public void screenRefresh() throws IOException {
        screen.refresh();
    }


    public void drawTitle(String string) {
        int startPoint;
        if(string.length() == 522){
            startPoint = (width - 64) / 2;

            String[] lines = string.split("\n");
            int y = 2;
            for (String line : lines) {
                drawText(new PositionModel(startPoint, y), line, new TextColor.RGB(178, 73, 210),Boolean.TRUE);
                y++;
            }


        }else if(string.length() == 279){
            startPoint = (width - 56) / 2;

            String[] lines = string.split("\n");
            int y = 5;
            for (String line : lines) {
                drawText(new PositionModel(startPoint, y), line, new TextColor.RGB(178, 73, 210),Boolean.TRUE);
                y++;
            }
        }
        else{
            startPoint = (width - 39) / 2;

            String[] lines = string.split("\n");
            int y = 5;
            for (String line : lines) {
                drawText(new PositionModel(startPoint, y), line, new TextColor.RGB(178, 73, 210),Boolean.TRUE);
                y++;
            }
        }

    }
    public void drawTextSelected(PositionModel position, String entryName) {
        int width = entryName.length() + 2;
        int height = 3;

        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.putString(position.getX()-1, position.getY()-1, "+");
        for (int i = 1; i < width - 1; i++) {
            graphics.putString(position.getX() - 1 + i, position.getY() - 1, "-");
        }
        graphics.putString(position.getX() - 1 + width - 1, position.getY() - 1, "+");

        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.putString(position.getX() - 1, position.getY() - 1 + 1, "|");
        graphics.setForegroundColor(new TextColor.RGB(0, 255 ,0));
        graphics.putString(position.getX() - 1 + 1, position.getY() - 1 + 1, entryName);
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.putString(position.getX() - 1 + width - 1, position.getY() - 1 + 1, "|");

        graphics.putString(position.getX() - 1, position.getY() - 1 + height - 1, "+");
        for (int i = 1; i < width - 1; i++) {
            graphics.putString(position.getX() - 1 + i, position.getY() - 1 + height - 1, "-");
        }
        graphics.putString(position.getX() - 1 + width - 1, position.getY() - 1 + height - 1, "+");
    }
    public TextGraphics getGraphics() {
        return graphics;
    }
}