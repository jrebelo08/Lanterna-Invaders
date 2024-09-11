package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.GameState;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;

import java.util.Objects;

public class ResumeMenuController extends Controller<ResumeMenuModel> {

    public ResumeMenuController(ResumeMenuModel ResumeModel){
        super(ResumeModel);
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

        if(entry == 0) resume(game);
        if(entry == 1) restart(game);
        if(entry == 2) save_load(game);
        if(entry == 3) exit(game);

    }

    @Override
    public void toDo(Game game, String keyPressed, long Time){
        if(Objects.equals(keyPressed, "ArrowDown")) nextEntry();
        if(Objects.equals(keyPressed,"ArrowUp")) previousEntry();
        if(Objects.equals(keyPressed,"Enter")) Select(game);
        if(Objects.equals(keyPressed,"Quit")) System.exit(0);
    }

    private void resume(Game game) {
        if (!game.states.isEmpty()) {
            game.popState();
        }
        }

    private void restart(Game game){
        game.pushState(new GameState(new ArenaModel(game.getScreenSize().getX() / 25, game.getScreenSize().getY() / 25)));
    }
    private void save_load(Game game){
        game.pushState(game.getCurrentState());
        game.foundGameRecord();
        exit(game);
    }
    private void exit(Game game){
        game.pushState(new MenuState(new MenuModel()));
    }

}
