package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;

import java.util.List;
import java.util.Random;

public class PowerUpFactory {

    private List<PowerUpModel> activePowerUps;
    long lastCreation;
    long delay;
    PowerUpFactory(List<PowerUpModel> activePowerUps){
        this.activePowerUps = activePowerUps;
        this.delay = 17500;
        this.lastCreation = 0;

    }


    public void createPowerUp(long Time, int arenaX){
        if(Time - lastCreation > delay){
            PowerUpModel powerUp = new PowerUpModel(createRandomPosition(arenaX),1, createRandomPower());
            activePowerUps.add(powerUp);

            this.lastCreation = Time;
        }
    }

    private PowerUpModel.PowerUpType createRandomPower() {
        Random random = new Random();
        float chance = random.nextFloat();
        if (chance < 1.0/3.0) {
            return PowerUpModel.PowerUpType.HealthBoost;
        } else if (chance < 2.0/3.0) {
            return PowerUpModel.PowerUpType.ScoreBoost;
        } else {
            return PowerUpModel.PowerUpType.FireRateBoost;
        }
    }
    private PositionModel createRandomPosition(int arenaX){
        Random random = new Random();
        int x = random.nextInt(arenaX - 2) + 1;
        return new PositionModel(x, 1);
    }

    public void setDelay(long delayArg) {
        this.delay = delayArg;
    }

    public long getDelay() {
        return delay;
    }

    public long getLastCreation() {
        return lastCreation;
    }
}