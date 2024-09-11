package com.Carlos.spaceinvaders.view.game;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;




public class DrawPlayer extends Viewer<PlayerModel> implements DrawElement {
    public DrawPlayer(PlayerModel player){
        super(player);
    }

    @Override
    public void draw(LanternaGui GUI) {
        PlayerModel playerModel = getModel();
        PositionModel position = playerModel.getPosition();
        drawSpaceship(GUI, position);
    }

    private void drawSpaceship(LanternaGui gui, PositionModel position) {
        int x = position.getX();
        int y = position.getY();
        TextColor.RGB color;
        if(getModel().getPowerUpType() == PowerUpModel.PowerUpType.ScoreBoost)
        color = new TextColor.RGB(255,255,0);
        else if(getModel().getPowerUpType() == PowerUpModel.PowerUpType.FireRateBoost)
            color = new TextColor.RGB(0,255,255);
        else
            color = new TextColor.RGB(0,255,0);

        gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString("#010327"));
        gui.drawText(new PositionModel(x, y - 2), "|", color, false);
        gui.drawText(new PositionModel(x - 2, y - 1), " /",  color, false);
        gui.drawText(new PositionModel(x, y - 1), " ", color, false);
        gui.drawText(new PositionModel(x + 1, y - 1), "\\ ", color, false);
        gui.drawText(new PositionModel(x - 2, y), "<",color, false);
        gui.drawText(new PositionModel(x - 1, y), "   ", color, false);
        gui.drawText(new PositionModel(x + 2, y), ">", color, false);
        gui.drawText(new PositionModel(x - 1, y), "___", color, false);

        int i = getModel().getHitPoints();
        while (i != 0){
            gui.drawText(new PositionModel(48+25 , 41 - i), "♥", new TextColor.RGB(255, 0 ,0), false);
            i--;
        }
    }
}

