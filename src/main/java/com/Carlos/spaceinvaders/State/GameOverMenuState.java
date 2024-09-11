package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.GameOverMenuController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import com.Carlos.spaceinvaders.view.menu.DrawGameOverMenu;

import java.io.IOException;

public class GameOverMenuState extends State<GameOverMenuModel>{

    private DrawGameOverMenu drawGameOverMenu;
    private GameOverMenuController gameOverMenuController;
    public GameOverMenuState(GameOverMenuModel GameOverMenuModel){
        super(GameOverMenuModel);
        this.drawGameOverMenu = new DrawGameOverMenu(getModel());
        this.gameOverMenuController = new GameOverMenuController(getModel());
    }

    @Override
    public void step(String Key, LanternaGui GUI, long Time, Game game) throws IOException {
        drawGameOverMenu.lanternaDraw(GUI);
        gameOverMenuController.toDo(game,Key, Time);
    }

    public void setDrawGameOverMenu(DrawGameOverMenu drawGameOverMenu) {
        this.drawGameOverMenu = drawGameOverMenu;
    }

    public void setGameOverMenuController(GameOverMenuController gameOverMenuController) {
        this.gameOverMenuController = gameOverMenuController;
    }

    public DrawGameOverMenu getDrawGameOverMenu() {
        return drawGameOverMenu;
    }

    public GameOverMenuController getGameOverMenuController() {
        return gameOverMenuController;
    }
}
