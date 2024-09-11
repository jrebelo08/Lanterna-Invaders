package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.game.GameController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.view.game.DrawGame;

import java.io.IOException;

public class GameState extends State<ArenaModel> {

    private DrawGame drawGame;
    private GameController gameController;


    public GameState(ArenaModel arenaModel){
        super(arenaModel);
        this.drawGame = new DrawGame(getModel());
        this.gameController = new GameController(getModel());
    }


    @Override
    public void step(String Key, LanternaGui GUI, long Time,Game game) throws IOException {
        drawGame.lanternaDraw(GUI);
        gameController.toDo(game,Key,Time);
    }

    public void setDrawGame(DrawGame drawGame) {
        this.drawGame = drawGame;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public DrawGame getDrawGame() {
        return drawGame;
    }

    public GameController getGameController() {
        return gameController;
    }
}