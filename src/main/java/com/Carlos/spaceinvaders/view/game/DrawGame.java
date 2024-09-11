package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;

public class DrawGame extends Viewer<ArenaModel> {

    public DrawGame(ArenaModel arenaModel) {
        super(arenaModel);
    }

    @Override
    public void draw(LanternaGui GUI) {
        drawElement(new DrawPlayer(getModel().getPlayer()), GUI);
        drawElement(new DrawMonsters(getModel().getActiveMonsters()), GUI);
        drawElement(new DrawBullets(getModel().getActiveBullets()), GUI);
        drawElement(new DrawOutline(getModel().getWalls()), GUI);
        drawElement(new DrawScore(getModel().getScore()),GUI);
        drawElement(new DrawPowerUps(getModel().getActivePowerUps()), GUI);
    }

    private void drawElement(DrawElement element, LanternaGui GUI) {
        element.draw(GUI);
    }
}