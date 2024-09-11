package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.TutorialModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawTutorial extends Viewer<TutorialModel> {

    public DrawTutorial(TutorialModel tutorialModel){
        super(tutorialModel);
    }

    @Override
    protected void draw(LanternaGui gui) {


        gui.drawText(new PositionModel(34, 7-2), "C", new TextColor.RGB(178, 73 ,210));
        gui.drawText(new PositionModel(35, 7-2), "O", new TextColor.RGB(178, 73 ,210));
        gui.drawText(new PositionModel(36, 7-2), "N", new TextColor.RGB(178, 73 ,210));
        gui.drawText(new PositionModel(37, 7-2), "T", new TextColor.RGB(178, 73 ,210));
        gui.drawText(new PositionModel(38, 7-2), "R", new TextColor.RGB(178, 73 ,210));
        gui.drawText(new PositionModel(39, 7-2), "O", new TextColor.RGB(178, 73 ,210));
        gui.drawText(new PositionModel(40, 7-2), "L", new TextColor.RGB(178, 73 ,210));
        gui.drawText(new PositionModel(41, 7-2), "S", new TextColor.RGB(178, 73 ,210));

        gui.drawText(new PositionModel(29, 10-2), "UP/SPACE", new TextColor.RGB(255, 255 ,0));
        gui.drawText(new PositionModel(38, 10-2), "SHOOT", new TextColor.RGB(255, 255 ,255));
        gui.drawText(new PositionModel(29, 12-2), "LEFT", new TextColor.RGB(255, 255 ,0));
        gui.drawText(new PositionModel(38, 12-2), "MOVE LEFT",new TextColor.RGB(255, 255 ,255));
        gui.drawText(new PositionModel(29, 14-2), "RIGHT", new TextColor.RGB(255, 255 ,0));
        gui.drawText(new PositionModel(38, 14-2), "MOVE RIGHT",new TextColor.RGB(255, 255 ,255));

        gui.drawText(new PositionModel(29, 16-2), "Q/ESC", new TextColor.RGB(255, 255 ,0));
        gui.drawText(new PositionModel(38, 16-2), "OPEN IN GAME MENU",new TextColor.RGB(255, 255 ,255));

        gui.drawText(new PositionModel(34, 19-2), "GAME INFO", new TextColor.RGB(178, 73 ,210));

        gui.drawText(new PositionModel(29, 22-2), "]", new TextColor.RGB(255, 0 ,0));
        gui.drawText(new PositionModel(38, 22-2), "KILL THE MONSTERS",new TextColor.RGB(255, 255 ,255));

        gui.drawText(new PositionModel(29, 24-2), "+", new TextColor.RGB(0, 255 ,0));
        gui.drawText(new PositionModel(31, 24-2), "★", new TextColor.RGB(255, 255 ,0));
        gui.drawText(new PositionModel(33, 24-2), "$", new TextColor.RGB(0, 0 ,255));
        gui.drawText(new PositionModel(38, 24-2), "SHOOT THE POWERUPS TO GAIN POWERS",new TextColor.RGB(255, 255 ,255));
        gui.drawText(new PositionModel(29, 24), "♥",new TextColor.RGB(255, 0 ,0));
        gui.drawText(new PositionModel(38, 24), "YOU HAVE ONLY 3 LIVES",new TextColor.RGB(255, 255 ,255));


        gui.drawText(new PositionModel(35, 27), "POWERUPS", new TextColor.RGB(178, 73 ,210));

        gui.drawText(new PositionModel(29, 30), "+", new TextColor.RGB(0, 255 ,0));
        gui.drawText(new PositionModel(38, 30), "EXTRA LIFE",new TextColor.RGB(255, 255 ,255));
        gui.drawText(new PositionModel(29, 32), "★", new TextColor.RGB(255, 255 ,0));
        gui.drawText(new PositionModel(38, 32), "5X SCORE BOOST",new TextColor.RGB(255, 255 ,255));
        gui.drawText(new PositionModel(29, 34), "$", new TextColor.RGB(0, 0 ,255));
        gui.drawText(new PositionModel(38, 34), "FIRE RATE BOOST",new TextColor.RGB(255, 255 ,255));



        gui.drawText(new PositionModel(36, 38),getModel().getEntryName(),new TextColor.RGB(255, 0 ,0));

    }
}