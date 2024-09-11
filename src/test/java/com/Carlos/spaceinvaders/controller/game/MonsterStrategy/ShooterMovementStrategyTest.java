package com.Carlos.spaceinvaders.controller.game.MonsterStrategy;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.ShooterMovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ShooterMovementStrategyTest {

    private ShooterMovementStrategy shooterMovementStrategy;
    private MonsterModel monster;
    private PositionModel positionModel;
    private List<BulletModel> bullets;
    private List<MonsterModel> activeMonsters;

    @BeforeEach
    public void setUp() {
        monster = mock(MonsterModel.class);
        positionModel = new PositionModel(5, 5);
        when(monster.getPosition()).thenReturn(positionModel);
        when(monster.getSpeed()).thenReturn(1);
        bullets = new ArrayList<>();
        activeMonsters = new ArrayList<>();
        activeMonsters.add(monster);
        shooterMovementStrategy = new ShooterMovementStrategy(10, bullets, activeMonsters);
    }

    @Test
    public void testShootMonster() {
        shooterMovementStrategy.shootMonster(monster);
        assert bullets.size() == 1;

        activeMonsters.clear();
        shooterMovementStrategy.shootMonster(monster);
        assert bullets.size() == 1;
    }

    @Test
    public void testNewBullet() {
        BulletModel bullet = shooterMovementStrategy.newBullet(monster);
        assert bullet.getPosition().getX() == positionModel.getX();
        assert bullet.getPosition().getY() == positionModel.getY();
    }
}
