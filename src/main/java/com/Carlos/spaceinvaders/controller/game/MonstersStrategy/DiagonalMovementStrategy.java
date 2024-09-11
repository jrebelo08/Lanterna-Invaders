package com.Carlos.spaceinvaders.controller.game.MonstersStrategy;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.util.Random;

public class DiagonalMovementStrategy extends MovementStrategy {
    private static final int SWITCH_PROBABILITY = 20;
    private int xDirection;
    private int arenaW;
    public Random random;

    public DiagonalMovementStrategy(int arenaW,Random random) {
        this.arenaW = arenaW;
        this.random = random;
        this.xDirection = random.nextBoolean() ? 1 : -1;
    }

    @Override
    public void move(MonsterModel monster) {
        PositionModel currentPosition = monster.getPosition();
        int wantedX = Math.subtractExact(currentPosition.getX(), Math.multiplyExact(xDirection, monster.getSpeed()));

            if (canMove(wantedX, arenaW)) {
               changePosition(wantedX, monster, currentPosition);
            }else{
                wantedX = Math.addExact(currentPosition.getX(), Math.multiplyExact(xDirection, monster.getSpeed()));
                changePosition(wantedX, monster, currentPosition);
            }
    }
    private void changePosition(int wantedX, MonsterModel monster, PositionModel currentPosition){
         currentPosition.setX(wantedX);
         currentPosition.setY(currentPosition.getY() + monster.getSpeed());

        if (random.nextInt(100) < SWITCH_PROBABILITY) {
            xDirection = Math.multiplyExact(xDirection, -1);
        }
    }


    public int getXDirection() {
        return xDirection;
    }

}