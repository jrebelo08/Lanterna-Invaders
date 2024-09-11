package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterFactoryTest {

    private MonsterFactoryController monsterFactory;
    private List<MonsterModel> activeMonsters;

    @BeforeEach
    public void setUp() {
        MonsterFactoryModel monsterFactoryModel = new MonsterFactoryModel();
        activeMonsters = new ArrayList<>();
        monsterFactory = new MonsterFactoryController(monsterFactoryModel, activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsGreaterThanDelay() {
        long time = System.currentTimeMillis();
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertEquals(1, activeMonsters.size());
    }

    @Test
    public void testCreateMonster_WhenTimeIsLessThanDelay() {
        long time = 2999;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertTrue(activeMonsters.isEmpty());
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToDelay_ShouldReturnNull() {
        long time = 3000;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertTrue(activeMonsters.isEmpty());
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToDelayPlusOne_ShouldReturnNewMonsters() {
        long time = 3001;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertEquals(1, activeMonsters.size());
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToLastCreation_ShouldReturnNull() {
        long time = 0;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertTrue(activeMonsters.isEmpty());
    }
}