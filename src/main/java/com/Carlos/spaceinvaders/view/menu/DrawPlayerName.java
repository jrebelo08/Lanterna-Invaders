
package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PlayerNameModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;


public class DrawPlayerName extends Viewer<PlayerNameModel> {

    public DrawPlayerName(PlayerNameModel playerNameModel) {
        super(playerNameModel);
    }
    @Override
    public void draw(LanternaGui gui) {
        gui.screenClear();
        String text =
                "                          _                     _               \n" +
                        "                         (_)                   | |              \n" +
                        " ___ _ __   __ _  ___ ___ _ _ ____   ____ _  __| | ___ _ __ ___ \n" +
                        "/ __| '_ \\ / _` |/ __/ _ \\ | '_ \\ \\ / / _` |/ _` |/ _ \\ '__/ __|\n" +
                        "\\__ \\.|_) | (_| | (_|  __/ | | | \\ V / (_| | (_| |  __/ |  \\__ \\\n" +
                        "|___/ .__/ \\__,_|\\___\\___|_|_| |_|\\_/ \\__,_|\\__,_|\\___|_|  |___/\n" +
                        "    | |                                                          \n" +
                        "    |_|                                                          \n";

        gui.drawTitle(text);

        gui.drawText(new PositionModel(32, 15), "E", new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(33, 15), "N",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(34, 15), "T",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(35, 15), "E",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(36, 15), "R",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(37, 15), " ",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(38, 15), "N",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(39, 15), "A",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(40, 15), "M",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(41, 15), "E",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(42, 15), ":",  new TextColor.RGB(178, 73 ,210), false);

        gui.drawRectangleName(gui,new TextColor.RGB(178, 73 ,210) );
        gui.drawText(new PositionModel(35, 21), getModel().getEntryName(), new TextColor.RGB(255, 0, 0), false);

    }
}