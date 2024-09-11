package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;
import java.util.List;


public class PowerUpController extends Controller<List<PowerUpModel>> {
    private long lastMove;
    public PowerUpController(List<PowerUpModel> activePowerUp){
            super(activePowerUp);
            this.lastMove = 0;
    }
    void move() {
        for (PowerUpModel powerUp : getModel()) {
            powerUp.move();
        }
    }


    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if(Time - lastMove > 1500 && !getModel().isEmpty()){
            move();
            this.lastMove = Time;
        }
    }

    public long getLastMove() {
        return lastMove;
    }

    public void setLastMove(int move) {
        lastMove = move;
    }
}
