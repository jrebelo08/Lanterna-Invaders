package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.MenuController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.view.menu.DrawMenu;

import java.io.IOException;

public  class MenuState extends State<MenuModel> {

    private  DrawMenu drawMenu;
    private  MenuController menuController;
    public MenuState(MenuModel menuModel){
        super(menuModel);
        this.drawMenu = new DrawMenu(getModel());
        this.menuController = new MenuController(getModel());
    }

    @Override
    public void step(String Key, LanternaGui GUI, long Time,Game game) throws IOException {
        drawMenu.lanternaDraw(GUI);
        menuController.toDo(game,Key, Time);
    }

    public void setDrawMenu(DrawMenu drawMenu) {
        this.drawMenu = drawMenu;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
    public DrawMenu getDrawMenu() {
        return drawMenu;
    }

    public MenuController getMenuController() {
        return menuController;
    }
}
