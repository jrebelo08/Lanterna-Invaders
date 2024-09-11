package com.Carlos.spaceinvaders.model.models;


import java.util.Objects;

public class PositionModel {

        private int x;
        private int y;
        public PositionModel(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
        public int getX() {
            return x;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getY() {
            return y;
        }

        public void setPosition(PositionModel wantedPosition){
            this.x = wantedPosition.getX();
            this.y = wantedPosition.getY();
        }
        public PositionModel getRightBound(){
            return new PositionModel(x + 1,y);
        }
        public PositionModel getLeftBound(){
            return new PositionModel(x - 1,y);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PositionModel position = (PositionModel) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

