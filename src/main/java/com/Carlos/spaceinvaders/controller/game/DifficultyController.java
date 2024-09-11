package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;

public class DifficultyController extends Controller<MonsterFactoryModel> {

    private ScoreModel scoreModel;
    private boolean canChange;
    DifficultyController(MonsterFactoryModel monsterFactoryModel, ScoreModel scoreModel){
        super(monsterFactoryModel);
        this.scoreModel = scoreModel;
        this.canChange = true;
    }

    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        int score = scoreModel.getScore();
        if ((score % 100 == 0 && score != 0) && canChange) {
            super.getModel().setNumMonstros(super.getModel().getNumMonstros() + 1);
            canChange = false;
        }
        if ((score % 16 == 0 && score != 0) && canChange) {
            int retira = 75 / (1 + score / 1000);
            getModel().setDelay(Math.max(0, getModel().getDelay()) - retira);
            canChange = false;
        }
        if(!(score % 16 == 0 || score % 100 == 0)) canChange = true;
    }
}
