package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifficultyControllerTest {

    private DifficultyController difficultyController;
    private MonsterFactoryModel monsterFactoryModel;
    private ScoreModel scoreModel;

    @BeforeEach
    public void setUp() {
        monsterFactoryModel = new MonsterFactoryModel();
        scoreModel = new ScoreModel(new PositionModel(10, 10));
        difficultyController = new DifficultyController(monsterFactoryModel, scoreModel);
    }

    @Test
    public void testToDoScoreMultipleOf75() {
        scoreModel.setScore(75);
        difficultyController.toDo(null, null, 0);

        assertEquals(1, monsterFactoryModel.getNumMonstros());
    }


    @Test
    public void testToDoScoreMultipleOf16() {
        scoreModel.setScore(16);
        difficultyController.toDo(null, null, 0);

        assertEquals(2925, monsterFactoryModel.getDelay());
    }

    @Test
    public void testToDoScoreNotMultipleOf75Or20() {
        scoreModel.setScore(50);

        difficultyController.toDo(null, null, 0);

        assertEquals(3000, monsterFactoryModel.getDelay());
        assertEquals(1, monsterFactoryModel.getNumMonstros());
    }


    @Test
    public void testToDoScoreZero() {
        scoreModel.setScore(0);

        difficultyController.toDo(null, null, 0);

        assertEquals(3000, monsterFactoryModel.getDelay());
        assertEquals(1, monsterFactoryModel.getNumMonstros());
    }
}
