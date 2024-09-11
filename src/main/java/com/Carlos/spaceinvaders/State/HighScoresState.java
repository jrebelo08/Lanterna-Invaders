package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.HighScoresController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;
import com.Carlos.spaceinvaders.view.menu.DrawHighScores;

import java.io.IOException;

public class HighScoresState extends State<HighScoresModel>{

    private DrawHighScores drawHighScores;
    private HighScoresController highScoresController;

    public HighScoresState(HighScoresModel highScoresModel) {
        super(highScoresModel);
        this.drawHighScores = new DrawHighScores(getModel());
        this.highScoresController = new HighScoresController(getModel());
    }

    @Override
    public void step(String Key, LanternaGui GUI, long Time,Game game) throws IOException {
        drawHighScores.lanternaDraw(GUI);
        highScoresController.toDo(game,Key, Time);
    }

    public void setDrawHighScores(DrawHighScores drawHighScores) {
        this.drawHighScores = drawHighScores;
    }

    public void setHighScoresController(HighScoresController highScoresController) {
        this.highScoresController = highScoresController;
    }
    public DrawHighScores getDrawHighScores() {
        return drawHighScores;
    }

    public HighScoresController getHighScoresController() {
        return highScoresController;
    }
}
