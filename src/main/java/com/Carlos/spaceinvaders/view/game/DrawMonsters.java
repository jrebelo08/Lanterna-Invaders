package com.Carlos.spaceinvaders.view.game;


import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;

import java.util.List;

public class DrawMonsters extends Viewer<List<MonsterModel>> implements DrawElement{
    public DrawMonsters(List<MonsterModel> monsters){
        super(monsters);
    }

    @Override
    public void draw(LanternaGui GUI){
        for (MonsterModel monsterModel : getModel()) {
            DrawMonster drawMonster = new DrawMonster(monsterModel);
            drawMonster.draw(GUI);
        }
    }
}
