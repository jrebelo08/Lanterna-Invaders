package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.PlayerNameController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PlayerNameModel;
import com.Carlos.spaceinvaders.view.menu.DrawPlayerName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerNameStateTest {
    @Mock
    private PlayerNameModel playerNameModel;
    @Mock
    private DrawPlayerName drawPlayerNameModel;
    @Mock
    private PlayerNameController playerNameController;
    @Mock
    private LanternaGui gui;
    @Mock
    private Game game;

    private PlayerNameState playerNameState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playerNameState = new PlayerNameState(playerNameModel);
        playerNameState.setDrawPlayerNameModel(drawPlayerNameModel);
        playerNameState.setPlayerNameController(playerNameController);
    }

    @Test
    void testStep() throws IOException {
        String key = "A";
        long time = 1000L;

        playerNameState.step(key, gui, time, game);

        verify(drawPlayerNameModel, times(1)).draw(gui);
        verify(playerNameController, times(1)).toDo(game, key, time);
    }
    @Test
    void testGetDrawPlayerNameModel() {
        DrawPlayerName newDrawPlayerNameModel = mock(DrawPlayerName.class);
        playerNameState.setDrawPlayerNameModel(newDrawPlayerNameModel);

        assertEquals(newDrawPlayerNameModel, playerNameState.getDrawPlayerNameModel());
    }

    @Test
    void testGetPlayerNameController() {
        PlayerNameController newPlayerNameController = mock(PlayerNameController.class);
        playerNameState.setPlayerNameController(newPlayerNameController);

        assertEquals(newPlayerNameController, playerNameState.getPlayerNameController());
    }
}