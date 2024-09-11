package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.gui.LanternaGui;

import java.io.IOException;

public abstract class State <T> {

    private final T model;
    public State(T model) {
        this.model = model;
    }
    public T getModel() {
        return model;
    }

    public abstract void step(String Key, LanternaGui GUI, long Time, Game game) throws IOException;
}
