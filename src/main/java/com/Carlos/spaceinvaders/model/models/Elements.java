package com.Carlos.spaceinvaders.model.models;

public abstract class Elements{
    
    protected PositionModel position;
    
    public Elements(PositionModel position){
        this.position = position;
    }
    
    public PositionModel getPosition() {
        return position;
    }

    public void setPosition(PositionModel position) {
        this.position = position;
    }
}
