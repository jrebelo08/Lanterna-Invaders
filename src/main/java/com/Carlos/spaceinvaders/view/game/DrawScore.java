package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.model.models.ScoreModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawScore  extends Viewer<ScoreModel> implements DrawElement {
    public DrawScore(ScoreModel scoreModel){
        super(scoreModel);
    }


    @Override
    public void draw(LanternaGui GUI){
        ScoreModel scoreModel = getModel();
        int score = scoreModel.getScore();
        GUI.drawText(scoreModel.getPosition(),Integer.toString(score),new TextColor.RGB(255,255,255));
    }
}
