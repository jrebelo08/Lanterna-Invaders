package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.PlayerNameModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.Objects;

public class PlayerNameController extends Controller<PlayerNameModel> {
    public PlayerNameController(PlayerNameModel playerNameModel) {
        super(playerNameModel);
    }

    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if (Objects.equals(keyPressed, "Enter")) {
            game.pushState(new MenuState(new MenuModel()));
        } else if (keyPressed != null && (keyPressed.equals("Escape") || keyPressed.equals("Quit"))) {
            System.exit(0);
        }else if(Objects.equals(keyPressed, "BackSpace")){
            String currentName = getModel().getName();
            if (!currentName.isEmpty()) {
                getModel().setName(currentName.substring(0, currentName.length() - 1));
            }
        }else if (keyPressed != null && keyPressed.length() == 1&&  getModel().getName().length() < 15) {
            getModel().setName(getModel().getName() + keyPressed);
        }

        game.getGUI().drawText(new PositionModel(30, 18), getModel().getName(), new TextColor.RGB(255, 255, 255));

        try {
            game.getGUI().screenRefresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
