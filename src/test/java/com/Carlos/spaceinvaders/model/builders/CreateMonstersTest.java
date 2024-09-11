package com.Carlos.spaceinvaders.model.builders;


import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateMonstersTest {

    private CreateMonsters createMonsters;

    @BeforeEach
    public void setUp() {
        List<MonsterModel> activeMonsters = new ArrayList<>();
        createMonsters = new CreateMonsters(10, activeMonsters);
    }

    @Test
    public void testAddMonsters() {
        int numMonsters = 3;
        List<MonsterModel> monsters = createMonsters.addMonsters(numMonsters);

        Assertions.assertEquals(numMonsters, monsters.size());

        for (MonsterModel monster : monsters) {
            PositionModel position = monster.getPosition();
            Assertions.assertTrue(position.getX() >= 1 && position.getX() <= 10);
            Assertions.assertEquals(1, position.getY());
        }
    }
}
