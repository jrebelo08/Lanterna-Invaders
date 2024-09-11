package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.*;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.*;

import java.util.Objects;

public class MenuController extends Controller<MenuModel> {

    public MenuController(MenuModel menuModel){
        super(menuModel);
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
        if(entry == 1) continueGame(game);
        if(entry == 2) tutorial(game);
        if(entry == 3) highscores(game);
        if(entry == 4) exit();

    }

    @Override
    public void toDo(Game game, String keyPressed, long Time){
        if(Objects.equals(keyPressed, "ArrowDown")) nextEntry();
        if(Objects.equals(keyPressed,"ArrowUp")) previousEntry();
        if(Objects.equals(keyPressed,"Enter")) Select(game);
        if(Objects.equals(keyPressed,"Quit")) playerName(game);
    }

    private void playerName(Game game){
        game.pushState(new PlayerNameState(new PlayerNameModel()));
    }
    private void newGame(Game game) {
        game.pushState(new GameState(new ArenaModel(game.getScreenSize().getX() / 25, game.getScreenSize().getY() / 25)));
    }
    
    private void continueGame(Game game) {
        while (game.getCurrentState() != null && !(game.getCurrentState() instanceof GameState)) {
            game.popState();
        }

        if (game.getCurrentState() instanceof GameState) {
            GameState gameState = (GameState) game.getCurrentState();
            game.popState();
            game.pushState(gameState);
        } else {
            game.pushState(new MenuState(new MenuModel()));
        }
    }

    private void tutorial(Game game){

        game.pushState(new TutorialState(new TutorialModel()));
    }
    private void highscores(Game game){

        game.pushState(new HighScoresState(new HighScoresModel()));
    }

    private void exit(){
        System.exit(0);
    }

}
