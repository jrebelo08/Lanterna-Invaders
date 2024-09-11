package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class MonsterControllerFactoryTest {

    private MonsterControllerFactory monsterControllerFactory;
    private List<BulletModel> bullets;
    private List<MonsterModel> activeMonsters;
    private MonsterFactoryModel monsterFactoryModel;

    @BeforeEach
    public void setUp() {
        int arenaW = 100;
        int arenaH = 100;
        bullets = new ArrayList<>();
        activeMonsters = new ArrayList<>();
        monsterFactoryModel = mock(MonsterFactoryModel.class);
        monsterControllerFactory = new MonsterControllerFactory(arenaW, arenaH,bullets, activeMonsters,monsterFactoryModel);
    }

    @Test
    public void testCreateMonsterController() {
        MonsterModel monster = new MonsterModel(new PositionModel(10,5), 2);
        MonsterController monsterController = monsterControllerFactory.createMonsterController(monster);
        assertNotNull(monsterController);
    }

    @Test
    public void testCreateMonstersAndControllers() {
        long time = 1000;
        monsterControllerFactory.CreateMonstersAndControllers(time);
        List<MonsterController> monsterControllers = monsterControllerFactory.getMonstersControllers();
        assertEquals(activeMonsters.size(), monsterControllers.size());
    }

    @Test
    public void testGetMonstersControllers() {
        List<MonsterController> monsterControllers = monsterControllerFactory.getMonstersControllers();
        assertNotNull(monsterControllers);
        assertEquals(0, monsterControllers.size());
    }
}