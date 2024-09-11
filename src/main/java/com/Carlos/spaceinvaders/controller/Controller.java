package com.Carlos.spaceinvaders.controller;

import com.Carlos.spaceinvaders.Game;

public abstract class Controller <T> {

    private final T model;
    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void toDo(Game game, String keyPressed, long Time);



}
