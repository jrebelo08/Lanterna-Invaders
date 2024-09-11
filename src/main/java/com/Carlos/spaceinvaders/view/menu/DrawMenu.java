package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.SharedState;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawMenu extends Viewer<MenuModel> {

    private MenuModel menuModel;
    public DrawMenu(MenuModel menuModel) {
        super(menuModel);
        this.menuModel = menuModel;
    }

    @Override
    public void draw(LanternaGui GUI) {
        boolean gameRecordFound = SharedState.foundGameRecord;

        menuModel = getModel();
        String title = menuModel.getText();
        GUI.drawTitle(title);

        int i = 0;
        while (i < 5) {
            String entryName = getModel().getEntryName(i);
            PositionModel position;

            if ("EXIT".equals(entryName)) {
                position = new PositionModel(35, 15 + 4 * i + 1);
            } else if("HIGHSCORES".equals(entryName)){
                position = new PositionModel(33, 15 + 4 * i + 1);
            }else if ("CONTINUE GAME".equals(entryName)) {
                if (!gameRecordFound) {
                    GUI.drawText(new PositionModel(31, 15 + 4 * i + 1), entryName, new TextColor.RGB(128, 128, 128));

                    i++;
                    continue;
                } else {
                    position = new PositionModel(31, 15 + 4 * i + 1);
                }
            } else {
                position = new PositionModel(34, 15 + 4 * i + 1);
            }

            if (getModel().isSelected(i)) {
                GUI.drawTextSelected(position, entryName);
            } else {
                GUI.drawText(position, entryName, new TextColor.RGB(255, 255, 255));
            }

            i++;
        }
    }
}
