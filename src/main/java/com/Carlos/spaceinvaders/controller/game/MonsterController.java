package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;


public class MonsterController extends Controller<MonsterModel> {

    private MovementStrategy movementStrategy;
    private int arenaH;
    private long lastMove;
    private boolean winMonster;

    public MonsterController(MonsterModel model,MovementStrategy movementStrategy, int arenaH) {
        super(model);
        this.movementStrategy = movementStrategy;
        this.lastMove = 0;
        this.arenaH = arenaH;
        winMonster = false;
    }
    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if(!winMonster && Time - lastMove > 1000){
            movementStrategy.move(getModel());
            checkWin(getModel());
            this.lastMove = Time;
        }

    }
    public void checkWin(MonsterModel model){
        if(model.getPosition() != null && model.getPosition().getY() >=  arenaH - 1){
            winMonster = true;
        }
    }

    public boolean isWinMonster() {
        return winMonster;
    }

    public long getLastMove() {
        return lastMove;
    }
    public MonsterModel getMonster(){
        return getModel();
    }
}