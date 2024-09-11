package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.ResumeMenuController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;
import com.Carlos.spaceinvaders.view.menu.DrawResumeMenu;

import java.io.IOException;

public class ResumeMenuState extends State<ResumeMenuModel> {

    private DrawResumeMenu drawResumeMenu;
    private ResumeMenuController resumeMenuController;
    public ResumeMenuState(ResumeMenuModel ResumeMenuModel){
        super(ResumeMenuModel);
        this.drawResumeMenu = new DrawResumeMenu(getModel());
        this.resumeMenuController = new ResumeMenuController(getModel());
    }

    @Override
    public void step(String Key, LanternaGui GUI, long Time, Game game) throws IOException {
        drawResumeMenu.lanternaDraw(GUI);
        resumeMenuController.toDo(game,Key, Time);
    }

    public void setDrawResumeMenu(DrawResumeMenu drawResumeMenu) {
        this.drawResumeMenu = drawResumeMenu;
    }

    public void setResumeMenuController(ResumeMenuController resumeController) {
        this.resumeMenuController = resumeController;
    }
    public DrawResumeMenu getDrawResumeMenu() {
        return drawResumeMenu;
    }
    public ResumeMenuController getResumeMenuController() {
        return resumeMenuController;
    }
}
