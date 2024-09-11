package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.GameState;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;

import java.util.Objects;

public class GameOverMenuController extends Controller<GameOverMenuModel> {

    public GameOverMenuController(GameOverMenuModel GameOverModel){
        super(GameOverModel);
    }

    void nextEntry(){
        int entry = getModel().getEntry();
        int lenEntries = getModel().getEntriesSize();

        getModel().setEntry((entry + 1) % lenEntries);
    }
    void previousEntry() {

        if (getModel().getEntry() == 0) {

            getModel().setEntry(getModel().getEntriesSize() - 1);
        } else {
            getModel().setEntry(getModel().getEntry() - 1);
        }
    }

    void Select(Game game){
        int entry = getModel().getEntry();

        if(entry == 0) newGame(game);
        if(entry == 1) exit(game);

    }

    @Override
    public void toDo(Game game, String keyPressed, long Time){
        if(Objects.equals(keyPressed, "ArrowDown")) nextEntry();
        if(Objects.equals(keyPressed,"ArrowUp")) previousEntry();
        if(Objects.equals(keyPressed,"Enter")) Select(game);
        if(Objects.equals(keyPressed,"Quit")) System.exit(0);
    }

    void newGame(Game game) {
        game.pushState(new GameState(new ArenaModel(game.getScreenSize().getX() / 25, game.getScreenSize().getY() / 25)));
    }


    void exit(Game game){
        game.pushState(new MenuState(new MenuModel()));
    }
}
