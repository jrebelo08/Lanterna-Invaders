package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class DrawHighScores extends Viewer<HighScoresModel> {

    public DrawHighScores(HighScoresModel highScores) {
        super(highScores);
    }

    @Override
    protected void draw(LanternaGui gui) {
        drawTitle(gui);
        drawScores(gui);
    }

    void drawTitle(LanternaGui gui) {
        gui.drawText(new PositionModel(33, 7), "HIGH SCORES", new TextColor.RGB(178, 73, 210), false);
        gui.drawText(new PositionModel(32, 11), "NAME", new TextColor.RGB(178, 73, 210), false);
        gui.drawText(new PositionModel(42, 11), "SCORE", new TextColor.RGB(178, 73, 210), false);
    }

    void drawScores(LanternaGui gui) {
        String filePath = getModel().getFilePath();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            lines.sort(Comparator.comparingInt(line -> Integer.parseInt(((String) line).split(",")[1])).reversed());

            int row = 14;
            for (String line : lines) {
                String[] parts = line.split(",");
                String name = parts[0];
                String score = parts[1];
                if (row == 14) {
                    gui.drawText(new PositionModel(32, row), name, getModel().getColor(0), false);
                    gui.drawText(new PositionModel(42, row), score, getModel().getColor(0), false);
                } else {
                    if (row == 16) {
                        gui.drawText(new PositionModel(32, row), name, getModel().getColor(1), false);
                        gui.drawText(new PositionModel(42, row), score, getModel().getColor(1), false);
                    } else {
                        if (row == 18) {
                            gui.drawText(new PositionModel(32, row), name, getModel().getColor(2), false);
                            gui.drawText(new PositionModel(42, row), score, getModel().getColor(2), false);
                        } else {
                            gui.drawText(new PositionModel(32, row), name, getModel().getColor(3), false);
                            gui.drawText(new PositionModel(42, row), score, getModel().getColor(3), false);
                        }
                    }
                }
                row += 2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        gui.drawText(new PositionModel(35, 35), getModel().getEntryName(), new TextColor.RGB(255, 0, 0), false);

    }
}
