package com.Carlos.spaceinvaders.model.models;


import java.util.ArrayList;
import java.util.List;


public class ArenaModel {


    private final int width;
    private final int height;

    private List<BulletModel> activeBullets;
    private List<WallModel> walls;
    private List<MonsterModel> activeMonsters;
    private List<PowerUpModel> activePowerUps;
    private MonsterFactoryModel monsterFactoryModel;
    private ScoreModel score;

    private PlayerModel player;

    public ArenaModel(int x, int y) {
        this.width = x;
        this.height = y;
        this.player = new PlayerModel(new PositionModel(40, y - 2), 3);
        this.score = new ScoreModel(new PositionModel(70, y - 3));
        this.monsterFactoryModel = new MonsterFactoryModel();
        this.activeBullets = new ArrayList<>();
        this.activeMonsters = new ArrayList<>();
        this.activePowerUps = new ArrayList<>();
        this.walls = new ArrayList<>();

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayerModel getPlayer() {
        return this.player;
    }

    public List<BulletModel> getActiveBullets() {
        return activeBullets;
    }

    public List<MonsterModel> getActiveMonsters() {
        return activeMonsters;
    }

    public List<WallModel> getWalls() {
        return walls;
    }

    public ScoreModel getScore() {
        return score;
    }

    public List<PowerUpModel> getActivePowerUps() {
        return activePowerUps;
    }

    public MonsterFactoryModel getMonsterFactoryModel() {
        return monsterFactoryModel;
    }
}