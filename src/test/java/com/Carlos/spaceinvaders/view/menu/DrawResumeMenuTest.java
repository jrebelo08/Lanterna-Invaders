package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class DrawResumeMenuTest {

    private DrawResumeMenu drawResumeMenu;
    private ResumeMenuModel resumeMenuModel;
    private LanternaGui GUI;

    @BeforeEach
    public void setUp() {
        resumeMenuModel = Mockito.mock(ResumeMenuModel.class);
        GUI = Mockito.mock(LanternaGui.class);
        drawResumeMenu = new DrawResumeMenu(resumeMenuModel);
    }

    @Test
    public void testDraw() {
        when(resumeMenuModel.getText()).thenReturn("Resume Menu");
        when(resumeMenuModel.getEntryName(0)).thenReturn("GO TO MAIN MENU");
        when(resumeMenuModel.getEntryName(1)).thenReturn("SAVE PROGRESS");
        when(resumeMenuModel.getEntryName(2)).thenReturn("ENTRY 2");
        when(resumeMenuModel.getEntryName(3)).thenReturn("ENTRY 3");
        when(resumeMenuModel.isSelected(0)).thenReturn(true);
        when(resumeMenuModel.isSelected(1)).thenReturn(false);
        when(resumeMenuModel.isSelected(2)).thenReturn(false);
        when(resumeMenuModel.isSelected(3)).thenReturn(true);

        drawResumeMenu.draw(GUI);

        verify(GUI).drawTitle("Resume Menu");
        verify(GUI).drawTextSelected(new PositionModel(30, 18), "GO TO MAIN MENU");
        verify(GUI).drawText(new PositionModel(31, 22), "SAVE PROGRESS", new TextColor.RGB(255, 255, 255));
        verify(GUI).drawText(new PositionModel(34, 26), "ENTRY 2", new TextColor.RGB(255, 255, 255));
        verify(GUI).drawTextSelected(new PositionModel(34, 30), "ENTRY 3");
        verifyNoMoreInteractions(GUI);
    }
}