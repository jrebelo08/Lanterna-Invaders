package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawBullet extends Viewer<BulletModel> {


    public DrawBullet(BulletModel bulletModel){
       super(bulletModel);
    }

    @Override
    public void draw(LanternaGui GUI){
        BulletModel bulletModel = getModel();
        if(bulletModel.getActive()){
            if(bulletModel.getDirection()){
                GUI.drawText(bulletModel.getPosition(),"|",new TextColor.RGB(0,255,0));
            }else{
                GUI.drawText(bulletModel.getPosition(),"|",new TextColor.RGB(255,0,0));
            }
        }
    }
}
