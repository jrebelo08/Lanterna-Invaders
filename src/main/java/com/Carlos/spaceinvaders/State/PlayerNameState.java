package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.PlayerNameController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PlayerNameModel;
import com.Carlos.spaceinvaders.view.menu.DrawPlayerName;

import java.io.IOException;

public class PlayerNameState extends State<PlayerNameModel> {

    private DrawPlayerName drawPlayerNameModel;
    private PlayerNameController playerNameController;

    public PlayerNameState(PlayerNameModel playerNameModel) {
        super(playerNameModel);

        this.drawPlayerNameModel = new DrawPlayerName(playerNameModel);
        this.playerNameController = new PlayerNameController(playerNameModel);
    }

    @Override
    public void step(String key, LanternaGui gui, long time, Game game) throws IOException {

        drawPlayerNameModel.draw(gui);
        playerNameController.toDo(game, key, time);
    }

    public void setDrawPlayerNameModel(DrawPlayerName drawPlayerNameModel) {
        this.drawPlayerNameModel = drawPlayerNameModel;
    }

    public void setPlayerNameController(PlayerNameController playerNameController) {
        this.playerNameController = playerNameController;
    }
    public DrawPlayerName getDrawPlayerNameModel() {
        return drawPlayerNameModel;
    }
    public PlayerNameController getPlayerNameController() {
        return playerNameController;
    }
}