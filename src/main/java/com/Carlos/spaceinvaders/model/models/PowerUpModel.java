package com.Carlos.spaceinvaders.model.models;

public class PowerUpModel extends Elements {

    public enum PowerUpType{
        HealthBoost,
        ScoreBoost,
        FireRateBoost
    }

    private final int speed;
    private int active;
    private PowerUpType powerUpType;
    public PowerUpModel(PositionModel position, int speed, PowerUpType powerUpType){
        super(position);
        this.speed = speed;
        this.active = 0;
        this.powerUpType = powerUpType;
    }

    public PowerUpType getPowerUpType() {
        return powerUpType;
    }
    public int getSpeed(){
        return speed;
    }

    public void incrementActive() {
        this.active = (this.active + 1) % 3;
    }

    public int isActive() {
        return active;
    }
    public void move(){
        getPosition().setY(getPosition().getY() + speed);
    }
    public void setPowerUpType(PowerUpType powerUpType) {
        this.powerUpType = powerUpType;
    }
}