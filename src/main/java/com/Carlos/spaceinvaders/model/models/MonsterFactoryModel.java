package com.Carlos.spaceinvaders.model.models;

public class MonsterFactoryModel {

    private long delay;
    private int numMonstros;
    public MonsterFactoryModel(){
        this.delay = 3000;
        this.numMonstros = 1;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delayArg) {
        this.delay = delayArg;
    }

    public int getNumMonstros() {
        return numMonstros;
    }

    public void setNumMonstros(int numMonstros) {
        this.numMonstros = numMonstros;
    }
}
