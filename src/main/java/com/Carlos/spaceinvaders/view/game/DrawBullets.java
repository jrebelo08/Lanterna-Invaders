package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;

import java.util.List;

public class DrawBullets extends Viewer<List<BulletModel>> implements DrawElement {

    public DrawBullets(List<BulletModel> bullets){
        super(bullets);
    }

    @Override
    public void draw(LanternaGui GUI){
        for (BulletModel bulletModel : getModel()) {
            DrawBullet drawBullet = new DrawBullet(bulletModel);
            drawBullet.draw(GUI);
        }
    }
}

