package com.Carlos.spaceinvaders.model.models;

import com.Carlos.spaceinvaders.HighScore;
import com.Carlos.spaceinvaders.model.models.PowerUpModel.PowerUpType;
import com.google.common.base.Splitter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;


public class PlayerModel extends Elements {

    private int hitPoints;
    private long delayShooting;
    private PowerUpType powerUpType;
    public static int i = 1;

    public PlayerModel(PositionModel position, int hitPoints){
        super(position);
        this.hitPoints = hitPoints;
        this.delayShooting = 500;
        this.powerUpType = null;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void incrementHitPoints(){
        if(getHitPoints() < 5)
            this.hitPoints++;
    }
    public void decrementHitPoints(){
        this.hitPoints--;
    }
    public void setDelayShooting(long delayShooting) {
        this.delayShooting = delayShooting;
    }
    public long getDelayShooting() {
        return delayShooting;
    }
    public PowerUpType getPowerUpType() {
        return powerUpType;
    }
    public void setPowerUpType(PowerUpType powerUpType) {
        this.powerUpType = powerUpType;
    }

    public String getPlayerNameModel() {

        if (Objects.equals(PlayerNameModel.name, "")) {
            int highestGuestNumber = findHighestGuestNumber();
            return "Guest" + (highestGuestNumber + 1);
        }

        return PlayerNameModel.name;
    }

    private int findHighestGuestNumber() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(HighScore.absolutePath));

            int highestGuestNumber = 1;

            for (String line : lines) {
                List<String> parts = Splitter.on(',').splitToList(line);
                if (parts.size() == 2) {
                    String storedPlayerName = parts.get(0);

                    if (storedPlayerName.startsWith("Guest")) {
                        try {
                            int guestNumber = Integer.parseInt(storedPlayerName.substring(5));
                            highestGuestNumber = Math.max(highestGuestNumber, guestNumber);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            return highestGuestNumber;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}