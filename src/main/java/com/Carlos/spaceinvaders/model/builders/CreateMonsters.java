package com.Carlos.spaceinvaders.model.builders;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.util.List;
import java.util.Random;

public class CreateMonsters {

    private int width;
    private List<MonsterModel> monsters;

    public CreateMonsters(int width, List<MonsterModel> activeMonsters){
        this.monsters = activeMonsters;
        this.width = width;
    }
    private boolean isPositionOccupied(PositionModel position) {
        for (MonsterModel monster : monsters) {
            if (monster.getPosition().equals(position)) {
                return true;
            }
        }
    return false;
    }   
    private PositionModel getRandomPosM(int y){
        Random random = new Random();
        PositionModel position;
        do {
            int randomNumber = random.nextInt(width - 1) + 1;
            position = new PositionModel(randomNumber, y);
        } while (isPositionOccupied(position));
        return position;
    }
    public List<MonsterModel> addMonsters(int numMonstros){
        for(int i = 0; i < numMonstros; i++){
            monsters.add(new MonsterModel(getRandomPosM(1), 1));
        }
        return monsters;
    }

}
