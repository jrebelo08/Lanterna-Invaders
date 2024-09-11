package com.Carlos.spaceinvaders.controller.game.MonstersStrategy;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.BulletModel;

import java.util.List;
import java.util.Random;

public class ShooterMovementStrategy extends MovementStrategy {
    private int xDirection = 1;
    private int arenaW;
    private Random random;
    List<BulletModel> bullets;
    List<MonsterModel> activeMonsters;

    public ShooterMovementStrategy(int arenaW, List<BulletModel> bullets, List<MonsterModel> activeMonsters) {
        this.arenaW = arenaW;
        this.random = new Random();
        this.xDirection = random.nextBoolean() ? 1 : -1;
        this.bullets = bullets;
        this.activeMonsters = activeMonsters;
    }


    @Override
    public void move(MonsterModel monster) {
       boolean aux = random.nextBoolean();
       if(aux){
           moveMonster(monster);

       }else{
           shootMonster(monster);
       }
    }

    private void moveMonster(MonsterModel monster){
            PositionModel currentPosition = monster.getPosition();
            int wantedX = currentPosition.getX() + xDirection * monster.getSpeed();
            currentPosition.setX(wantedX);

            if (currentPosition.getX() <= 0 || currentPosition.getX() >= arenaW - 1) {
                xDirection *= -1;
                currentPosition.setX(currentPosition.getX() + xDirection * monster.getSpeed());
            }

            if (canMove(currentPosition.getX(),arenaW)) {
                monster.setPosition(currentPosition);
            }
    }
    public void shootMonster(MonsterModel model) {
        if(activeMonsters.contains(model)) {
            bullets.add(newBullet(model));
        }
    }
    public BulletModel newBullet(MonsterModel monster){
        PositionModel monsterPosition = monster.getPosition();

        return new BulletModel( new PositionModel(monsterPosition.getX(), monsterPosition.getY()),1, false);
    }
}