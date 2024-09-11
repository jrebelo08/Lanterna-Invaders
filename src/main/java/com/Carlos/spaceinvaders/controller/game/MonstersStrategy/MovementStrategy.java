package com.Carlos.spaceinvaders.controller.game.MonstersStrategy;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

public abstract class MovementStrategy {

    protected boolean canMove(int wantedX, int arenaW){
        return wantedX < arenaW - 1 && wantedX > 0;
    }

    public abstract void move(MonsterModel monsterModel);
}
