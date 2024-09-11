package com.Carlos.spaceinvaders.model.models;

public class MonsterModel extends Elements {

    boolean direction = false;
    private final int speed;
    private MoveType moveType;
    public enum MoveType{
        Diagonal,
        Vertical,
        Shooter
    }
    public MonsterModel(PositionModel position, int speed) {
        super(position);
        this.speed = speed;
        this.moveType = null;
    }

    public void move() {
        if (direction)
            position.setY(position.getY() - speed);
        else
            position.setY(position.getY() + speed);
    }

    public int getSpeed(){
        return this.speed;
    }
    public void setDirection(boolean b) {
        this.direction = b;
    }

    public boolean getDirection() {
        return direction;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }
}