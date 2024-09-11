package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.TutorialController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.TutorialModel;
import com.Carlos.spaceinvaders.view.menu.DrawTutorial;

import java.io.IOException;

public class TutorialState extends State<TutorialModel>{

    private DrawTutorial drawTutorial;
    private TutorialController tutorialController;

    public TutorialState(TutorialModel tutorialModel) {
        super(tutorialModel);
        this.drawTutorial = new DrawTutorial(getModel());
        this.tutorialController = new TutorialController(getModel());
    }

    @Override
    public void step(String Key, LanternaGui GUI, long Time, Game game) throws IOException {
        drawTutorial.lanternaDraw(GUI);
        tutorialController.toDo(game,Key, Time);
    }

    public void setDrawTutorial(DrawTutorial drawTutorial) {
        this.drawTutorial = drawTutorial;
    }

    public void setTutorialController(TutorialController tutorialController) {
        this.tutorialController = tutorialController;
    }

    public DrawTutorial getDrawTutorial() {
        return drawTutorial;
    }
    public TutorialController getTutorialController() {
        return tutorialController;
    }
}
