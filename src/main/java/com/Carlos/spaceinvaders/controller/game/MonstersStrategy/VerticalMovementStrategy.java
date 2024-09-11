package com.Carlos.spaceinvaders.controller.game.MonstersStrategy;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

public class VerticalMovementStrategy extends MovementStrategy {
    @Override
    public void move(MonsterModel monster) {
        PositionModel currentPosition = monster.getPosition();
        currentPosition.setY(currentPosition.getY() + monster.getSpeed());
        monster.setPosition(currentPosition);
    }
}
