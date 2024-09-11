package com.Carlos.spaceinvaders;

import com.Carlos.spaceinvaders.State.PlayerNameState;
import com.Carlos.spaceinvaders.State.State;
import com.Carlos.spaceinvaders.model.models.PlayerNameModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.SharedState;

import java.awt.*;
import java.io.IOException;
import java.util.Stack;

public class Game {

    private final LanternaGui GUI;
    public Stack<State> states;
    ;
    private State state;

    String Key;

    public boolean foundGameRecord(){
        return SharedState.foundGameRecord = true;
    }

    public Game() throws IOException, FontFormatException {
        this.GUI = new LanternaGui(getScreenSize().getX() / 25,getScreenSize().getY() / 25);
        this.states = new Stack<>();
        state = new PlayerNameState(new PlayerNameModel());
        this.states.push(state);
    }
    public State getCurrentState() {
        if (!states.isEmpty()) {
            return states.peek();
        }
        return null;
    }
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();
        } catch (IOException | InterruptedException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public void run() throws IOException, InterruptedException {
        int UPS = 50;
        int updateTime = 1000 / UPS;

        while (!this.states.isEmpty()) {
            long startTime = System.currentTimeMillis();
            Key = GUI.getUserInput();
            State currentState = states.peek();
            currentState.step(Key, GUI, startTime,this);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = updateTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pushState(State state) {
        this.states.push(state);
    }

    public void popState() {
        if (!states.isEmpty()) {
            states.pop();
        }
    }

    public LanternaGui getGUI(){
        return GUI;
    }

    public PositionModel getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new PositionModel(screenSize.width, screenSize.height);
    }

    public State getState() {
        return state;
    }
}