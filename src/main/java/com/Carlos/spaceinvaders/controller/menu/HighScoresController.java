package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;

import java.util.Objects;

public class HighScoresController extends Controller<HighScoresModel> {
    public HighScoresController(HighScoresModel highScore) {
        super(highScore);
    }

    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if (Objects.equals(keyPressed, "Enter")) game.pushState(new MenuState(new MenuModel()));
        if (keyPressed != null && (keyPressed.equals("Escape") || keyPressed.equals("Quit")) ) {
            game.popState();
        }
    }
}