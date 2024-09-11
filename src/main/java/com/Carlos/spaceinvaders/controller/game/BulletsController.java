package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.*;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;


import java.util.Iterator;
import java.util.List;

public class BulletsController extends Controller<List<BulletModel>> {

    private List<MonsterModel> activeMonsters;
    private List<PowerUpModel> activePowerUps;
    private PlayerModel playerModel;
    private ScoreModel scoreModel;
    private long lastScoreBoostTime;
    private long lastFireRateBoostTime;
    private long upTime;
    private int arenaH;
    public BulletsController(List<BulletModel> bullets, List<MonsterModel> activeMonsters, List<PowerUpModel> activePowerUps, PlayerModel playerModel, ScoreModel scoreModel, int arenaH){
        super(bullets);
        this.activeMonsters = activeMonsters;
        this.activePowerUps = activePowerUps;
        this.playerModel = playerModel;
        this.scoreModel = scoreModel;
        this.lastScoreBoostTime = 0;
        this.lastFireRateBoostTime = 0;
        this.upTime = 10000;
        this.arenaH = arenaH;
    }
    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        Iterator<BulletModel> iterator = getModel().iterator();
        while (iterator.hasNext()) {
            BulletModel bullet = iterator.next();
            move(bullet,Time);
            bullet.processActive(arenaH);
            if (!bullet.getActive()){
                iterator.remove();
            }
        }

        if(lastScoreBoostTime != 0 && Time - lastScoreBoostTime > upTime){
            revertScoreBoost();
        }
        if(lastFireRateBoostTime != 0 && Time - lastFireRateBoostTime > upTime){
            revertFireRateBoost();
        }

    }

    public void move(BulletModel bullet,long Time) {
        PositionModel newPosition = calculateNewPosition(bullet);

        boolean colidiu = colide(newPosition, Time, bullet.getDirection());

        if(colidiu) {
            bullet.setActive(false);

        }else{
            bullet.getPosition().setY(newPosition.getY());
        }
    }
    PositionModel calculateNewPosition(BulletModel bullet) {
        int newY = bullet.getDirection() ? bullet.getPosition().getY() - bullet.getSpeed() : bullet.getPosition().getY() + bullet.getSpeed();
        return new PositionModel(bullet.getPosition().getX(), newY);
    }

    boolean colide(PositionModel nextPosition, long Time, boolean direction){
        MonsterModel monster = isMonster(nextPosition);
        PowerUpModel powerUp = isPowerUp(nextPosition);
        boolean playerhit = isPlayer(nextPosition);
        if(monster != null && direction){
            activeMonsters.remove(monster);
            this.scoreModel.incrementScore();
            return true;
        }
        if(powerUp != null && direction){
            processPowerUp(powerUp,Time);
            activePowerUps.remove(powerUp);
        }
        return playerhit;
    }
    MonsterModel isMonster(PositionModel nextPosition){
        for(MonsterModel monster : activeMonsters){
            if(monster.getPosition().equals(nextPosition)){
                return monster;
            }
        }
        return null;
    }
    boolean isPlayer(PositionModel nextPosition){
        if(playerModel.getPosition().equals(nextPosition) || playerModel.getPosition().getLeftBound().equals(nextPosition) || playerModel.getPosition().getRightBound().equals(nextPosition)){
            playerModel.decrementHitPoints();
            return true;
        }
        return false;
    }
    PowerUpModel isPowerUp(PositionModel newPosition) {
        for (PowerUpModel powerUp : activePowerUps) {
            if (newPosition.equals(powerUp.getPosition())) {
                return powerUp;
            }
        }
        return null;
    }
    void processPowerUp(PowerUpModel powerUp, long Time){
        if(powerUp.getPowerUpType() == PowerUpModel.PowerUpType.HealthBoost) HealthBoost();
        if(powerUp.getPowerUpType() == PowerUpModel.PowerUpType.ScoreBoost){
            ScoreBoost();
            lastScoreBoostTime = Time;
        }
        if(powerUp.getPowerUpType() == PowerUpModel.PowerUpType.FireRateBoost){
            FireRateBoost();
            lastFireRateBoostTime = Time;

        }
        powerUp.incrementActive();
    }
    void ScoreBoost(){
        scoreModel.setIncrementValue(5);
        playerModel.setPowerUpType(PowerUpModel.PowerUpType.ScoreBoost);
    }
    private void revertScoreBoost(){
        scoreModel.setIncrementValue(1);
        if(!checkActivity())
            playerModel.setPowerUpType(null);
        lastScoreBoostTime = 0;
    }
    void HealthBoost(){
        playerModel.incrementHitPoints();

    }
    private void FireRateBoost(){
        playerModel.setDelayShooting(250);
        playerModel.setPowerUpType(PowerUpModel.PowerUpType.FireRateBoost);
    }
    private void revertFireRateBoost(){
        playerModel.setDelayShooting(500);
        if(!checkActivity())
             playerModel.setPowerUpType(null);
        lastFireRateBoostTime = 0;
    }
    private boolean checkActivity(){
        for(PowerUpModel powerup : activePowerUps){
            if(powerup.isActive() == 1){
                return true;
            }
        }
        return false;
    }
}