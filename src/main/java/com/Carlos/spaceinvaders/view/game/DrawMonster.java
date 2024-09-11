package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;


import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawMonster extends Viewer<MonsterModel> implements DrawElement {

    public DrawMonster(MonsterModel monsterModel){
        super(monsterModel);
    }
    @Override
    public void draw(LanternaGui GUI){
        MonsterModel monsterModel = getModel();
        if(monsterModel.getMoveType() == MonsterModel.MoveType.Vertical) GUI.drawText(monsterModel.getPosition(),"]",new TextColor.RGB(255, 0, 0));
        if(monsterModel.getMoveType() == MonsterModel.MoveType.Shooter) GUI.drawText(monsterModel.getPosition(),"[",new TextColor.RGB(0, 100, 0));
        if(monsterModel.getMoveType() == MonsterModel.MoveType.Diagonal) GUI.drawText(monsterModel.getPosition(),"]",new TextColor.RGB (255, 0, 0));

    }
}
