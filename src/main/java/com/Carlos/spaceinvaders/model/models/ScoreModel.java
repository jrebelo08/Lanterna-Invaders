package com.Carlos.spaceinvaders.model.models;

public class ScoreModel extends Elements{
    private int score;
    private int incrementValue;
    public ScoreModel(PositionModel position){
        super(position);
        this.score = 0;
        this.incrementValue = 1;
    }

    public int getScore() {
        return score;
    }


    public void incrementScore() {
        this.score += incrementValue;
    }

    public int getIncrementValue() {
        return incrementValue;
    }

    public void setIncrementValue(int incrementValue) {
        this.incrementValue = incrementValue;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
