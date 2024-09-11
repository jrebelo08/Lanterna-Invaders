package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFactoryController extends Controller<MonsterFactoryModel> {

        private final List<MonsterModel> activeMonsters;
        long lastCreation;

        MonsterFactoryController(MonsterFactoryModel monsterFactoryModel, List<MonsterModel> activeMonsters){
            super(monsterFactoryModel);
            this.activeMonsters = activeMonsters;
            this.lastCreation = 0;
        }


    public List<MonsterModel> createMonster(long Time, int arenaX){
        if(Time - lastCreation > getModel().getDelay()){
            List<MonsterModel> newMonsters = new ArrayList<>();
            for(int i = 0; i < getModel().getNumMonstros(); i++){
                MonsterModel monsterModel = new MonsterModel(createRandomPosition(arenaX), 1);
                activeMonsters.add(monsterModel);
                newMonsters.add(monsterModel);
            }
            this.lastCreation = Time;
            return newMonsters;
        }
        return null;
    }

        private PositionModel createRandomPosition(int arenaX){
            Random random = new Random();
            int x = random.nextInt(arenaX - 2) + 1;
            return new PositionModel(x, 1);
        }

    @Override
    public void toDo(Game game, String keyPressed, long Time) {

    }
}

